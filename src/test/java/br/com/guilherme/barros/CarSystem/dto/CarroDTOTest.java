package br.com.guilherme.barros.CarSystem.dto;

import br.com.guilherme.barros.CarsSystem.dto.Veiculo.CarroDTO;
import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CarroDTOTest {

    @Test
    public void deve_retornar_dto_vazio_se_carro_vazio() {
        Carro carro = new Carro();
        CarroDTO carroDTO = CarroDTO.toDTO(carro);

        assertNull(carroDTO.getId());
        assertNull(carroDTO.getTimestamp_cadastro());
        assertNull(carroDTO.getCor());
        assertNull(carroDTO.getValor());
        assertNull(carroDTO.getCombustivel());
        assertNull(carroDTO.getModelo_id());
        assertNull(carroDTO.getAno());
        assertNull(carroDTO.getNum_portas());
        assertNull(carroDTO.getNome_modelo());
    }

    @Test
    public void deve_retornar_dto_completo_se_carro_completo() {
        Modelo modelo = new Modelo();
        modelo.setNome("teste");
        modelo.setId(1L);

        Carro carro = new Carro();
        carro.setId(1L);
        carro.setNumPortas(4);
        carro.setCor("teste");
        carro.setModelo(modelo);
        carro.setCreateDateTime(2019123123L);
        carro.setCombustivel("teste");
        carro.setAno(2014);


        CarroDTO carroDTO = CarroDTO.toDTO(carro);

        assertEquals(carro.getId(), carroDTO.getId());
        assertEquals(carro.getCreateDateTime(), carroDTO.getTimestamp_cadastro());
        assertEquals(carro.getCor(), carroDTO.getCor());
        assertEquals(carro.getModelo().getValorFipe(), carroDTO.getValor());
        assertEquals(carro.getCombustivel(), carroDTO.getCombustivel());
        assertEquals(carro.getModelo().getId(), carroDTO.getModelo_id());
        assertEquals(carro.getAno(), carroDTO.getAno());
        assertEquals(carro.getNumPortas(), carroDTO.getNum_portas());
        assertEquals(carro.getModelo().getNome(), carroDTO.getNome_modelo());
    }

    @Test
    public void deve_retornar_entity_vazio_se_carroDTO_vazio() {
        CarroDTO carroDTO = new CarroDTO();
        Carro carro = CarroDTO.toEntity(carroDTO);

        assertNull(carro.getId());
        assertNull(carro.getCreateDateTime());
        assertNull(carro.getCor());
        assertNull(carro.getModelo());
        assertNull(carro.getCombustivel());
        assertNull(carro.getAno());
        assertNull(carro.getNumPortas());
    }

    @Test
    public void deve_retornar_carro_completo_se_dto_completo() {

        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(1L);
        carroDTO.setNum_portas(4);
        carroDTO.setCor("teste");
        carroDTO.setModelo_id(1L);
        carroDTO.setTimestamp_cadastro(2019123123L);
        carroDTO.setCombustivel("teste");
        carroDTO.setAno(2014);


        Carro carro = CarroDTO.toEntity(carroDTO);

        assertEquals(carroDTO.getId(), carro.getId());
        assertEquals(carroDTO.getTimestamp_cadastro(), carro.getCreateDateTime());
        assertEquals(carroDTO.getCor(), carro.getCor());
        assertEquals(carroDTO.getCombustivel(), carro.getCombustivel());
        assertEquals(carroDTO.getModelo_id(), carro.getModelo().getId());
        assertEquals(carroDTO.getAno(), carro.getAno());
        assertEquals(carroDTO.getNum_portas(), carro.getNumPortas());
    }
}
