package com.example.API_PicPay.service;

import com.example.API_PicPay.entity.Cliente;
import com.example.API_PicPay.exception.IdNotFoundException;
import com.example.API_PicPay.exception.NameNotFoundException;
import com.example.API_PicPay.exception.NameUniqueException;
import com.example.API_PicPay.repository.ClienteRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClienteService {

    public final ClienteRepository repository;
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente create(Cliente cliente){
        try {
            return repository.save(cliente);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new NameUniqueException("Informações já cadastradas em nosso Banco de Dados!");
        }
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new IdNotFoundException(String.format("Cliente com o id(%d) não encontrado!", id)));
    }

    public Cliente findByEmail(String email){
        return repository.findByEmail(email).orElseThrow(() ->
                new NameNotFoundException(String.format("Cliente com o email(%s) não encontrado!", email)));
    }

    public void deleteByEmail(String email){
        Cliente pessoa = findByEmail(email);
        repository.delete(pessoa);
    }

    public Cliente updatePassword(Long id, String senhaAtual, String novaSenha, String repitaSenha){
        Cliente cliente = findById(id);
        if (!cliente.getSenha().equals(senhaAtual)){
            throw new RuntimeException("Senha diferente da atual!");
        }
        if (!novaSenha.equals(repitaSenha)){
            throw new RuntimeException("Senhas incompatíveis!");
        }

        cliente.setSenha(novaSenha);
        return repository.save(cliente);
    }

}
