package com.example.estacionamento.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vagas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    String endereco;
	String cor;
    String placaVeiculoAlocado;
    Boolean vago = true;
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlacaVeiculoAlocado() {
        Veiculos vehicles = new Veiculos();
        if (vehicles.endereco != null) {
            vehicles.getPlaca();
        }
        return placaVeiculoAlocado;
    }
    public void setPlacaCarroAlocado(String placaVeiculoAlocado) {
        this.placaVeiculoAlocado = placaVeiculoAlocado;
    }

    public Boolean getVago() {
        return vago;
    }
    public void setVago(Boolean vago) {
        this.vago = vago;
    }
}
