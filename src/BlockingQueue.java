import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue extends Thread{
	private Queue<Integer> queue = new LinkedList<Integer>();
	private int size = 1;
	int k = 0;
	
	public void insert(int a) throws InterruptedException{
		synchronized (queue) {
			while (isFull()){
				System.out.println("wait");
				queue.wait();
			}
		k++;
		System.out.println("insert");
		
		queue.add(a);
		System.out.println(this.getName() + " queue size:" + queue.size() + " k:" + k);
		
		queue.notifyAll();
		
		}
	}
	
	public void delete() throws InterruptedException{
		synchronized (queue) {
			System.out.println("after wait get the block");
			while (isEmpty()){
				queue.wait();
			}
			System.out.println("delete");
		
		queue.remove();
		System.out.println(this.getName() + " queue size:" + queue.size() + " k:" + k);
		
		queue.notifyAll();
		}
	}

	private boolean isEmpty() {
		if (queue.size() == 0) return true;
		return false;
	}

	private boolean isFull() {
		if (queue.size() == size) return true;
		return false;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100 ; i ++){
				if (i % 2== 0){
					insert(1);
				}else{
					delete();
				}
			}
				
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
