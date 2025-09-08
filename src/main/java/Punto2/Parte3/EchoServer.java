package Punto2.Parte3;

import Punto1.ConversionSN;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // puerto
            Socket socket = server.accept(); // espera conexión

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje = entrada.readLine(); // lee mensaje del cliente
            salida.println(tratarMensaje(mensaje)); // lo reenvía

            socket.close();
            server.close();
        } catch (Exception e) {
            // normalmente se maneja, pero aquí lo dejamos vacío para simplificación
        }
    }

    private static String tratarMensaje(String mensaje) {
        ConversionSN converter = new ConversionSN();
        String[] partes = mensaje.split(" ");
        String resultado = "";
        switch(partes[0]) {
            case "1":
                resultado = converter.decimalABinario(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                break;
            case "2":
                resultado = ""+converter.binarioADecimal(partes[1]);
                break;
            case "3":
                resultado = converter.decimalAHexadecimal(Integer.parseInt(partes[1]),Integer.parseInt(partes[2]));
                break;
            case "4":
                resultado = ""+converter.hexadecimalADecimal(partes[1]);
                break;
            case "5":
                resultado = converter.binarioAHexadecimal(partes[1],Integer.parseInt(partes[2]));
                break;
            case "6":
                resultado = converter.hexadecimalABinario(partes[1]);
                break;
        }
        return resultado;
    }
}

