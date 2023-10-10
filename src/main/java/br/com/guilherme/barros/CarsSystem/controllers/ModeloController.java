package br.com.guilherme.barros.CarsSystem.controllers;

import br.com.guilherme.barros.CarsSystem.dto.MarcaDTO;
import br.com.guilherme.barros.CarsSystem.dto.ModeloDTO;
import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.repository.marca.IMarcaRepository;
import br.com.guilherme.barros.CarsSystem.repository.modelo.IModeloRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    IModeloRepository iModeloRepository;

    @PostMapping("/incluir")
    public ResponseEntity<String> incluir(@RequestBody ModeloDTO modeloDTO) {
        try {
            Modelo modelo = ModeloDTO.toEntity(modeloDTO);
            iModeloRepository.save(modelo);
            return new ResponseEntity<>(Constantes.SUCESS_SAVE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
