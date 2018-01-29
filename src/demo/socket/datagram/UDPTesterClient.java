package demo.socket.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTesterClient {

	public static void main(String[] args) {
		// Client
		DatagramSocket dgs = null;

		try {

			InetAddress ia = InetAddress.getLocalHost();

			String s = "test123";
			byte[] raw = s.getBytes();
			DatagramPacket dp = new DatagramPacket(
					raw, raw.length, ia, 4711);
			dgs = new DatagramSocket();
			dgs.send(dp);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (dgs != null) {
				dgs.close();
			}
		}
	}

}
