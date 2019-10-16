package logica.comandos;

import Equipo.*;
import logica.Comando;


public class exit extends Comando {

    private VariablesEntorno variablesEntorno;
       
    public exit() {    
        super();
    }

    public VariablesEntorno getVariablesEntorno() {
        return variablesEntorno;
    }

    @Override
    public void setVariablesEntorno(VariablesEntorno varEntorno) {
        this.variablesEntorno = varEntorno;
    }

    
     public String ejecutar() {       
        System.exit(0);
        return "Fin del Programa";
    }
    
}
