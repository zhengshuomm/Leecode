
public class BlockingQueueTest {
	public static void main(String[] args) {
		BlockingQueue bq1 = new BlockingQueue();
//		BlockingQueue bq2 = new BlockingQueue();
//		Thread t1 = new Thread(bq1);
//		Thread t2 = new Thread(bq2);
//		t1.setName("t1");
//		t2.setName("t2");
//		t1.start();
//		t2.start();
		
		 new Thread(new Runnable() {  
	            @Override  
	            public void run() { 
	            	for (int i = 0 ; i < 100; i ++){
	            	try {
						bq1.insert(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	}
	            }
	     }, "t1").start();
		 
		 new Thread(new Runnable() {  
	            @Override  
	            public void run() { 
	            	for (int i = 0 ; i < 100; i ++){
	            	try {
						bq1.delete();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
	            	}
	            }
	     }, "t2").start();
	}
}
