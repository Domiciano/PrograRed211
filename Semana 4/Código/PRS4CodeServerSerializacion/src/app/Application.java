package app;

import java.util.Calendar;
import java.util.Scanner;

import com.google.gson.Gson;

import comm.Emisor;
import comm.Receptor.OnMessageListener;
import comm.TCPConnection;
import model.Clase;

public class Application implements OnMessageListener {

	private TCPConnection connection;

	public Application() {

		connection = TCPConnection.getInstance();
		connection.setPuerto(5000);
		connection.setListenerOfMessages(this);

	}

	public void init() {
		connection.start();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine();

			Emisor m = connection.getEmisor();
			if (m != null)
				m.sendMessage(line);
			else
				System.out.println("Ningun cliente se ha conectado aun");
		}

	}

	@Override
	public void OnMessage(String msg) {
		System.out.println("Recibido: "+msg);
		
		Gson gson = new Gson();
		Clase[] objetoRecibido = gson.fromJson(msg, Clase[].class);
		
		System.out.println("Numero de clases: "+objetoRecibido.length);
		System.out.println("Primera clase: "+objetoRecibido[0].getName());
		System.out.println("Primera clase: "+objetoRecibido[0].getProfesor());
	}

}
