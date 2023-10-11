package br.com.guilherme.barros.CarsSystem.controllers;

import br.com.guilherme.barros.CarsSystem.dto.ModeloDTO;
import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import br.com.guilherme.barros.CarsSystem.model.modelo.ModeloRegras;
import br.com.guilherme.barros.CarsSystem.repository.modelo.IModeloRepository;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static br.com.guilherme.barros.CarsSystem.util.UtilException.mensagemExceptionTratada;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    IModeloRepository iModeloRepository;

    private final ModeloRegras modeloRegras;

    @Autowired
    public ModeloController(ModeloRegras modeloRegras) {
        this.modeloRegras = modeloRegras;
    }

    @PostMapping("/incluir")
    public ResponseEntity<String> incluir(@RequestBody ModeloDTO modeloDTO) {
        try {
            Modelo modelo = ModeloDTO.toEntity(modeloDTO);
            modeloRegras.beforeDatabaseAction(modelo);
            iModeloRepository.save(modelo);
            return new ResponseEntity<>(Constantes.SUCESS_SAVE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(e);        }
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editar(@RequestBody ModeloDTO modeloDTO) {
        try {
            Modelo modelo = ModeloDTO.toEntity(modeloDTO);
            modeloRegras.beforeDatabaseAction(modelo);
            iModeloRepository.save(modelo);
            return new ResponseEntity<>(Constantes.SUCESS_EDIT, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return mensagemExceptionTratada(e);
        }
    }

    @DeleteMapping("/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            Optional<Modelo> modelo = iModeloRepository.findById(id);

            if (!modelo.isPresent()) return new ResponseEntity<>(HttpStatus.OK);

            iModeloRepository.delete(modelo.get());
            return new ResponseEntity<>(Constantes.SUCESS_DELETE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return mensagemExceptionTratada(e);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Map<String, List<ModeloDTO>>> listar() {
        try {

            List<Modelo> listaDeModelos = iModeloRepository.findAll();
            List<ModeloDTO> listaDeModelosDTO = new ArrayList<>();

            listaDeModelos.forEach((modelo) -> {
                ModeloDTO modeloDTO = ModeloDTO.toDTO(modelo);
                listaDeModelosDTO.add(modeloDTO);
            });
            Map<String, List<ModeloDTO>> response = new HashMap<>();
            response.put("models", listaDeModelosDTO);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(new Exception(Constantes.LIST_ERROR));
        }
    }
}
