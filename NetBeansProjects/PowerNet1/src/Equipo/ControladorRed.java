/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author junta
 */
public class ControladorRed {

    static ArrayList<EquipoPC> red = new ArrayList<EquipoPC>();

    public ControladorRed() {
    }

    static void agregarEquipo(EquipoPC equipo) {
        red.add(equipo);
    }

    static EquipoPC buscarEquipoXIp(String ip) {
        EquipoPC resultado = null;
        for (EquipoPC pc : red) {
            if (ip.equalsIgnoreCase(pc.getIp())) {
                resultado = pc;
                System.out.println(" PC <"+ ip + "> encontrado :"+pc.getHostname());
            }
        }        
        return resultado;
    }
    
     static EquipoPC buscarEquipoXNombre(String hostname) {
        EquipoPC resultado = null;
        for (EquipoPC pc : red) {
            if (hostname.equalsIgnoreCase(pc.getHostname())) {
                resultado = pc;
                System.out.println(" PC <"+ hostname + "> encontrado :"+pc.getHostname());
            }
        }        
        return resultado;
    }

    static ArrayList getEquipos() {
        return red;
    }

    static int getSize() {
        return red.size();
    }
}
