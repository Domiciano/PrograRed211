package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	
	public static void main(String[] args) {
		try {
			 System.out.println("Enviando solicitud...");
			 Socket socket = new Socket("127.0.0.1", 5000);
			 System.out.println("Conectados");
			 
			 String path = "/Users/domicianorincon/Documents/Recibido/videoRecibido.mp4";
			 File archivoRecibido = new File(path);
			 
			 InputStream is = socket.getInputStream();
			 FileOutputStream fos = new FileOutputStream(archivoRecibido);
			 
			 byte[] buffer = new byte[128];
			 int bytesLeidos = 0;
			 
			 while( (bytesLeidos = is.read(buffer)) != -1 ) {
				 fos.write(buffer, 0, bytesLeidos);
			 }
			 is.close();
			 fos.close();
			 
			 while(true) {}
			 
			 
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
