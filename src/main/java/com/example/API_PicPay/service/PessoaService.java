package com.example.API_PicPay.service;

import com.example.API_PicPay.entity.Pessoa;
import com.example.API_PicPay.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    public final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa create(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id){
        return pessoaRepository.findById(id).get();
    }

    public Pessoa findByEmail(String email){
        return pessoaRepository.findByEmail(email).get();
    }

    public void deleteByEmail(String email){
        Pessoa pessoa = findByEmail(email);
        pessoaRepository.delete(pessoa);
    }
}
