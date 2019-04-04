package velasco.v;

public class WarMain 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome to WAR!\n");
		
		Producer pro = new Producer(-1);
		Consumer con = new Consumer(-1);
		
		System.out.println("Producer has started running");
		pro.start();
		
		System.out.println("Consumer has started running");
		con.start();
		
	}

}
