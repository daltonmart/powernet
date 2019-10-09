
package logica;

//import static logica.EstructuraDirectorios.buscarArchivo;
//import static logica.EstructuraDirectorios.buscarDirectorio;
//import static presentacion.Terminal.raiz;
//import static proyectotaller2capalogica.EstructuraDirectorios.raiz;

public class Cat extends Comando{
    private EstructuraArchivos usaEstructuraArchivos;
    
    public Cat() {
    }

    public Cat(String nomComando, String nomArchivo) {
        super(nomComando, nomArchivo);
    }

    
    @Override
    public String ejecutarComando(){
        Archivo a=usaEstructuraArchivos.buscarArchivo(getNomLugar());
        if (a != null)
            return a.getContenido();
        else
            return "No existe el archivo";
    }
}
