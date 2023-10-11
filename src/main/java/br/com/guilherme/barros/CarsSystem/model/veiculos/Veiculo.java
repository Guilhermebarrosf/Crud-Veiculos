package br.com.guilherme.barros.CarsSystem.model.veiculos;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp_cadastro")
    private Long createDateTime;

    @ManyToOne
    private Modelo modelo;
    private Integer ano;
    private String combustivel;
    private String cor;

}
