package mojServerChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class nitklijent extends Thread{

	private Socket sok;
	private String klijent;
	public nitklijent(Socket s) {
		sok=s;
		start();
	}
	
	public void run(){
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(sok.getInputStream()));
	
			
				klijent = in.readLine();
				System.out.println("klijent koji nam se pridruzio je "+klijent);
			
			
			//System.out.println("klijnet je "+klijent);
			kontroler.getinstanca().prikaziPodatke("Klijent [" + klijent  + "] se povezao na server.");
			 kontroler.getinstanca().dodajnovogklijenta(this);
			 String poruka = null;
			
			 while(true){
				// System.out.println("\n"+"Poruka od klijenta12 while "+poruka);
				 poruka = in.readLine();
				// System.out.println("\n"+"Poruka od klijenta "+poruka);
				 if(poruka!=null && !poruka.isEmpty()){
					 
					  kontroler.getinstanca().obavesti(klijent + " kaze: " + poruka, this);
				 }
				 
			 }
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
        
	}
	public void posalji(String poruka) {
		try {
			PrintWriter pw=new PrintWriter(sok.getOutputStream(),true);//jebeno true
			pw.println(poruka);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getKlijent() {
		return klijent;
	}
	
	
	

}
