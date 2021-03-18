import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Scanner;

public class Peer2 {

	private static MulticastSocket socket;
	private static InetAddress group;
	private static HashMap<String, String> table;

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		
		table = new HashMap<String, String>();
		table.put("www.icesi.com", "100.0.0.4");
		table.put("www.alfa.com", "100.0.0.5");
		table.put("www.beta.com", "100.0.0.6");

		// Asincrono
		new Thread(() -> {
			try {
				socket = new MulticastSocket(5001);
				group = InetAddress.getByName("224.0.0.1");
				socket.joinGroup(group);

				while (true) {
					byte[] data = new byte[200];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					socket.receive(packet);
					String recibido = new String(packet.getData()).trim();
					System.out.println(recibido);
					
					String ip = table.get(recibido);
					System.out.println(packet.getSocketAddress());
					System.out.println(ip);

					//Responder al usuario si está el paquete
					if (ip != null) {
						DatagramPacket response = new DatagramPacket(ip.getBytes(), ip.getBytes().length,
								InetAddress.getByName("127.0.0.1"), 6000);
						socket.send(response);
					}else {
						ip = "No tengo esa dirección IP";
						DatagramPacket response = new DatagramPacket(ip.getBytes(), ip.getBytes().length,
								InetAddress.getByName("127.0.0.1"), 6000);
						socket.send(response);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();


	}
	
}
