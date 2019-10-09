
package logica;

/**
 *
 * @author Meli
 */
public class Mision {
    String pista;
    String historia;
    String comando;

    public Mision(){
        
    }

    public Mision(String pista, String historia, String comando) {
        this.pista = pista;
        this.historia = historia;
        this.comando = comando;
    }
    
    

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    @Override
    public String toString() {
        return "Mision{" + "pista=" + pista + ", historia=" + historia + ", comando=" + comando + '}';
    }

    
    
    
}
