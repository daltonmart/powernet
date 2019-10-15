package logica.comandos;

import Equipo.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import logica.Archivo;
import logica.Comando;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;


public class exit extends Comando {

    private VariablesEntorno variablesEntorno;
       
    public exit() {    
        super();
    }

//    public VariablesEntorno getVariablesEntorno() {
//        return variablesEntorno;
//    }
//
//    @Override
//    public void setVariablesEntorno(VariablesEntorno varEntorno) {
//        this.variablesEntorno = varEntorno;
//    }

    
     public String ejecutar() {       
        System.exit(0);
        return "Fin del Programa";
    }
    
}
