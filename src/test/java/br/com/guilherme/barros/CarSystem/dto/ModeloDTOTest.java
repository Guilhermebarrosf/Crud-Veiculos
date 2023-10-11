package br.com.guilherme.barros.CarSystem.dto;

import br.com.guilherme.barros.CarsSystem.dto.ModeloDTO;
import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ModeloDTOTest {

    @Test
    public void deve_retornar_dto_vazio_se_modelo_vazio() {
        Modelo modelo = new Modelo();
        ModeloDTO modeloDTO = ModeloDTO.toDTO(modelo);

        assertNull(modeloDTO.getId());
        assertNull(modeloDTO.getNome());
        assertNull(modeloDTO.getValor_fipe());
        assertNull(modeloDTO.getMarca_id());
    }

    @Test
    public void deve_retornar_dto_completo_se_modelo_completo() {
        Modelo modelo = new Modelo();
        modelo.setId(1L);
        modelo.setMarca(new Marca(1L));
        modelo.setNome("teste");
        modelo.setValorFipe(29.000);

        ModeloDTO modeloDTO = ModeloDTO.toDTO(modelo);

        assertEquals(modelo.getId(), modeloDTO.getId());
        assertEquals(modelo.getNome(), modeloDTO.getNome());
        assertEquals(modelo.getValorFipe(), modeloDTO.getValor_fipe());
        assertEquals(modelo.getMarca().getId(), modeloDTO.getMarca_id());
    }

    @Test
    public void deve_retornar_modelo_vazio_se_dto_vazio() {
        ModeloDTO modeloDTO = new ModeloDTO();
        Modelo modelo = ModeloDTO.toEntity(modeloDTO);

        assertNull(modelo.getId());
        assertNull(modelo.getNome());
        assertNull(modelo.getValorFipe());
        assertNull(modelo.getMarca());
    }

    @Test
    public void deve_retornar_modelo_completo_se_dto_completo() {
        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setId(1L);
        modeloDTO.setMarca_id(1L);
        modeloDTO.setNome("teste");
        modeloDTO.setValor_fipe(29.000);

        Modelo modelo = ModeloDTO.toEntity(modeloDTO);

        assertEquals(modeloDTO.getId(), modelo.getId());
        assertEquals(modeloDTO.getNome(), modelo.getNome());
        assertEquals(modeloDTO.getValor_fipe(), modelo.getValorFipe());
        assertEquals(modeloDTO.getMarca_id(), modelo.getMarca().getId());
    }

}
