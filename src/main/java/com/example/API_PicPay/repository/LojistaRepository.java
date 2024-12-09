package com.example.API_PicPay.repository;

import com.example.API_PicPay.entity.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojistaRepository extends JpaRepository<Lojista, Long> {
}
