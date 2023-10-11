package br.com.guilherme.barros.CarSystem.regras;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.CarroRegras;
import br.com.guilherme.barros.CarsSystem.repository.modelo.IModeloRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarroRegrasTest {

    IModeloRepository iModeloRepository;
    CarroRegras carroRegras;

    @BeforeAll
    public void initTest(){
        iModeloRepository = mock(IModeloRepository.class);
        carroRegras = new CarroRegras(iModeloRepository);
    }

    @Test
    public void deve_retornar_exception_se_portas_menor_que_2(){
        Carro carro = new Carro();
        carro.setNumPortas(1);
        try {
            carroRegras.beforeDatabaseAction(carro);
        } catch (Exception e) {
            assertEquals(Constantes.ERROR_QUANTIDADE_MINIMA, e.getMessage());
        }

    }
    @Test
    public void deve_retornar_exception_se_modelo_id_null(){
        Carro carro = new Carro();
        carro.setNumPortas(2);
        carro.setModelo(new Modelo());

        try {
            carroRegras.beforeDatabaseAction(carro);
        } catch (Exception e) {
            assertEquals(Constantes.ERROR_MODELO_OBRIGATORIO, e.getMessage());
        }

    }
    @Test
    public void deve_retornar_exception_se_modelo_id_nao_existir(){
        Carro carro = new Carro();
        carro.setModelo(new Modelo(1L));
        Mockito.when(iModeloRepository.isExist(any())).thenReturn(Optional.empty());
        try {
            carroRegras.beforeDatabaseAction(carro);
        } catch (Exception e) {
            assertEquals(Constantes.ERROR_MODELO_NAO_REGISTRADO, e.getMessage());
        }

    }
}
