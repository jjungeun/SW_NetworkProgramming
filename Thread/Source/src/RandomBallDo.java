

public class RandomBallDo  {
	public static void main(String[] args) {
		MyRandom ball1	= new MyRandom("ball1");
		MyRandom ball2	= new MyRandom("ball2");
		MyRandom ball3	= new MyRandom("ball3");

		int sNum1 = 0;
		int sNum2 = 0;
		int sNum3 = 0;
		boolean status = true;

		ball1.start();ball2.start();ball3.start();

		try {
			while(status) {
				Thread.sleep(500);
				
				sNum1= ball1.getNumber();
				sNum2= ball2.getNumber();
				sNum3= ball3.getNumber();
				
				System.out.printf("(%2d) (%2d) (%2d) \r\n",sNum1,sNum2,sNum3);
				
				if(sNum1 != 0) {
					if((sNum1 == sNum2) && (sNum2 == sNum3)) {
						status = false;
						System.out.println("3 Ball Matched");
						
						ball1.setFinish();
						ball2.setFinish();
						ball3.setFinish();
					}
				}
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyRandom extends Thread {
	int rNum;
	boolean tStatus;

	MyRandom(String name) {
		super(name);
		tStatus = true;
	}
	
	public void run() { // Override
		try {
			while(tStatus) {
				rNum = (int)((Math.random()*9)+1);
				sleep(500);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getNumber() {
		return rNum;
	}

	void setFinish() {
		tStatus = false;
		
	}
}