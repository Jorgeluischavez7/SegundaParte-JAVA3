
package org.unitec.maven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//Estereotipo: nestructura es un controler.
@RequestMapping("/")//http://localhost:9000/
public class ControladorLeer {
    @RequestMapping(value = "/leer",method = RequestMethod.GET,
            headers = {"Accept=text/html"})//headers tipo de dato que le quiero dar al navegador.
    @ResponseBody String leer()throws Exception{
        return "aqui vamos a mostrar el servicio leer que hicimos ya";
    }
}
