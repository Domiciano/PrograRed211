package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
	
		
		try {
			ServerSocket server = new ServerSocket(5000);
			 System.out.println("Esperando conexión");
			 Socket socket = server.accept();
			 System.out.println("Conectado");
			 
			 String path = "/Users/domicianorincon/Documents/Por enviar/video.mp4";
			 File file = new File(path);
			 
			 FileInputStream fis = new FileInputStream(file);
			 OutputStream os = socket.getOutputStream();
			 
			 byte[] buffer = new byte[128];
			 int bytesLeidos = 0;
			 
			 while( (bytesLeidos = fis.read(buffer)) != -1 ) {
				 os.write(buffer, 0, bytesLeidos);
			 }
			 fis.close();
			 os.close();
			 
			 while(true) {}
			 
			 
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
