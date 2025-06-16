package mx.ude.itses.JMTG.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.ude.itses.JMTG.MetodosNumericos.domain.Biseccion;
import mx.ude.itses.JMTG.MetodosNumericos.services.Funciones;
import mx.ude.itses.JMTG.MetodosNumericos.services.UnidadIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //
public class Unit2Controller {
    @Autowired
    private UnidadIIService bisectionservice;
    
    @GetMapping("unit2/formbisection")
    public String formBisection(Model model){
        Biseccion bisection =new Biseccion();
        
        model.addAttribute("bisection", bisection);
        
        return "unit2/bisection/formbisection";
    }
    
    @PostMapping("/unit2/solvebisection")
    public String solvebisection(Biseccion bisection, Model model){
        
       // double valorFX = Funciones.Ecuacion(biseccion.getFX(), biseccion.get);
       //log.info("Valor de FX: " + valorFX);
        
       var solveBisection = bisectionservice.AlgoritmoBiseccion(bisection);
       
      //log.info("Arreglo: " +solvebisection);
       
       model.addAttribute("solvebisection",solveBisection);
       
        return "/unit2/bisection/solvebisection";
    }
}
