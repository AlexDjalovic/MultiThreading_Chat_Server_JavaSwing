package mojServerChat;

import java.util.ArrayList;

public class kontroler {

	private static kontroler instanca;
	private serverforma sf;
	ArrayList<nitklijent>lista=new ArrayList<>();
	
	public static kontroler getinstanca(){
		if(instanca==null){
			instanca=new kontroler();
		}
		return instanca;
	}
	
	public void prikaziPodatke(String s){
		sf.postavinaformu(s);
	}
	public void postaviFormu(serverforma ss){
		sf=ss;
	}
	public void dodajnovogklijenta(nitklijent nk){
		lista.add(nk);
		System.out.println("dodat novi klijent "+nk.getKlijent());
	}
	public void obavesti(String poruka,nitklijent nk){
		for(nitklijent k:lista){
			if(!k.equals(nk)){
				k.posalji(poruka);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
