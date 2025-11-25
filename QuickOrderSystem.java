
package quickordersystem;

import za.ac.tut.pay.PaymentProcessingThread;
import za.ac.tut.ship.ShippingThread;
import za.ac.tut.val.OrderValidationThread;

public class QuickOrderSystem {

    public static boolean isOrderValidated = false;
    public static boolean isPaymentProcessed = false;
    
    public static void main(String[] args) {
       
        OrderValidationThread val = new OrderValidationThread();
        PaymentProcessingThread pay = new PaymentProcessingThread();
        ShippingThread ship = new ShippingThread();
        
        
      val.setPriority(Thread.MAX_PRIORITY);
      pay.setPriority(Thread.NORM_PRIORITY);
      ship.setPriority(Thread.MIN_PRIORITY);
      
      val.start();
      pay.start();
      ship.start();
      
        
    }
    
}
