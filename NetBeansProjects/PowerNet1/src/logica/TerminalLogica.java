
package logica;


/**
 *
 * @author Meli
 */
public class TerminalLogica {
    private String entrada;
    private String salida;
    private Comando ejecuta;
    
    public TerminalLogica() {
    }

    public TerminalLogica(String entrada, String salida) {
        this.entrada = entrada;
        this.salida = salida;
    }

    
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    
    @Override
    public String toString() {
        return "Terminal{" + "entrada=" + entrada + ", salida=" + salida + '}';
    }
    
    public void generarSalida(){
        String [] parts = this.getEntrada().split(" ");
        if (parts[0].equals("cat"))
            ejecuta=new Cat();
//        if (parts[0].equals("ls"))
  //          ejecuta=new Ls();
        ejecuta.setNomComando(parts[0]);
        ejecuta.setNomLugar(parts[1]);
        //ejecutarComando
        this.setSalida(ejecuta.ejecutarComando());
    }
    
}
