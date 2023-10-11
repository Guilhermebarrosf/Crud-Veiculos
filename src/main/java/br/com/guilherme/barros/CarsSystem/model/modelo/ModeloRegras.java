package br.com.guilherme.barros.CarsSystem.model.modelo;

import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import br.com.guilherme.barros.CarsSystem.repository.marca.IMarcaRepository;
import br.com.guilherme.barros.CarsSystem.repository.modelo.IModeloRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeloRegras {
    static IMarcaRepository iMarcaRepository;

    @Autowired
    public ModeloRegras(IMarcaRepository iMarcaRepository) {
        this.iMarcaRepository = iMarcaRepository;
    }

    public void beforeDatabaseAction(Modelo modelo) throws Exception {

        if (modelo.getMarca() != null && modelo.getMarca().getId() == null) {
            throw new Exception(Constantes.ERROR_MARCA_OBRIGATORIA);
        } else if(modelo.getMarca() != null){
            Optional<Long> idMarca = iMarcaRepository.isExist(modelo.getMarca().getId());
            if (!idMarca.isPresent()) {
                throw new Exception(Constantes.ERROR_MARCA_NAO_REGISTRADA);
            }
        }
    }
}
