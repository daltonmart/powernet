package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;

public class cat extends Comando {

    private String[] args;

    public cat() {
    }

    public cat(String argumentos) {
        args = argumentos.split(" ");
    }

    @Override
    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);

        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

        String posibleUrl = extraerUrlDeArgs(args);

        if (posibleUrl.length() != 0) {

            if (posibleUrl.length() == 1) {
                posibleUrl = estructArchivos.getDirectorioActual() + posibleUrl;
            }

            if (!posibleUrl.startsWith("/")) {
                posibleUrl = estructArchivos.getDirectorioActual() + "/" + posibleUrl;
            }
            DataArchivo arch;
            arch = estructArchivos.getArchivoDeUrl(posibleUrl);

            if (arch != null) {
                pw.println(arch.getContenido());
            } else {
                pw.println("No se encontro el Archivo");
            }

        } else {
            pw.println("Cat requiera Nombre de Archivo");
        }
        pw.flush();
        return salida.toString();
    }

    private String extraerUrlDeArgs(String[] args) {
        String url = null;
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
