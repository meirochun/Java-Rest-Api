package com.example.estacionamento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.estacionamento.models.Vagas;
import com.example.estacionamento.repositories.VagasRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VagasController {
	
	@Autowired
	VagasRepository repository;
	
	@GetMapping("/vagas")
	public List<Vagas> getAllVagas(){
		return repository.findAll();
	}
	
	@GetMapping("/vagas/{id}")
	public Vagas getVagaById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/vagas/post")
	public Vagas saveVeiculo(@RequestBody Vagas vaga) {
		return repository.save(vaga);
	}
	
	@PutMapping("/vagas/update/{id}")
	public ResponseEntity<Vagas> update(@PathVariable("id") long id, @RequestBody Vagas vagas) {
		Optional<Vagas> vagaData = repository.findById(id);
		if (vagaData.isPresent()){
			Vagas _vagas = vagaData.get();
			_vagas.setEndereco(vagas.getEndereco());
			_vagas.setCor(vagas.getCor());
			return new ResponseEntity<>(repository.save(_vagas), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/vagas/delete/{id}")
	public void deleteVeiculo(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
