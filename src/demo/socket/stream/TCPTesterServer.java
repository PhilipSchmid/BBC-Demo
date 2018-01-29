/**
 * File   : TCPServer.java
 * Author : R. Scheurer (EIA-FR)
 * Date   : 28.09.2010
 * 
 * Description - a simple TCP server template
 *
 */
package demo.socket.stream;

import java.net.*;
import java.io.*;

public class TCPTesterServer {

	static final int SERVERPORT = 1300;
	static final String INET_ADDRESS = "127.0.0.1";
	static int id = 0; // client id
	private static ServerSocket serverSocket;

	public TCPTesterServer() throws IOException {
		serverSocket = new ServerSocket();
	}

	/**
	 * Constructor to build this object
	 * 
	 * @param localPort local port on which socket should be started
	 * @throws IOException
	 */
	public TCPTesterServer(int localPort) throws IOException {
		serverSocket = new ServerSocket(localPort);
	}

	/**
	 * Constructor to build this object
	 * 
	 * @param localAddress local ip address of server
	 * @param localPort local port on which socket should be started
	 * @param backlog a positive integer, if = 0, default value is attributed
	 * @throws IOException
	 */
	public TCPTesterServer(int localPort, int backlog, InetAddress localAddress) throws IOException {
		serverSocket = new ServerSocket(localPort, backlog, localAddress);
	}

	/**
	 * Constructor which builds this object
	 * 
	 * @param isa InetSocketAddress including ip and port number on which socket should be started
	 * @throws IOException
	 */
	public TCPTesterServer(InetSocketAddress isa, int backlog) throws IOException {
		serverSocket = new ServerSocket(isa.getPort(), backlog, isa.getAddress());
	}

	/**
	 * Opens a socket on the default SERVERPORT
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {
		serverSocket = new ServerSocket(SERVERPORT);
	}
	

	public static void main(String[] args) {
		
		try{
			InetAddress ia = InetAddress.getByName(INET_ADDRESS);
			InetSocketAddress isa = new InetSocketAddress(ia, SERVERPORT);
			new TCPTesterServer(isa, 0); // creating tcp server with default backlog (0)
			setStatus("Server Started!");
			while (true) {
				setStatus("Server waiting for connections.");
				Socket s = serverSocket.accept();
				setStatus("Server received connection from client.");
				ServerThread serverThread = new ServerThread(s);
				serverThread.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			
		}
	}
	
	static void setStatus(String msg) {
		System.out.println(msg);
	}
}


class ServerThread extends Thread {
	Socket socket;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	ServerThread(Socket s) {
		socket = s;
	}
	
	public void run() {
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject("Hi Client, got any problems?");
			read();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void read() throws IOException, ClassNotFoundException {
		String string;
		while ((string = (String) in.readObject()) != null) {
			System.out.println(string);
		}
	}
}
