
package za.ac.tut.ship;

import java.util.logging.Level;
import java.util.logging.Logger;
import quickordersystem.QuickOrderSystem;

public class ShippingThread  extends Thread{

    @Override
    public void run() {
      
        synchronized (QuickOrderSystem.class) {
            
            try {
                while (!QuickOrderSystem.isPaymentProcessed) {                    
                
                    QuickOrderSystem.class.wait();
                }
                Thread.sleep(1000);
                System.out.println("The shipping is started ");
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
            
            
            System.out.println("The shipping is completed ");
            
        }
    }
    
}
