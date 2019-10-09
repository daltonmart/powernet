/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import java.util.*;
import java.lang.reflect.*;
import java.lang.management.*;
  
public class Main
{
   public static void main(String []args) {
      try {
         System.out.println("Process-id: " + getProcessId());
      }
      catch(Exception e) { }
      while (true) {
         new Thread(new Task()).start();
         try { Thread.sleep(500); } catch(InterruptedException e) { }
      }
   }
     
   public static int getProcessId() throws Exception {
      // next line to trigger loading of library
      ManagementFactory.getThreadMXBean();
        
      Class c = Class.forName("sun.management.VMManagementImpl");
          
      Constructor constructor = c.getDeclaredConstructor(new Class[] { });
      constructor.setAccessible(true);
      Object impl = constructor.newInstance(new Object[] { });
        
      Method m = c.getDeclaredMethod("getProcessId", new Class[] { });
      m.setAccessible(true);
      Object result = m.invoke(impl, new Object[] { });
      return (Integer) result;
   }  
}
  
class Task implements Runnable
{
   public void run() {
      Vector<byte[]> v = new Vector<byte[]>();
      while (true) {
         v.add(new byte[10000]);
           
         try { Thread.sleep(100); } catch(InterruptedException e) { }
      }
   }
}

