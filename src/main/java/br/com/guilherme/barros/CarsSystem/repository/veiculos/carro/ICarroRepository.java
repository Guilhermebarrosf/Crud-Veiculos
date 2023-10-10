package br.com.guilherme.barros.CarsSystem.repository.veiculos.carro;

import br.com.guilherme.barros.CarsSystem.model.veiculos.carro.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICarroRepository extends JpaRepository<Carro, Long> {

    @Query(value = "SELECT id FROM carro WHERE id = :valor", nativeQuery = true)
    Optional<Long> isExist(@Param("valor") Long id);
}
