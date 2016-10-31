package factorial;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatE {
	public static void main(String[] args){

	
	  try{

	  	System.out.println("Bienvenidos a mi chat");
	  	System.out.println("Ingresa los datos que se te solicitan:");
		
		//Declaracion de variables
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("teclea tu nombre:");
		String nombre = entrada.nextLine();	
		System.out.println("teclea tu puerto");
		int tuPuerto = Integer.parseInt(entrada.nextLine());
		System.out.println("teclea el puerto de la otra persona");
		int puerto2 = Integer.parseInt(entrada.nextLine());


		//Inicializacion del socket
		ServerSocket sConexion = new ServerSocket(tuPuerto);
		
		//Conexion
		System.out.println("Espera a que se confirme la conexion");
		Socket sDato = sConexion.accept();		
		System.out.println("La conexion esta lista");
		

		//InetAddress con la otra pc
		InetAddress maqChat = sDato.getInetAddress();
		// creacion del socket
		Socket socket = new Socket(maqChat, puerto2);
		

		//Entradas y salidas
		InputStream fEntrada = socket.getInputStream();
		BufferedReader socketInput = new BufferedReader(new InputStreamReader(fEntrada));
		OutputStream fSalida = sDato.getOutputStream();
		PrintWriter salidaS = new PrintWriter(new OutputStreamWriter(fSalida));		


		//Envia
		System.out.println("Teclea un nuero para calcular su factorial"); 
		String enviado = entrada.nextLine();
		System.out.println("");
		salidaS.println(enviado);
		salidaS.flush(); 
		
		//Recibe 
		System.out.println("El factorial es:");
		String recibido = socketInput.readLine();
		System.out.println(recibido);
		
	     

		//Corta la conexion		
		socket.close();
		System.out.println("Adios: "+nombre);
      }
	catch (Exception ex){
	   ex.printStackTrace();
      }
     }	
    }
  	
 
