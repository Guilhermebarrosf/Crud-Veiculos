package br.com.guilherme.barros.CarsSystem.repository.modelo;

import br.com.guilherme.barros.CarsSystem.model.modelo.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IModeloRepository extends JpaRepository<Modelo, Long> {

    @Query(value = "SELECT id FROM modelo WHERE id = :valor", nativeQuery = true)
    Optional<Long> isExist(@Param("valor") Long id);
}
