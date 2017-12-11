package mojServerChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class nitserver extends Thread implements adresa{

	public nitserver(){
		
	}
	public void run(){
		try {
			ServerSocket ss=new ServerSocket(PORT);
			kontroler.getinstanca().prikaziPodatke("server konektovan ");
			
			while(true){
				Socket s=ss.accept();
			
				nitklijent nk=new nitklijent(s);
				
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
