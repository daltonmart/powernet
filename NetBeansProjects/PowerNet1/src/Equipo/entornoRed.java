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
public class entornoRed {
    static ArrayList<EquipoPC> red = new ArrayList<EquipoPC>();
    
    public entornoRed() {
        
    }
    
    static void agregarEquipo(EquipoPC equipo) {
        red.add(equipo);
    }
    
    static void buscarEquipo(EquipoPC equipo) {
        for (EquipoPC pc : red) {
            System.out.println(pc.getHostname()); 
        }         
    }
}
