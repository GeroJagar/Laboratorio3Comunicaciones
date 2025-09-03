import java.net.*;
import java.io.*;

public class EchoClient {
    final String menu = "Seleccione una opción" +
            "\n1.  Convertir decimal a binario" +
            "\n2.  Convertir binario a decimal" +
            "\n3.  Convertir decimal a hexadecimal" +
            "\n4.  Convertir hexadecimal a decimal" +
            "\n5.  Convertir binario a hexadecimal" +
            "\n6.  Convertir hexadecimal a binario";

    final String numeroEleccion = "Digite el numero a convertir";

    final String numeroBits = "Digite el numero de bits"; //Este hay que usarlo dependiendo de la funcion

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            salida.println("Hola servidor!"); // envía mensaje
            String respuesta = entrada.readLine(); // recibe respuesta

            System.out.println("Respuesta del servidor: " + respuesta);

            socket.close();
        } catch (Exception e) {
            // se ignora por simplicidad
        }
    }
}