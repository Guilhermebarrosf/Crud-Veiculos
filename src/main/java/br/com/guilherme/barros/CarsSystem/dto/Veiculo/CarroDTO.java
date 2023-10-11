package br.com.guilherme.barros.CarsSystem.dto.Veiculo;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Year;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarroDTO {
    private Long id;
    private Long timestamp_cadastro;
    private Long modelo_id;
    private Integer ano;
    private String combustivel;
    private String cor;
    private Integer num_portas;
    private String nome_modelo;
    private Double valor;



    public static CarroDTO toDTO(Carro carro) {
        return CarroDTO.builder()
                .id(carro.getId())
                .timestamp_cadastro(carro.getCreateDateTime())
                .modelo_id(carro.getModelo() != null ? carro.getModelo().getId() : null)
                .ano(carro.getAno())
                .combustivel(carro.getCombustivel())
                .num_portas(carro.getNumPortas())
                .cor(carro.getCor())
                .nome_modelo(carro.getModelo() != null ? carro.getModelo().getNome() : null)
                .valor( carro.getModelo() != null ? carro.getModelo().getValorFipe() : null).build();
    }

    public static Carro toEntity(CarroDTO carroDTO){
        Carro carro = new Carro(
                carroDTO.getId(),
                carroDTO.getTimestamp_cadastro(),
                carroDTO.getModelo_id() != null ? new Modelo(carroDTO.getModelo_id()) : null,
                carroDTO.getAno(),
                carroDTO.getCombustivel(),
                carroDTO.getCor(),
                carroDTO.getNum_portas());
        return carro;
    }
}
