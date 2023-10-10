package br.com.guilherme.barros.CarsSystem.dto.Veiculo;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CarroDTO {
    private Long id;
    private Date timestamp_cadastro;
    private Long modelo_id;
    private Date ano;
    private String combustivel;
    private String cor;
    private Integer num_portas;
    private String nome_modelo;
    private Double valor;
    private Long marca_id;
    private String marca_nome;


    public static CarroDTO toDTO(Carro carro) {
        return CarroDTO.builder()
                .id(carro.getId())
                .timestamp_cadastro(carro.getCreateDateTime())
                .modelo_id(carro.getModelo().getId())
                .ano(carro.getAno())
                .combustivel(carro.getCombustivel())
                .num_portas(carro.getNumPortas())
                .cor(carro.getCor())
                .nome_modelo(carro.getModelo().getNome())
                .valor(carro.getModelo().getValorFipe()).build();
    }

    public static Carro toEntity(CarroDTO carroDTO){
        Carro carro = new Carro(
                carroDTO.getId(),
                carroDTO.getTimestamp_cadastro(),
                new Modelo(carroDTO.getModelo_id(), carroDTO.getMarca_id()),
                carroDTO.getAno(),
                carroDTO.getCombustivel(),
                carroDTO.getCor(),
                carroDTO.getNum_portas());
        return carro;
    }
}
