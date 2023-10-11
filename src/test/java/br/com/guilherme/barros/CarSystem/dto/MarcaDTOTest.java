package br.com.guilherme.barros.CarSystem.dto;

import br.com.guilherme.barros.CarsSystem.dto.MarcaDTO;
import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MarcaDTOTest {

    @Test
    public void deve_retornar_dto_vazio_se_marca_vazio(){
        Marca marca = new Marca();
        MarcaDTO marcaDTO = MarcaDTO.toDTO(marca);

        assertNull(marcaDTO.getId());
        assertNull(marcaDTO.getNome_marca());
    }
    @Test
    public void deve_retornar_dto_completo_se_modelo_completo(){
        Marca marca = new Marca();
        marca.setId(1L);
        marca.setNomeMarca("teste");


        MarcaDTO marcaDTO = MarcaDTO.toDTO(marca);

        assertEquals(marca.getId(), marcaDTO.getId());
        assertEquals(marca.getNomeMarca(), marcaDTO.getNome_marca());

    }
    @Test
    public void deve_retornar_modelo_vazio_se_dto_vazio(){
        MarcaDTO marcaDTO = new MarcaDTO();
        Marca marca = MarcaDTO.toEntity(marcaDTO);

        assertNull(marca.getId());
        assertNull(marca.getNomeMarca());
    }
    @Test
    public void deve_retornar_modelo_completo_se_dto_completo(){
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setId(1L);
        marcaDTO.setNome_marca("teste");

        Marca marca = MarcaDTO.toEntity(marcaDTO);

        assertEquals(marcaDTO.getId(), marca.getId());
        assertEquals(marcaDTO.getNome_marca(), marca.getNomeMarca());

    }
}
