package br.com.guilherme.barros.CarsSystem.model.modelo;

import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Modelo {

    private Long id;
    private Marca marca;
    private String nome;
    private Double valorFipe;

    public Modelo(Long id){
        this.id = id;
    }


}
