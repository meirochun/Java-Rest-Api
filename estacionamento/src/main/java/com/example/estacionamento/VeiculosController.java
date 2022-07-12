package com.example.estacionamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VeiculosController {
	
	@Autowired
	VeiculosRepository repository;
	
	@GetMapping("/veiculos")
	public List<Veiculos> getAllVeiculos(){
		return repository.findAll();
	}
	
	@GetMapping("/veiculos/{id}")
	public Veiculos getVeiculoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/veiculos")
	public Veiculos saveVeiculo(@RequestBody Veiculos veiculo) {
		return repository.save(veiculo);
	}
	
	@PutMapping("/veiculos/{id}")
	public Veiculos updateVeiculo(@RequestBody Veiculos veiculo) {
		return repository.save(veiculo);
	}
	
	@DeleteMapping("/veiculos/{id}")
	public void deleteVeiculo(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
