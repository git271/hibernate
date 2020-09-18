/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="contrato")
public class Contrato implements Serializable {
    
    @Id
    @SequenceGenerator(name="con_sec", sequenceName="sec_contrato", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="con_sec")
    @Column(name="id_contrato")
    private Integer id_contrato;
    
    @Column (name="fecha_inicio")
    private Date fecha_inicio;
    
    @Column (name="fecha_finalizacion")
    private Date fecha_finalizacion;
    
    @Column (name="nombre_empleado")
    private String nombre_empleado;
    
    @Column (name="apellido_empleado")
    private String apellido_empleado;
    
    @Column (name="dui")
    private Integer dui;

    public Integer getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(Integer id_contrato) {
        this.id_contrato = id_contrato;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(Date fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public Integer getDui() {
        return dui;
    }

    public void setDui(Integer dui) {
        this.dui = dui;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id_contrato=" + id_contrato + ", fecha_inicio=" + fecha_inicio + ", fecha_finalizacion=" + fecha_finalizacion + ", nombre_empleado=" + nombre_empleado + ", apellido_empleado=" + apellido_empleado + ", dui=" + dui + '}';
    }
    
    
    
}
