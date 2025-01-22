package com.example.API_PicPay.service;

import com.example.API_PicPay.entity.Cliente;
import com.example.API_PicPay.entity.Role;
import com.example.API_PicPay.entity.Transacao;
import com.example.API_PicPay.exception.ListNotFoundException;
import com.example.API_PicPay.exception.NameNotFoundException;
import com.example.API_PicPay.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransacaoService {

    public final TransacaoRepository repository;
    public final ClienteService service;
    public TransacaoService(TransacaoRepository repository, ClienteService service) {
        this.repository = repository;
        this.service = service;
    }

    public Transacao create(Transacao transacao){
        Cliente remetente1 = service.findByEmail(transacao.getRemetente());
        Cliente destinatario1 = service.findByEmail(transacao.getDestinatario());

        if (remetente1.getRole().equals(Role.ROLE_LOJA)){
            throw new RuntimeException("PJ estão impossibilitadas de realizar transferências!");
        }

        if (!remetente1.getSenha().equals(transacao.getSenhaRemetente())){
            throw new RuntimeException("Senha incorreta!");
        }

        if (remetente1.getSaldo().compareTo(transacao.getValor()) > 0){
            remetente1.setSaldo(remetente1.getSaldo().subtract(transacao.getValor()));
            destinatario1.setSaldo(destinatario1.getSaldo().add(transacao.getValor()));
        } else {
            throw new RuntimeException("Limite excedido!");
        }

        return repository.save(transacao);
    }

    public List<Transacao> findAll(){
        return repository.findAll();
    }

    public List<Transacao> findByRemetente(String email){
        List<Transacao> transacaos = repository.findByRemetente(email);

        if (transacaos.isEmpty()){
            throw new ListNotFoundException(String.format("Transações com o email de remetente (%s), não encontrada!", email));
        }
        return transacaos;
    }

    public List<Transacao> findByDestinatario(String email){
        List<Transacao> transacaos = repository.findByDestinatario(email);

        if (transacaos.isEmpty()){
            throw new ListNotFoundException(String.format("Transações com o email de destinatário (%s), não encontrada!", email));
        }
        return transacaos;
    }
}
