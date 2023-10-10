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
    static IMarcaRepository iMarcaRepository;

    @Autowired
    public CarroRegras(IModeloRepository iModeloRepository,IMarcaRepository iMarcaRepository) {
        this.iModeloRepository = iModeloRepository;
        this.iMarcaRepository = iMarcaRepository;
    }

    public void beforeDatabaseAction(Carro carro) throws Exception {
        if(carro.getNumPortas() <= Constantes.QUANTIDADE_MIN_PORTAS_CARRO){
            throw new Exception("Quantidade Mínima de portas é 2");
        }

        if(carro.getModelo().getId() == null){
            throw new Exception("Modelo Obrigatório");
        }else{
            Optional<Long> idModelo = iModeloRepository.isExist(carro.getModelo().getId());
            if(!idModelo.isPresent()){
                throw new Exception("Modelo Não Registrado");
            }
        }

        if(carro.getModelo().getMarca().getId() == null){
            throw new Exception("Marca Obrigatória");
        }else{
            Optional<Long> idMarca = iMarcaRepository.isExist(carro.getModelo().getMarca().getId());
            if(!idMarca.isPresent()){
                throw new Exception("Marca Não Registrada");
            }
        }
    }

}
