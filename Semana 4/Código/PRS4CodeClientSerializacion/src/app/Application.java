package app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.google.gson.Gson;

import comm.Emisor;
import comm.Receptor.OnMessageListener;
import comm.TCPConnection;
import model.Clase;
import model.Estudiante;

public class Application implements OnMessageListener{
	
	private TCPConnection connection;
	
	public Application() {
			
		connection = TCPConnection.getInstance();
		connection.setIp("127.0.0.1");
		connection.setPuerto(5000);
		connection.setListenerOfMessages(this);
		
	}
	
	public void init() {
		connection.start();
		
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();
			
			Clase sistemas = new Clase("Navarro","Señales y sistemas");
			Clase redes = new Clase("Cuellar", "Redes");
			ArrayList<Clase> clases = new ArrayList<Clase>();
			clases.add(sistemas);
			clases.add(redes);
			Estudiante estudiante = new Estudiante("Pepito Perez","A9012314", clases);
			Gson gson = new Gson();
			String json = gson.toJson(clases);
			System.out.println(json);
			
			Emisor m = connection.getEmisor();
			if(m!=null)m.sendMessage(json);
			else System.out.println("No hay cliente conectado aún");
		}
		
	}

	
	
	
	@Override
	public void OnMessage(String msg) {
		System.out.println("Recibido: "+msg);
	}

	
	

	
	

}
