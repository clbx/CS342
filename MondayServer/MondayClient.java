import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MondayClient {

	public static void main(String[] args) {
		int portNumber = 80;
		String ipAddress = "10.4.10.33";
		Socket sock = null;

		for (portNumber = 22; portNumber<81; portNumber++) {
			System.out.println("Trying port: "+portNumber);
			try {
				sock = new Socket(ipAddress,portNumber);
			} catch (UnknownHostException e) {
				System.out.println("Unknown host error: "+ipAddress);
				return;
			} catch (IOException e) {
				System.out.println("IO Exception error - port not open");
				//e.printStackTrace();
				//return;
				continue;
			}
			try {
				System.out.println("Connected, now closing");
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}

/*
		PrintWriter out;
		try {
			out = new PrintWriter(sock.getOutputStream(),true);
		} catch (IOException e) {
			System.out.println("IO Exception when creating the printWriter");
			e.printStackTrace();
			return;
		}
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (IOException e) {
			System.out.println("IO Exception when creating Input Stream Reader");
			e.printStackTrace();
			return;
		}
		// We are finally ready to communicate
		System.out.println("Connected to: "+sock.getInetAddress()+" on port: "+sock.getPort());
		System.out.println("Local address: "+sock.getLocalAddress()+" Local port: "+sock.getLocalPort());

		out.println();
		out.println();

		String line;
		try {
			line = in.readLine();
		} catch (IOException e) {
			System.out.println("Error when trying to read");
			e.printStackTrace();
			return;
		}
		System.out.println("Input: "+line);
		try {
			in.close();
		} catch (IOException e) {
			System.out.println("Error when trying to close input stream");
			e.printStackTrace();
		}
		out.close();
*/
	}

}
