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

import com.example.estacionamento.models.Veiculos;
import com.example.estacionamento.repositories.VeiculosRepository;

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
	
	@PostMapping("/veiculos/post")
	public Veiculos saveVeiculo(@RequestBody Veiculos veiculo) {
		return repository.save(veiculo);
	}
	
	@PutMapping("/veiculos/update/{id}")
	public ResponseEntity<Veiculos> update(@PathVariable("id") long id, @RequestBody Veiculos veiculo) {
		Optional<Veiculos> veiculoData = repository.findById(id);
		if (veiculoData.isPresent()){
			Veiculos _veiculos = veiculoData.get();
			_veiculos.setPlaca(veiculo.getPlaca());
			_veiculos.setMarca(veiculo.getMarca());
			_veiculos.setModelo(veiculo.getModelo());
			_veiculos.setAno(veiculo.getAno());
			return new ResponseEntity<>(repository.save(_veiculos), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/veiculos/delete/{id}")
	public void deleteVeiculo(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
