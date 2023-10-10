package br.com.guilherme.barros.CarsSystem.repository.marca;

import br.com.guilherme.barros.CarsSystem.model.marca.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IMarcaRepository extends JpaRepository<Marca, Long> {

    @Query(value = "SELECT id FROM marca WHERE id = :valor", nativeQuery = true)
    Optional<Long> isExist(@Param("valor") Long id);
}
