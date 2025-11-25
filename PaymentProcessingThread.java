
package za.ac.tut.pay;

import java.util.logging.Level;
import java.util.logging.Logger;
import quickordersystem.QuickOrderSystem;

public class PaymentProcessingThread  extends Thread{

    @Override
    public void run() {
   
        
        synchronized (QuickOrderSystem.class) {         
            try {
                  while (!QuickOrderSystem.isOrderValidated) {                
                QuickOrderSystem.class.wait();
            }
                System.out.println("The Payment has started ");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
            QuickOrderSystem.isPaymentProcessed = true;
            System.out.println("The Payment is completed");
            QuickOrderSystem.class.notifyAll();
            
        }
    
    }
    
}
