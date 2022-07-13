package com.example.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.models.Vagas;

public interface VagasRepository extends JpaRepository<Vagas, Long>{
	
}
