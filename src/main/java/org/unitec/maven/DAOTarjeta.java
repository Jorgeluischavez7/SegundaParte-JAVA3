
package org.unitec.maven;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class DAOTarjeta {
      private SessionFactory fac;
    private Session ses;
    private Transaction tranza;
    
    public DAOTarjeta(){//cosntructor que inicializa los atributos que son vistos por todos los metodos.
        fac= HibernateUtilidades.getSessionFactory();
        ses= fac.openSession();
        tranza= ses.beginTransaction();
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
                
    }
    
       public void guardarTaR(Tarjeta tar)throws Exception{
        ses.save(tar);
    cerrarSesion();
       }
       
       public  void actualizarTar(Tarjeta tar)throws Exception{
        ses.update(tar);
        cerrarSesion();
    }
       public void borrarTar(Tarjeta tar)throws Exception{
           ses.delete(tar);
           cerrarSesion();
       }
       public ArrayList<Tarjeta> buscarTodosTar()throws Exception{
        Criteria cri= ses.createCriteria(Tarjeta.class);
        ArrayList<Tarjeta> gastos=(ArrayList<Tarjeta>)cri.list();
        cerrarSesion();
        return gastos;
    }
        public Tarjeta buscarPorIdTar(Integer id)throws Exception{
         Tarjeta tar=(Tarjeta) ses.createCriteria(Tarjeta.class).add(Restrictions.idEq(id)).uniqueResult();
           
        return tar;
        
    }
    
}
    
