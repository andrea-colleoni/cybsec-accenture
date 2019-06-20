package esempi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// inizio una nuova comunicazione di rete usando un socket...
		// è da questo programma che decido di "iniziare" la comunicazione, quindi mi trovo a svolgere
		// il ruolo di "client"
		Socket s = new Socket("www.myferramenta-milano.it", 80);
		// una volta ottenuto un socket, da questo posso ottenere un riferimento allo stream in 
		// lettura e in scrittura, quindi posso comunicare con il mio interlocutore
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		// conoscendo il protocollo di comunicazione accettato dal mio interlocutore, provo ad inviare
		// un comando, sperando che il server lo accetti
		String comando = "GET / HTTP/1.1\r\n" + 
				"Host: www.myferramenta-milano.it\r\n" + 
				"Connection: keep-alive\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3\r\n" + 
				"Accept-Encoding: deflate\r\n" + 
				"Accept-Language: it-IT,it;q=0.9,en-US;q=0.8,en;q=0.7,fr;q=0.6\r\n\r\n";
		pw.println(comando);
		// se il comando è accettato e la connessione è funzionante, il server mi invierà una
		// risposta.
		int risposta = br.read();
		while( risposta != -1 ) {
			System.out.println((char)risposta);
			risposta = br.read();
		}
	}

}
