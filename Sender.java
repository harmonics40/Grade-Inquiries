import java.io.*;
import java.net.*;
public class Sender {
byte[] data;
byte[] tmp;
String msg;
DatagramSocket socket;
DatagramPacket pack;

public Sender(String ip, int port) 
  {
     try{         
	     data = new byte[50];
	     socket = new DatagramSocket();
		 pack = new DatagramPacket(data, data.length, InetAddress.getByName(ip), port);
        }
     catch(Exception e){
           System.out.println(e.toString());
           e.printStackTrace();
           System.exit(1);
        }		
  }
  
public void send(String msg) throws IOException
 {
		 tmp  = msg.getBytes();
		 for (int j=0; j<data.length; j++)  //*** importance  or get errors!
		    data[j]=0x00;
         for (int j=0; j<tmp.length; j++)
			data[j]=tmp[j];
         socket.send(pack);
 }
 
}
