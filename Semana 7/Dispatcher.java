import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Dispatcher {

	private static DatagramSocket socket;

	public static void main(String[] args) {
		
		// Asincrono
		new Thread(() -> {
			try {
				socket = new DatagramSocket(6000);
				while (true) {
					
					byte[] data = new byte[200];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					socket.receive(packet);
					String recibido = new String(packet.getData()).trim();
					System.out.println(recibido);
					
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				String line = scanner.nextLine();
				DatagramPacket packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("224.0.0.1"), 5000);
				socket.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}
