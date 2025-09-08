package Punto2.Parte1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClient {
    static final String menu = "Seleccione una opción" +
            "\n1.  Convertir decimal a binario" +
            "\n2.  Convertir binario a decimal" +
            "\n3.  Convertir decimal a hexadecimal" +
            "\n4.  Convertir hexadecimal a decimal" +
            "\n5.  Convertir binario a hexadecimal" +
            "\n6.  Convertir hexadecimal a binario" +
            "\n7.  Para salir";

    static final String numeroEleccion = "Digite el numero a convertir";

    static final String numeroBits = "Digite el numero de bits"; //Este hay que usarlo dependiendo de la funcion

    public static void main(String[] args) {
        while (true){
            Scanner input = new Scanner(System.in);
            String mensaje = "";
            System.out.println(menu);
            int  opcion = input.nextInt();
            input.nextLine();
            mensaje = mensaje+opcion+";";
            System.out.println(numeroEleccion);
            String num = input.nextLine();
            mensaje = mensaje+num+";";
            if (opcion == 1 || opcion == 3 || opcion == 5 ){
                System.out.println(numeroBits);
                int numBits = input.nextInt();
                input.nextLine();
                mensaje = mensaje+numBits;
            }
            System.out.println(mensaje);

            enviarMensajeAlServidor(mensaje);
        }
    }

    public static String enviarMensajeAlServidor(String mensaje) {
        try {
            Socket socket = new Socket("localhost", 5000);

            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            salida.println(mensaje); // envía mensaje
            String respuesta = entrada.readLine(); // recibe respuesta

            socket.close();
            System.out.println(respuesta);
            return respuesta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}