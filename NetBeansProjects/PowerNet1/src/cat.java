
import logica.Archivo;
import logica.Comando;
import logica.EstructuraArchivos;

public class cat extends Comando {

    private Object usaEstructuraArchivos;
    
    
    public cat() {
        super();
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
