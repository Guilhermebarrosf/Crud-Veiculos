package br.com.guilherme.barros.CarsSystem.model.veiculos.carro;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.veiculos.Veiculo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Carro extends Veiculo {
    private Integer numPortas;

    public Carro(Long id, LocalDateTime createDateTime, Modelo modelo, Date ano, String combustivel, String cor, Integer numPortas) {
        super(id, createDateTime, modelo, ano, combustivel, cor);
        this.numPortas = numPortas;
    }
}
