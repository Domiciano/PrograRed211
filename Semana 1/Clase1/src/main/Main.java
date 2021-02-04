package main;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class Main {

	public static void main(String... args) {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			
			while(interfaces.hasMoreElements()) {
				NetworkInterface netN = interfaces.nextElement();
				if(netN.isUp()) {
					System.out.println(netN.getName());
					if(netN.getHardwareAddress() != null) {
						//Este uno representa el signo: 1 para positivo
						String mac = new BigInteger(1, netN.getHardwareAddress()).toString(16);
						System.out.println(mac);
						//1a:e2:f1:b2:33:85
						
						List<InterfaceAddress> list = netN.getInterfaceAddresses();
						for(int i=0 ; i<list.size() ; i++) {
							System.out.println(">>>"+list.get(i));
						}
					}
				}
				
				//Dirección MAC = Dirección Física
				//Dirección IP = Indentificación de red

				//LECTURA: Colombia y el IPV6
				//https://mintic.gov.co/portal/inicio/Sala-de-Prensa/Noticias/126452:Que-es-el-protocolo-IPv6-y-por-que-es-importante-entender-la-urgencia-de-su-implementacion

				//TEST: IPV6
				//https://test-ipv6.com/				
			}
			
			
			InetAddress myAddress = InetAddress.getLocalHost();
			System.out.println(myAddress.getHostName());
			System.out.println(myAddress.getHostAddress());
			
			//Extraer prefijo, prefijo de subred
			NetworkInterface net = NetworkInterface.getByInetAddress(myAddress);
			System.out.println("Network prefix: "+net.getInterfaceAddresses().get(1).getNetworkPrefixLength());
			
			
			
			//******************
			//CÓDIGO DEL SIGUIENTE VIDEO
			//******************
			
			
			//ICMP
			InetAddress ubuntu = InetAddress.getByName("192.168.0.12");
			System.out.println("Ubuntu connected: "+ubuntu.isReachable(0));
			
			InetAddress motox4 = InetAddress.getByName("192.168.0.21");
			System.out.println("MotoX4 connected: "+motox4.isReachable(0));
			
			
			
		}catch(SocketException ex) {
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
