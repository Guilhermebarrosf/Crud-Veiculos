package br.com.guilherme.barros.CarsSystem.model.veiculos.carro;

import br.com.guilherme.barros.CarsSystem.repository.marca.IMarcaRepository;
import br.com.guilherme.barros.CarsSystem.repository.modelo.IModeloRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroRegras {

    static IModeloRepository iModeloRepository;

    @Autowired
    public CarroRegras(IModeloRepository iModeloRepository) {
        this.iModeloRepository = iModeloRepository;
    }

    public void beforeDatabaseAction(Carro carro) throws Exception {
        if(carro.getNumPortas() != null && carro.getNumPortas() < Constantes.QUANTIDADE_MIN_PORTAS_CARRO){
            throw new Exception(Constantes.ERROR_QUANTIDADE_MINIMA);
        }

        if(carro.getModelo() != null && carro.getModelo().getId() == null){
            throw new Exception(Constantes.ERROR_MODELO_OBRIGATORIO);
        }else if(carro.getModelo() != null){
            Optional<Long> idModelo = iModeloRepository.isExist(carro.getModelo().getId());
            if(!idModelo.isPresent()){
                throw new Exception(Constantes.ERROR_MODELO_NAO_REGISTRADO);
            }
        }
    }

}
