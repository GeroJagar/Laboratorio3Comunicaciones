import java.net.*;
import java.io.*;

public class EchoClient {
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