package com.ventaInventario.backend.src.repository;

import com.ventaInventario.backend.src.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
    Optional<Medicamento> findById(Integer id);

    Optional<Medicamento> findByNombre(String nombre);

}
