/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.crud;

import com.proyectohibernate.modelo.Contrato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author PC
 */
public class contratoCrud {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public contratoCrud (){
    
        tran = Persistence.createEntityManagerFactory("proyectoHibernate");
    
    }
    
    public Contrato fyndbyId(Contrato c){
        em = getEntityManager();
        return em.find(Contrato.class, c.getId_contrato());
    }
    
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT c from Contrato c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Contrato> lista = query.getResultList();
        for (Contrato c : lista){
        System.out.print(c + "\n");
        }
        
    }

    
    
    
    public void Insertar (Contrato contrato){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contrato);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (Contrato contrato){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(contrato);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (Contrato contrato){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(contrato));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto persona:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
    
}
