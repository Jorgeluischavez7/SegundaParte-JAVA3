/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T-107
 */

public class DAOProducto {
    private SessionFactory fac;
    private Session ses;
    private Transaction tranza;
    
    public DAOProducto(){//cosntructor que inicializa los atributos que son vistos por todos los metodos.
        fac= HibernateUtilidades.getSessionFactory();
        ses= fac.openSession();
        tranza= ses.beginTransaction();
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
                
    }
    
    
    public void guardar(Producto g)throws Exception{
    ses.save(g);
    cerrarSesion();
    }
   
   
    
    //tenemos que crear algo parecido al parcial.
   /* public static void guardar(Producto p)throws Exception{
        SessionFactory fac= HibernateUtilidades.getSessionFactory();
        Session ses= fac.openSession();
        Transaction tranza= ses.beginTransaction();
        //guardamos.
        ses.save(p);
        ses.close();
    }*/
    public  void actualizar(Producto g)throws Exception{
        ses.update(g);
        cerrarSesion();
    }
}