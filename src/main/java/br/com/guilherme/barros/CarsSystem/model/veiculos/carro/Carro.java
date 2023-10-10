package br.com.guilherme.barros.CarsSystem.model.veiculos.carro;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.veiculos.Veiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
public class Carro extends Veiculo {

    private Integer numPortas;

    public Carro(Long id, Date createDateTime, Modelo modelo, Date ano, String combustivel, String cor, Integer numPortas) {
        super(id, createDateTime, modelo, ano, combustivel, cor);
        this.numPortas = numPortas;
    }

    public Carro() {
        super();
    }
}
