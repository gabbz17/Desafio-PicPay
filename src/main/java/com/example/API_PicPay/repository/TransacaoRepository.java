package com.example.API_PicPay.repository;

import com.example.API_PicPay.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByRemetente(String email);
    List<Transacao> findByDestinatario(String email);
}
