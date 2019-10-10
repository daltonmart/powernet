package terminal;

import java.lang.reflect.Constructor;
import java.lang.Class;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesadorDeComandos {

    private String comandoNombre;
    private String comandoParametros;
    private String[] argumentos;
    private Class comandoClass;
    private String consolaSalida;
    private Object comandoObj;
    private String textoDesdeCLI;

    public ProcesadorDeComandos(String textoDesdeCLI) {
        System.out.println("Entrando a ProcesarCLI()");
        setConsolaSalida("");
        this.textoDesdeCLI = textoDesdeCLI;
    }

    public String ejecutar() {
        try {
            argumentos = textoDesdeCLI.split(" ");
            comandoNombre = argumentos[0];
            comandoClass = Class.forName(comandoNombre);
            if (argumentos.length > 1) {    // Si tiene paramatros llamo al constructor con parametro String                
                comandoParametros = textoDesdeCLI.substring(comandoNombre.length() + 1);
                comandoObj = comandoClass.getDeclaredConstructor(String.class).newInstance(comandoParametros);                
//                Class c = Class.forName(comandoNombre);
//                Constructor constructor;
//                constructor = c.getDeclaredConstructor(String[].class);
//                constructor.setAccessible(true);
//                //Object impl = constructor.newInstance(new Object[]{});
//                Object impl = constructor.newInstance((Object[]) argumentos);
            } else {                       // No tiene paramatros llamo al constructor sin parametros
                comandoParametros = "";
                comandoObj = comandoClass.getDeclaredConstructor().newInstance();
            }
            Method mthd = comandoClass.getDeclaredMethod("ejecutar");
            System.out.println(" metodo:" + mthd);
            String salida = (String) mthd.invoke(comandoObj);

            anexarAConsolaSalida(" >> " + salida);
        } catch (ClassNotFoundException ex) {
            anexarAConsolaSalida("Error comando no encontrado ");

        } catch (Exception ex) {
            anexarAConsolaSalida("Error en " + ex);
            System.err.println(">>>>>>>>" + ex);
        }
        return getConsolaSalida();
    }


    public String getConsolaSalida() {
        return consolaSalida;
    }

    public void setConsolaSalida(String consolaSalida) {
        this.consolaSalida = consolaSalida;
    }

    public void anexarAConsolaSalida(String consolaSalida) {
        this.consolaSalida = this.consolaSalida + consolaSalida + "\n";
    }

}
