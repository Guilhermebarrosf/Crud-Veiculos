package br.com.guilherme.barros.CarsSystem.dto;

import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {

    private Long id;
    private String nome_marca;

    public static MarcaDTO toDTO(Marca marca){
        return MarcaDTO.builder()
                .id(marca.getId())
                .nome_marca(marca.getNomeMarca()).build();
    }

    public static Marca toEntity(MarcaDTO marcaDTO){
        return new Marca(
                marcaDTO.getId(),
                marcaDTO.getNome_marca());
    }

}
