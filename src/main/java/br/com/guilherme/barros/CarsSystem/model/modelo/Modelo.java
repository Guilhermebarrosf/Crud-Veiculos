package br.com.guilherme.barros.CarsSystem.model.modelo;

import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Marca marca;
    private String nome;
    private Double valorFipe;

    public Modelo(Long idModelo, Long idMarca){
        this.id = idModelo;
        this.marca = new Marca(idMarca);
    }


}
