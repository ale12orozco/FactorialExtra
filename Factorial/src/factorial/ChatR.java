package factorial;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatR {
	public static void main(String[] args){

	     try {


	    System.out.println("Bienvenidos a mi chat");
	    System.out.println("Ingresa los datos que se te solicitan:");

		//Declaracion de variables
		Scanner entrada = new Scanner(System.in);
		System.out.println("teclea tu nombre:");
		String nombre = entrada.nextLine();		
		System.out.println("teclea la IP de la otra persona");
		String ip = entrada.nextLine();
		System.out.println("teclea tu puerto");
		int tuPuerto = Integer.parseInt(entrada.nextLine());
		System.out.println("teclea el puerto de la otra persona");
		int puerto2 = Integer.parseInt(entrada.nextLine());
		
	


		//Inicializacion del socket
		//InetAddress con la otra pc
		InetAddress maqChat = InetAddress.getByName(ip);
		// creacion del socket
		Socket socket = new Socket(maqChat, puerto2);
				
		//Se hace la conexion
		ServerSocket sConexion = new ServerSocket(tuPuerto);
		Socket sDato = sConexion.accept();
		
		//Entradas y salidas
		InputStream fEntrada = socket.getInputStream();
		BufferedReader socketInput = new BufferedReader(new InputStreamReader(fEntrada));
		OutputStream fSalida = sDato.getOutputStream();
		PrintWriter salidaS = new PrintWriter(new OutputStreamWriter(fSalida));
			
		System.out.println("La conexion esta lista");
		


		//Condicion para terminar con el chat 
	

		//Recibe 
		System.out.println("El numero es:");
		String recibido = socketInput.readLine();
		System.out.println(recibido);

		//Envia
		System.out.println("El factorial es:");
		double numero = Integer.parseInt(recibido);
		double factorial=1;
		    while ( numero!=0) {
		      factorial=factorial*numero;
		      numero--;
		    }
		String enviado =String.valueOf(factorial);
		System.out.println(enviado);
		salidaS.println(enviado);
		salidaS.flush();
	  
		//Corta la conexion
		socket.close();
		System.out.println("Adios: "+nombre);
		
      }
	   catch (Exception ex){
		ex.printStackTrace();
      }
    }
  }
