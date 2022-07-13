package com.example.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.models.Veiculos;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{
	
}
