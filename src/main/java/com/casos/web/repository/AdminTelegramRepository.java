package com.casos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.MensajesTelegram;

@Repository
public interface AdminTelegramRepository extends JpaRepository<MensajesTelegram, Long>{
}
