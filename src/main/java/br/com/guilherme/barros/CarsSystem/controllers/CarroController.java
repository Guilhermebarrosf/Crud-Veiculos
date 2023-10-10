package br.com.guilherme.barros.CarsSystem.controllers;

import br.com.guilherme.barros.CarsSystem.dto.CarroDTO;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.CarroRegras;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @PostMapping("/")
    public void incluir(@RequestBody CarroDTO carroDTO){
        Carro carro = CarroDTO.toEntity(carroDTO);
        try{
            CarroRegras.beforeInsert(carro);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
