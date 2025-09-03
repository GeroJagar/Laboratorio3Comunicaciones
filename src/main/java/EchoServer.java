import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // puerto
            Socket socket = server.accept(); // espera conexión

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje = entrada.readLine(); // lee mensaje del cliente
            salida.println("Echo: " + mensaje); // lo reenvía

            socket.close();
            server.close();
        } catch (Exception e) {
            // normalmente se maneja, pero aquí lo dejamos vacío para simplificación
        }
    }
}

