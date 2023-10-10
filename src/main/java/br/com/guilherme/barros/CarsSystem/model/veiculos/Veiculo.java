package br.com.guilherme.barros.CarsSystem.model.veiculos;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public abstract class Veiculo {

    private Long id;
    private LocalDateTime createDateTime;
    private Modelo modelo;
    private Date ano;
    private String combustivel;
    private String cor;

}
