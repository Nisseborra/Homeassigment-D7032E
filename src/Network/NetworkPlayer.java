package network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;






public class NetworkPlayer{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void reaciveMessage(){
        Thread recevier = new Thread(()->{
            try {
                String message;
                while((message = in.readLine()) != null){       
                    System.out.println(message);

                }
            System.out.println("disconnect");

                
                
            } catch (Exception e) {
                 System.out.println("Connection closed");
            }


        });
        recevier.setDaemon(true);
        recevier.start();
    }

    public void SendMessage(String Msg){
        out.println(Msg);
    }



    public static void main(String[] args) {
    
    System.out.print("port:"+Integer.parseInt(args[1]));
		try {
			if (args.length < 2) {
				throw new IllegalArgumentException("Usage: NetworkPlayer <IP> <Port> ");
			}
            System.out.println("\n begfore make player");

			NetworkPlayer player = new NetworkPlayer();

            player.connect(args[0], Integer.parseInt(args[1]));
            player.reaciveMessage();

            
		
		} catch(Exception e) {
            System.out.println("Cant bla bla bla");
		}





	}
  
     
}







     












