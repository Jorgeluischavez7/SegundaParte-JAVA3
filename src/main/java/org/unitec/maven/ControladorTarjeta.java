/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ControladorTarjeta {
    
    //
    @RequestMapping(value = "/tarjeta/{nombre}/{fechaCorte}",method = RequestMethod.POST, headers ={"Accept=text/html"})
    @ResponseBody String guardarTarjeta(@PathVariable String nombre, @PathVariable Integer fechaCorte)throws Exception{
        Tarjeta t=new Tarjeta();
        t.setDiacorte(fechaCorte);
        t.setNombre(nombre);
        DAOTarjeta dao=new DAOTarjeta();
        dao.guardarTaR(t);
        return "Tarjeta guardada con exito";
    }
    @RequestMapping(value="/tarjeta/{idTarjeta}/{nombre}/{fechaCorte}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    @ResponseBody String actuaizarTarjeta(@PathVariable Integer idTarjeta,@PathVariable String nombre,@PathVariable Integer fechaCorte)throws Exception{
        
   DAOTarjeta dao=new DAOTarjeta();
   
       Tarjeta t=new Tarjeta();
    t.setIdTarjeta(idTarjeta);
    t.setNombre(nombre);
    t.setDiacorte(fechaCorte);
    
    
        dao.actualizarTar(t);
        
        return "tarjeta actualizada con exito";
}
    @RequestMapping(value="/tarjeta/{idTarjeta}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    @ResponseBody String borrarTarjeta(@PathVariable Integer idTarjeta)throws Exception{
        
    DAOTarjeta dao=new DAOTarjeta();
        dao.borrarTar(idTarjeta);
        
        return "tarjeta eliminada";
}   
    @RequestMapping(value="/tarjeta/{idTarjeta}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody Tarjeta buscarIdTarjeta(@PathVariable Integer idTarjeta)throws Exception{
        
   DAOTarjeta dao=new DAOTarjeta();
   
    Tarjeta t=(Tarjeta) dao.buscarPorIdTar(idTarjeta);
        
        return t;
}
    
    @RequestMapping(value="/tarjeta",method=RequestMethod.GET,headers = {"Accept=aplication/json"})
    @ResponseBody List obtenerTodosTarjeta()throws Exception{
        
        DAOTarjeta dao=new DAOTarjeta();
        List tarjetas=dao.buscarTodosTar();
        return tarjetas;
    }
    
}
