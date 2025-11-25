
package za.ac.tut.val;

import java.util.logging.Level;
import java.util.logging.Logger;
import quickordersystem.QuickOrderSystem;

public class OrderValidationThread extends Thread{

    @Override
    public void run() {
   
        synchronized (QuickOrderSystem.class) {
            
            try {
                
                System.out.println("The order is started ");
                Thread.sleep(1000);
               
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
             QuickOrderSystem.isOrderValidated =true;
             System.out.println("The order is completed");
             QuickOrderSystem.class.notifyAll();
     
            
        }
    
    }
     
}
