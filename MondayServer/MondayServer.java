import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MondayServer {

	public static void main(String[] args) throws IOException {
		int portNumber = 8000;
		ServerSocket listen =new ServerSocket(portNumber);
		System.out.println("Listening on port: "+listen.getLocalPort());
		while (true) {
			Socket client = listen.accept();
			System.out.println("Connection accepted");
			System.out.println("   From: "+client.getInetAddress());
			System.out.println("   Local port:  "+client.getLocalPort());
			System.out.println("   Remote port: "+client.getPort());
			PrintWriter out = new PrintWriter(client.getOutputStream());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			String line;
			line = in.readLine();
			System.out.println("Client sent: "+line);
//			out.println("Echo: "+line);
			line = in.readLine();
			System.out.println("Client sent: "+line);
			out.println("<html> <body>Some text<br/>Hello World</body></html>");
			
			in.close();
			out.close();
		}
	}

}
