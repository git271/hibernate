/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.operaciones;

import java.util.Scanner;
import com.proyectohibernate.modelo.Contrato;
import com.proyectohibernate.crud.contratoCrud;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ContratoOpe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        contratoCrud contrato = new contratoCrud();
        
        Contrato p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id_contrato, nombre_empleado, apellido_empleado;
        Date fecha_inicio, fecha_finalizacion;
        Integer dui;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Contratos" + 
          "\n2.-Buscar contratos por Id\n" +
                    "3.-Agregar a una contratos\n" +
                    "4.-Modificar una contratos\n"+
                    "5.-Eliminar una contratos\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    contrato.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar persona por Id***********");
                    System.out.println("Introduce el Id de la persona a buscar:");
                    id_contrato = entrada.nextLine();
                    p1 = new Contrato();
                    p1.setId_contrato(new Integer(id_contrato));
                    p1 = contrato.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce los nombres de la persona que entra en contrato");
                    nombre_empleado = entrada.nextLine();
                    
                    System.out.println("Introduce los apellidos de la persona que entra en contrato");
                    apellido_empleado = entrada.nextLine();
                    
                    System.out.println("Introduce la fecha de inicio de contrato en formato yyyy-MM-dd");
                    String fecha_1 = entrada.nextLine();
                    SimpleDateFormat formatear = new SimpleDateFormat("yyyy-MM-dd");
                    fecha_inicio = formatear.parse(fecha_1);
                    
                    System.out.println("Introduce la fecha de finalizacion del contrato en formato yyyy-MM-dd");
                    String fecha_2 = entrada.nextLine();
                    formatear = new SimpleDateFormat("yyyy-MM-dd");
                    fecha_finalizacion = formatear.parse(fecha_2);
                    
                    System.out.println("Introduce numero de DUI de la persona que entra en contrato");
                    String duiTexto = entrada.nextLine();
                    dui = Integer.parseInt(duiTexto);
                    
                    
                                  
                    p1 = new Contrato();
                    p1.setNombre_empleado(nombre_empleado);
                    p1.setApellido_empleado(apellido_empleado);
                    p1.setFecha_inicio(fecha_inicio);
                    p1.setFecha_finalizacion(fecha_finalizacion);
                    p1.setDui(dui);
                    contrato.Insertar(p1);
                    break;

                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el Id de persona a modificar");
                    id_contrato = entrada.nextLine();
                    p1= new Contrato();
                    p1.setId_contrato(new Integer(id_contrato));
                    contrato.fyndbyId(p1);
                    
                    System.out.println("Introduce el nombre de la persona a modificar");
                    nombre_empleado = entrada.nextLine();
                    
                    System.out.println("Introduce el apellido de la persona a modificar");
                    apellido_empleado = entrada.nextLine();
                    
                    System.out.println("Introduce la fecha inicial a modificar en formato yyyy-MM-dd");
                    String fecha_3 = entrada.nextLine();
                    formatear = new SimpleDateFormat("yyyy-MM-dd");
                    fecha_inicio = formatear.parse(fecha_3);
                    
                    System.out.println("introduce la fecha de finalizacion a modificar");
                    String fecha_4 = entrada.nextLine();
                    formatear = new SimpleDateFormat("yyyy-MM-dd");
                    fecha_finalizacion = formatear.parse(fecha_4);
                    
                    System.out.println("Introduce el duia modificar");
                    String duiTexto2 = entrada.nextLine();
                    dui = Integer.parseInt(duiTexto2);
                    
                    
                    
                    p1.setNombre_empleado(nombre_empleado);
                    p1.setApellido_empleado(apellido_empleado);
                    p1.setFecha_inicio(fecha_inicio);
                    p1.setFecha_finalizacion(fecha_finalizacion);
                    p1.setDui(dui);
                    contrato.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el id del contrato a eliminar");
                    id_contrato = entrada.nextLine();
                    p1 = new Contrato();
                    p1.setId_contrato(new Integer(id_contrato));
                    p1 = contrato.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    contrato.eliminar(p1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        
        }
        
    }
    
}
