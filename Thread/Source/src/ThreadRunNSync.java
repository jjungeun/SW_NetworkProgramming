
class PrintDemoN {
   public void printCount(){
    try {
         for(int i = 7; i > 0; i--) {
            System.out.println("Counter   ---   "  + i );
         }
     } catch (Exception e) {
         System.out.println("Thread  interrupted.");
     }
   }
}

class ThreadunN extends Thread {
   private Thread t;
   private String threadName;
   PrintDemoN  PD;

   ThreadunN(String name,  PrintDemoN pd){
       threadName = name;
       PD = pd;
   }
   public void run() {
     PD.printCount();
     System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start ()
   {
     System.out.println("String "+ threadName);
     if(t == null) {
    	 t = new Thread(this,threadName);
    	 t.start();
     }
   }
}

public class ThreadRunNSync {
   public static void main(String args[]) {
	   PrintDemoN PD = new PrintDemoN();
	   
	   ThreadunN T1 = new ThreadunN("Thread -1",PD);
	   ThreadunN T2 = new ThreadunN("Thread -2",PD);
	   
	   T1.start();
	   T2.start();
	   
	   try {
		   T1.join();
		   T2.join();
	   }catch(Exception e) {
		   System.out.println("Interrupted");
	   }
   }
}