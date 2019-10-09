
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;


public class ls {
    
    private String[] args;

    
    public ls(String[] args) {
        this.args = args;
    }
    
    public ls(String param) {
        args = param.split(" ");
    }

 
    
     public String ejecutar() {
        CommandLineParser parser = null;
        CommandLine cmdLine = null;
        HelpFormatter formatter = new HelpFormatter();
        StringWriter out = new StringWriter();
        PrintWriter pw = new PrintWriter(out);
        
        String path= "";

        ///////////////////////////////////////////////////////////////////////  
        // Fase 1: Configuramos las opciones de validación de entrada.  
        ///////////////////////////////////////////////////////////////////////        
        Options options = new Options();
        options.addOption("l", false, "lista en formato largo");
        options.addOption("a", false, "lista archivos ocultos");
        options.addOption("p", false, "lista a partir del camino indicado");
        options.addOption("h", "help", false, "Imprime el mensaje de ayuda");
  
        try {
            ///////////////////////////////////////////////////////////////////////  
            // Fase 2: Parseamos la entrada con la configuración establecida  
            ///////////////////////////////////////////////////////////////////////  
            parser = new BasicParser();
            cmdLine = parser.parse(options, args);
            ///////////////////////////////////////////////////////////////////////  
            // Fase 3: Analizamos los resultados y realizamos las tareas pertinentes  
            ///////////////////////////////////////////////////////////////////////  
            // Si está la opcion de ayuda, la imprimimos y salimos.  
            if (cmdLine.hasOption("h")) {    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos                  
                formatter.printHelp(pw, 80, this.getClass().getCanonicalName(), "Parametros", options, 4, 3, "", true);
            }

            // Si el usuario ha especificado el puerto lo leemos          
            if (cmdLine.hasOption("p")) {
                path = cmdLine.getOptionValue("p");
            }

            // Leemos la dirección IP. Sino existe generamos un error pues es un parámetro requerido.  
//            String ip = cmdLine.getOptionValue("l");
//            if (ip == null) {
//                pw.print("La direccion IP es requerida");
//            }
//            


            // ..............................................................  
            // Aquí irían las tareas que tuviera que realizar la aplicación   
            // ..............................................................  
            System.out.println("Path :"+path);
            System.out.println("OK");

        } catch (org.apache.commons.cli.ParseException | java.lang.NumberFormatException ex) {
            formatter.printHelp(pw, 80, this.getClass().getCanonicalName(), "Parametros", options, 4, 3, "", true);
        }
        pw.flush();
        return out.toString();
    }
    
}
