package br.com.guilherme.barros.CarSystem.regras;

import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.modelo.ModeloRegras;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.CarroRegras;
import br.com.guilherme.barros.CarsSystem.repository.marca.IMarcaRepository;
import br.com.guilherme.barros.CarsSystem.repository.modelo.IModeloRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModeloRegrasTest {

    IMarcaRepository iMarcaRepository;
    ModeloRegras modeloRegras;

    @BeforeAll
    public void initTest() {
        iMarcaRepository = mock(IMarcaRepository.class);
        modeloRegras = new ModeloRegras(iMarcaRepository);
    }

    @Test
    public void deve_retornar_exception_se_marca_id_null() {
        Modelo modelo = new Modelo();
        modelo.setMarca(new Marca());

        try {
            modeloRegras.beforeDatabaseAction(modelo);
        } catch (Exception e) {
            assertEquals(Constantes.ERROR_MARCA_OBRIGATORIA, e.getMessage());
        }

    }

    @Test
    public void deve_retornar_exception_se_marca_id_nao_existir() {
        Modelo modelo = new Modelo();
        modelo.setMarca(new Marca(1L));
        Mockito.when(iMarcaRepository.isExist(any())).thenReturn(Optional.empty());
        try {
            modeloRegras.beforeDatabaseAction(modelo);
        } catch (Exception e) {
            assertEquals(Constantes.ERROR_MARCA_NAO_REGISTRADA, e.getMessage());
        }

    }
}
