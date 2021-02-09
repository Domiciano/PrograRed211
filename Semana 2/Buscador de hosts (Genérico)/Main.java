package main;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		InetAddress myAddress;
		try {
			myAddress = InetAddress.getLocalHost();

			NetworkInterface net = NetworkInterface.getByInetAddress(myAddress);
			int prefix = net.getInterfaceAddresses().get(0).getNetworkPrefixLength();

			long mask = 0;
			for (int i = 0; i < prefix; i++) {
				mask += 1L << (31 - i);
			}

			long miDireccion = 0;
			String[] add = myAddress.getHostAddress().toString().split("\\.");
			for (int i = 0; i < 4; i++) {
				long octetoActual = Long.parseLong(add[i]);
				int corrimiento = 8 * (3 - i);
				miDireccion += octetoActual << corrimiento;
			}
			long red = miDireccion & mask;
			int numeroDeHosts = (1 << (32 - prefix)) - 2;
			int timeout = 500;
			for (int i = 0; i < numeroDeHosts; i++) {
				long aProbar = red + 1 + i;
				String host = decAIp(aProbar);
				if(InetAddress.getByName(host).isReachable(timeout)) {
					System.out.println("Host accesible: "+host);
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static String decAIp(long dec) {
		String ip = "";
		for (int i = 0; i < 4; i++) {
			int corrimiento = 8 * (3 - i);
			long k = dec >> corrimiento;
			long aRestar = k << corrimiento;
			dec -= aRestar;
			ip+=k;
			if(i != 3) ip+='.';
		}
	
		return (ip);
	}

}
