package com.casos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Sms;

@Repository
public interface AdminSmsRepository extends JpaRepository<Sms, Long> {

	Sms save(Sms sms);	
	
}
