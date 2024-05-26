package com.ventaInventario.backend.src.model;

public class ProductosModel {

    private Integer idProducto;
    private String nombre;
    private Double totalCalificacion;
    private Integer ipsaEntity_Rut;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTotalCalificacion() {
        return totalCalificacion;
    }

    public void setTotalCalificacion(Double totalCalificacion) {
        this.totalCalificacion = totalCalificacion;
    }

    public Integer getIpsaEntity_Rut() {
        return ipsaEntity_Rut;
    }

    public void setIpsaEntity_Rut(Integer ipsaEntity_Rut) {
        this.ipsaEntity_Rut = ipsaEntity_Rut;
    }
}
