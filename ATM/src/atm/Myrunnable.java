package atm;

public class Myrunnable implements Runnable{
@Override
public void run() {
	for(int i = 1;i<=60;i++) {
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		System.out.println("Thread was Interrupted!");
	}
	if(i==60) {
		System.out.println("Transaction Timed Out!");
		System.exit(0);
	}
	}}
}
