/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import terminal.Terminal;
import terminal.XTerm;

/**
 *
 * @author root
 */
public class testEntorno {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
         
         EquipoPC pc1 = new EquipoPC("pc001");
         EquipoPC pc2 = new EquipoPC();
         
     
         pc2.ejecutarComando("");
         String resultado = pc1.boot();
         
         pc1.ejecutarComando("ls");
         
         System.out.println(">>>>"+resultado);
         
         XTerm consola = pc1.connect();
         
        
        //Konsole1 consola = new Konsole();
        consola.setSize(800, 600);
        consola.setVisible(true);

    }
}
