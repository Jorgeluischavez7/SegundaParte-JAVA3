
package org.unitec.maven;

//aqui se enlazan los beans

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionBasica {
    @Bean
    Leer servicioleer(){
        Leer leer=new LeerMySQL();//inyeccion de subtipo
        return leer;
    }
    
}