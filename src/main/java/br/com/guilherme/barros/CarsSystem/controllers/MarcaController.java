package br.com.guilherme.barros.CarsSystem.controllers;

import br.com.guilherme.barros.CarsSystem.dto.MarcaDTO;
import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import br.com.guilherme.barros.CarsSystem.repository.marca.IMarcaRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static br.com.guilherme.barros.CarsSystem.util.UtilException.mensagemExceptionTratada;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    IMarcaRepository iMarcaRepository;

    @PostMapping("/incluir")
    public ResponseEntity<String> incluir(@RequestBody MarcaDTO marcaDTO) {
        try {
            Marca marca = MarcaDTO.toEntity(marcaDTO);
            iMarcaRepository.save(marca);
            return new ResponseEntity<>(Constantes.SUCESS_SAVE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(e);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editar(@RequestBody MarcaDTO marcaDTO) {
        try {
            Marca marca = MarcaDTO.toEntity(marcaDTO);
            iMarcaRepository.save(marca);
            return new ResponseEntity<>(Constantes.SUCESS_EDIT, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(e);
        }
    }

    @DeleteMapping("/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            Optional<Marca> marca = iMarcaRepository.findById(id);

            if (!marca.isPresent()) return new ResponseEntity<>(HttpStatus.OK);

            iMarcaRepository.delete(marca.get());
            return new ResponseEntity<>(Constantes.SUCESS_DELETE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(e);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Map<String, List<MarcaDTO>>> listar() {
        try {

            List<Marca> listaDeMarcas = iMarcaRepository.findAll();
            List<MarcaDTO> listaDeMarcasDTO = new ArrayList<>();

            listaDeMarcas.forEach((marca) -> {
                MarcaDTO marcaDTO = MarcaDTO.toDTO(marca);
                listaDeMarcasDTO.add(marcaDTO);
            });
            Map<String, List<MarcaDTO>> response = new HashMap<>();
            response.put("marcas", listaDeMarcasDTO);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(new Exception(Constantes.LIST_ERROR));
        }
    }
}
