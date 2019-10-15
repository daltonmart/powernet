
package logica;

import Equipo.VariablesEntorno;

public abstract class Comando {
    //private String nomComando;
    //private String direccion;
    
    private String[] args;
    private VariablesEntorno variablesEntorno;
    
    public Comando() {
    }
    
//
//    public Comando(String nomComando, String nomLugar) {
//        this.nomComando = nomComando;
//        this.direccion = nomLugar;
//    }
    
    public VariablesEntorno getVariablesEntorno() {
        return variablesEntorno;
    }

    public void setVariablesEntorno(VariablesEntorno varEntorno) {
        this.variablesEntorno = varEntorno;
    }

//    public String getNomComando() {
//        return nomComando;
//    }
//
//    public void setNomComando(String nomComando) {
//        this.nomComando = nomComando;
//    }
//
//    public String getNomLugar() {
//        return direccion;
//    }
//
//    public void setNomLugar(String nomLugar) {
//        this.direccion = nomLugar;
//    }
//    
    public abstract String ejecutar();
}
