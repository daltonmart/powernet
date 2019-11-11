package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class pwd extends Comando {

    private String[] args;

    public pwd() {
    }

    public pwd(String argumentos) {
        args = argumentos.split(" ");
    }

    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);

        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

        
        String url = estructArchivos.getDirectorioActual();
        pw.println(url);

        pw.flush();
        return salida.toString();
    }

    private String extraerUrlDeArgs(String[] args) {
        String url = "";
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                url = arg;
                break;
            }
        }
        return url;
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
    }
}
