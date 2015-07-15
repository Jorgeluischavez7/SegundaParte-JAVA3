
package org.unitec.maven;


public class LeerMySQL implements Leer{

    @Override
    public String leer() throws Exception {
        //aqui va hibernate.
       String mensajito="----------Conectado a MySQL---------------";
       return mensajito;
    }
    
}
