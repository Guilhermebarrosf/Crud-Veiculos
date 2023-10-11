package br.com.guilherme.barros.CarsSystem.controllers.Veiculo;

import br.com.guilherme.barros.CarsSystem.repository.veiculos.carro.ICarroRepository;
import br.com.guilherme.barros.CarsSystem.dto.Veiculo.CarroDTO;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.CarroRegras;
import br.com.guilherme.barros.CarsSystem.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static br.com.guilherme.barros.CarsSystem.util.UtilException.mensagemExceptionTratada;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    ICarroRepository iCarroRepository;
    private final CarroRegras carroRegras;

    @Autowired
    public CarroController(CarroRegras carroRegras) {
        this.carroRegras = carroRegras;
    }

    @PostMapping("/incluir")
    public ResponseEntity<String> incluir(@RequestBody CarroDTO carroDTO) {
        try {
            Carro carro = CarroDTO.toEntity(carroDTO);
            carroRegras.beforeDatabaseAction(carro);
            iCarroRepository.save(carro);
            return new ResponseEntity<>(Constantes.SUCESS_SAVE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(e);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editar(@RequestBody CarroDTO carroDTO) {
        try {
            Carro carro = CarroDTO.toEntity(carroDTO);
            carroRegras.beforeDatabaseAction(carro);
            iCarroRepository.save(carro);
            return new ResponseEntity<>(Constantes.SUCESS_EDIT, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return mensagemExceptionTratada(e);
        }
    }

    @DeleteMapping("/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            Optional<Carro> carro = iCarroRepository.findById(id);

            if (!carro.isPresent()) return new ResponseEntity<>(HttpStatus.OK);

            iCarroRepository.delete(carro.get());
            return new ResponseEntity<>(Constantes.SUCESS_DELETE, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return mensagemExceptionTratada(e);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Map<String, List<CarroDTO>>> listar() {
        try {

            List<Carro> listaDeCarros = iCarroRepository.findAll();
            List<CarroDTO> listaDeCarrosDTO = new ArrayList<>();

            listaDeCarros.forEach((carro) -> {
                CarroDTO carroDTO = CarroDTO.toDTO(carro);
                listaDeCarrosDTO.add(carroDTO);
            });
            Map<String, List<CarroDTO>> response = new HashMap<>();
            response.put("cars", listaDeCarrosDTO);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mensagemExceptionTratada(new Exception(Constantes.LIST_ERROR));
        }
    }
}
