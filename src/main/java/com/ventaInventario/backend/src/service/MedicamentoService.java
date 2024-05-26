package com.ventaInventario.backend.src.service;

import com.ventaInventario.backend.src.entity.Medicamento;
import com.ventaInventario.backend.src.repository.MedicamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    Log log = LogFactory.getLog(getClass());

    public void delete(Integer idMedicamento) {
        try {
            Medicamento medicamento = medicamentoRepository.findById(idMedicamento).orElseThrow(() ->
                    new EntityNotFoundException("Medicamento not found with id " + idMedicamento));
            medicamentoRepository.delete(medicamento);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public Page<Medicamento> obtenerMedicamentosPaginador(Pageable pageable) {
        return medicamentoRepository.findAll(pageable);
    }

    public List<Medicamento> mostrarMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> mostrarMedicamento(Integer idMedicamento) {
        return medicamentoRepository.findById(idMedicamento);
    }

    public Optional<Medicamento> mostrarMedicamentoNombre(String nombreMedicamento) {
        return medicamentoRepository.findByNombre(nombreMedicamento);
    }

    public List<Medicamento> mostrarMedicamentoPalabra(String palabraMedicamentos) {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();
        List<Medicamento> medicamentosMostrar = new ArrayList<>();
        String[] palabras = palabraMedicamentos.toLowerCase().split(" ");

        for (Medicamento medicamento : medicamentos) {
            for (String palabra : palabras) {
                if (medicamento.getNombre().toLowerCase().contains(palabra)) {
                    medicamentosMostrar.add(medicamento);
                    break;
                }
            }
        }
        return medicamentosMostrar;
    }


/*
    public List<Medicamento> traerMedicamentosMayorMenor() {
        List<Medicamento> medicamentosEntities = medicamentoRepository.findAll();
        medicamentosEntities.sort(Comparator.comparing(Medicamento::getTotalCalificacion).reversed());
        return medicamentosEntities;
    }*/
}
