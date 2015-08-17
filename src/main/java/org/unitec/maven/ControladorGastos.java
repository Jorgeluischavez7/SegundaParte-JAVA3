
package org.unitec.maven;

/**
 *
 * @author JorgeLuis
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorGastos {
    @RequestMapping(value="/gastos/{fecha}/{concepto}/{cantidad}",method = RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody String guardarGastos(@PathVariable Date fecha,@PathVariable String concepto,@PathVariable Float cantidad,@PathVariable Integer idTarjeta)throws Exception{
       Gastos g=new Gastos();
       g.setFecha(fecha);
       g.setConcepto(concepto);
       g.setCantidad(cantidad);
        DAOGastos dao = new DAOGastos();
        dao.guardarGas(g);
        return "gastos guardados con exito";
        
    }
    @RequestMapping(value="/gastos/{idGastos}/{fecha}/{concepto}/{cantidad}/{idTarjeta}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    @ResponseBody String actuaizarGastos(@PathVariable Integer idGastos,@PathVariable Date fecha,@PathVariable String concepto,@PathVariable Float cantidad,@PathVariable Integer idTarjeta)throws Exception{ 
    DAOGastos dao=new DAOGastos();
       Gastos g=new Gastos();
       g.setIdGastos(idGastos);
       g.setFecha(fecha);
       g.setConcepto(concepto);
       g.setCantidad(cantidad);
       dao.guardarGas(g);
       return "gastos actualizados";
}
    @RequestMapping(value="/gastos/{idGastos}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    @ResponseBody String borrarGastos(@PathVariable Integer idGastos)throws Exception{
        
    DAOGastos dao=new DAOGastos();
    dao.borrarGas(idGastos);
    return "gasto eliminado";
}  
    @RequestMapping(value="/gastos/{idGasto}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody Gastos buscarIdGasto(@PathVariable Integer idGastos)throws Exception{
        
   DAOGastos dao=new DAOGastos();
   
    Gastos g=(Gastos) dao.buscarPorIdGas(idGastos);
        
        return g;
}
    @RequestMapping(value="/gastos",method=RequestMethod.GET,headers = {"Accept=aplication/json"})
    @ResponseBody List obtenerTodosGastos()throws Exception{
        
        DAOGastos dao=new DAOGastos();
        List gastos=dao.buscarTodosGas();
        return gastos;
    }
    
}