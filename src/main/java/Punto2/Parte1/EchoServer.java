package Punto2.Parte1;

import Punto1.ConversionSN;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            // 1. Crear un ServerSocket que escucha conexiones en el puerto 5000
            ServerSocket server = new ServerSocket(5000);

            // 2. Esperar a que un cliente se conecte (bloqueante)
            Socket socket = server.accept();

            // 3. Preparar flujo de entrada para leer datos enviados por el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 4. Preparar flujo de salida para enviar respuesta al cliente
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // 5. Leer mensaje enviado por el cliente (termina en \n porque se usó println en el cliente)
            String mensaje = entrada.readLine();

            // 6. Procesar mensaje con la lógica de conversión y enviar resultado al cliente
            salida.println(tratarMensaje(mensaje)+"\n");

            // 7. Cerrar la conexión con el cliente y el servidor
            socket.close();
            server.close();
        } catch (Exception e) {
            // En una app real deberías manejar la excepción (logs, retry, etc.)
        }
    }

    private static String tratarMensaje(String mensaje) {
        ConversionSN converter = new ConversionSN(); //Necesario para realizar la conversion de unidades.
        String[] partes = mensaje.split(";"); //Se necesita el Split para poder hacer la conversion.
        String resultado = ""; //Variable a retornar.
        switch(partes[0]) {//Con el indice 0 del split, nos indica cual conversion debe hacer.
            case "1":
                resultado = converter.decimalABinario(Integer.parseInt(partes[1]), Integer.parseInt(partes[2])); //El indice 1 nos indica que número se debe convertir. Mientras que con el indice 2, nos indica el número de bits para la conversion, si es que lo necesita.
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

