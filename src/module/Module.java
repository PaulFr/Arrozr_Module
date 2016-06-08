package module;

import connection.Communicator;

public class Module {
	
	public static void main(String[] argrs){
		Module module = new Module("toto");
		Communicator com = new Communicator("COM2");
		com.searchForPorts();
		com.connect();
		if (com.getConnected() == true)
        {
            if (com.initIOStream() == true)
            {
                com.initListener();
            }
        }
		
		com.sendData(17);
		com.disconnect();
	}

	private String id;
	private int humidite;
	private int[][] horraires;
	private int etat;
	
	public Module(String id){
		this.id = id;
		this.setEtat(0);
		setHumidite(0);
		setHorraires(new int[7][48]);
	}

	public int getHumidite() {
		return humidite;
	}

	public void setHumidite(int humidite) {
		this.humidite = humidite;
	}

	public int[][] getHorraires() {
		return horraires;
	}

	public void setHorraires(int[][] horraires) {
		this.horraires = horraires;
	}

	private int getEtat() {
		return etat;
	}

	private void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	
	public void askConfig(){
		this.humidite = 30;
		for(int i = 0; i < 7; i++){
			for(int j=0; j < 48; j++){
				this.horraires[i][j]=1;
			}
		}
	}
	
	public void arrose(){
		this.setEtat(1);
	}
	
	public void start(){
		this.askConfig();
	}
}
