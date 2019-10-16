
package logica;

import Equipo.VariablesEntorno;

public abstract class Comando {
    
    public Comando() {
    }

    public abstract VariablesEntorno getVariablesEntorno();
    public abstract void setVariablesEntorno(VariablesEntorno varEntorno);
    public abstract String ejecutar();
}
