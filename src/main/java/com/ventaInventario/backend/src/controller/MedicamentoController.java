package com.ventaInventario.backend.src.controller;
import com.ventaInventario.backend.src.entity.Medicamento;
import com.ventaInventario.backend.src.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @DeleteMapping("/{idMedicamento}")
    public void delete(@PathVariable Integer idMedicamento) {
        medicamentoService.delete(idMedicamento);
    }

    @GetMapping("/paginado")
    public Page<Medicamento> obtenerMedicamentosPaginador(Pageable pageable) {
        return medicamentoService.obtenerMedicamentosPaginador(pageable);
    }

    @GetMapping
    public List<Medicamento> mostrarMedicamentos() {
        return medicamentoService.mostrarMedicamentos();
    }

    @GetMapping("/{idMedicamento}")
    public Optional<Medicamento> mostrarMedicamento(@PathVariable Integer idMedicamento) {
        return medicamentoService.mostrarMedicamento(idMedicamento);
    }

    @GetMapping("/nombre/{nombreMedicamento}")
    public Optional<Medicamento> mostrarMedicamentoNombre(@PathVariable String nombreMedicamento) {
        return medicamentoService.mostrarMedicamentoNombre(nombreMedicamento);
    }

    @GetMapping("/buscar/{palabraMedicamentos}")
    public List<Medicamento> mostrarMedicamentosPalabra(@PathVariable String palabraMedicamentos) {
        return medicamentoService.mostrarMedicamentoPalabra(palabraMedicamentos);
    }

/*
    @GetMapping("/ordenados")
    public List<Medicamento> traerMedicamentosMayorMenor() {
        return medicamentoService.traerMedicamentosMayorMenor();
    }*/
}
