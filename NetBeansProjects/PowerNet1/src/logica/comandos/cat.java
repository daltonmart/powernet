package logica.comandos;


import logica.Archivo;
import logica.Comando;
import logica.EstructuraArchivos;
import Equipo.VariablesEntorno;

public class cat extends Comando {
    
    private String[] args;
    private VariablesEntorno variablesEntorno;
    
    public VariablesEntorno getVariablesEntorno() {
        return variablesEntorno;
    }

    public void setVariablesEntorno(VariablesEntorno varEntorno) {
        this.variablesEntorno = varEntorno;
    }
   
    public cat() {
        super();
    }
    
     public cat(String param) {
        this();
        args = param.split(" ");
    }

//    public cat(String nomComando, String nomArchivo) {
//        super();
//    }

    
    @Override
    public String ejecutar(){
        String nomArchivo="testing.txt";
        Archivo a = getVariablesEntorno().getFs().buscarArchivo(nomArchivo);
        if (a != null)
            return a.getContenido();
        else
            return "No existe el archivo";
    }
}
