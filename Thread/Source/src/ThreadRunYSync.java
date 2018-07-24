
class PrinDemoY {
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

class ThreadRunY extends Thread {
   private Thread t;
   private String threadName;
   PrinDemoY  PD;

   ThreadRunY(String name,  PrinDemoY pd){
       threadName = name;
       PD = pd;
   }
   public void run() {
	   System.out.println("Thread"+threadName+"진행중");
       synchronized(PD) {
    	   System.out.println("Thread"+threadName+"동기화");
    	   PD.printCount();
       }
       System.out.println("Thread"+threadName+"exiting.");
   }

   public void start ()
   {
      System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}

public class ThreadRunYSync {
   public static void main(String args[]) {
	   PrinDemoY PD = new PrinDemoY();
	   
	   ThreadRunY T1 = new ThreadRunY("Thread -1",PD);
	   ThreadRunY T2 = new ThreadRunY("Thread -2",PD);
	   
	   T1.start();
	   T2.start();
	   
	   try {
		   T1.join();
		   T2.join();
	   }catch(Exception e) {
		   System.out.println("interrupted");
	   }
   }
}