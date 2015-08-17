
package org.unitec.maven;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


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
       public void borrarGas(Integer id ) throws Exception{
        Gastos g = (Gastos) ses.createCriteria(Gastos.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(g);
        cerrarSesion();
       }
     public Gastos buscarPorIdGas(Integer id)throws Exception{
         Gastos gas=(Gastos) ses.createCriteria(Gastos.class).add(Restrictions.idEq(id)).uniqueResult(); 
        return gas;
    }
        public ArrayList<Gastos> buscarTodosGas()throws Exception{
        Criteria cri= ses.createCriteria(Gastos.class);
        ArrayList<Gastos> gastos=(ArrayList<Gastos>)cri.list();
        cerrarSesion();
        return gastos;
    }
}
