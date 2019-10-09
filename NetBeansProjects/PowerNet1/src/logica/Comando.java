
package logica;

/**
 *
 * @author Meli
 */
public abstract class Comando {
    private String nomComando;
    private String direccion;
    
    public Comando() {
    }

    public Comando(String nomComando, String nomLugar) {
        this.nomComando = nomComando;
        this.direccion = nomLugar;
    }

    public String getNomComando() {
        return nomComando;
    }

    public void setNomComando(String nomComando) {
        this.nomComando = nomComando;
    }

    public String getNomLugar() {
        return direccion;
    }

    public void setNomLugar(String nomLugar) {
        this.direccion = nomLugar;
    }
    
    public abstract String ejecutarComando();
}
