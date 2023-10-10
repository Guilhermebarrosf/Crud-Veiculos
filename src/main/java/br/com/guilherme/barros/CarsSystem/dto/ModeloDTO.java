package br.com.guilherme.barros.CarsSystem.dto;

import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
    public class ModeloDTO {

    private Long id;
    private Long marca_id;
    private String nome;
    private Double valor_fipe;


    public static ModeloDTO toDTO(Modelo modelo) {
        return ModeloDTO.builder()
                .id(modelo.getId())
                .marca_id(modelo.getMarca() != null ? modelo.getMarca().getId() : null)
                .nome(modelo.getNome())
                .valor_fipe(modelo.getValorFipe()).build();
    }

    public static Modelo toEntity(ModeloDTO modeloDTO) {
        return new Modelo(
                modeloDTO.getId(),
                new Marca(modeloDTO.getMarca_id()),
                modeloDTO.getNome(),
                modeloDTO.getValor_fipe());
    }
}