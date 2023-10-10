package br.com.guilherme.barros.CarsSystem.model.veiculos.carro;

import br.com.guilherme.barros.CarsSystem.util.Constantes;

public class CarroRegras {

    public static void beforeInsert(Carro carro) throws Exception {
        if(carro.getNumPortas() <= Constantes.QUANTIDADE_MIN_PORTAS_CARRO){
            throw new Exception("Quantidade Mínima de portas é 2");
        }
    }
}
