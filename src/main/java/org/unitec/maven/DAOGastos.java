
package org.unitec.maven;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class DAOGastos {
      private SessionFactory fac;
    private Session ses;
    private Transaction tranza;
    
       public DAOGastos(){
        fac= HibernateUtilidades.getSessionFactory();
        ses= fac.openSession();
        tranza= ses.beginTransaction();
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
                
    }
      public void guardarGas(Gastos gas)throws Exception{
        ses.save(gas);
    cerrarSesion();
       }
       
       public  void actualizarGas(Gastos gas)throws Exception{
        ses.update(gas);
        cerrarSesion();
    }
       public void borrarGas(Gastos gas)throws Exception{
           ses.delete(gas);
           cerrarSesion();
       }
       public List<Gastos> buscarTodosGas()throws Exception{
        List<Gastos> gastos= ses.createCriteria(Gastos.class).list();
        return gastos;
    }
        public Tarjeta buscarPorIdGas(Integer id)throws Exception{
        return null;
        }
}
