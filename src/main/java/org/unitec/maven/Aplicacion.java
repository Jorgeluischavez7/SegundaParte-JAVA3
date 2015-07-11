
package org.unitec.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration//es una aplicación de spring(localhost, tomcat, contexto(http://localhost:9000/weba)).
@ComponentScan

public class Aplicacion {
    public static void main(String[] args)throws Exception{
        SpringApplication.run(Aplicacion.class, args);
        
        System.out.println("----------Un mensaje desde Spring Boot....");
        LeerArchivo objeto=new LeerArchivo();
        System.out.println(objeto.leer());
        
        
        
    }
    
}
