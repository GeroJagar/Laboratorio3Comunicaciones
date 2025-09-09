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
            Scanner input = new Scanner(System.in);//Necesario para escanear en consola.
            String mensaje = ""; //Necesario para concatenar el mensaje final al servidor.

            System.out.println(menu);//Aquí se muestra la variable final que es el menú para el usuario.
            int  opcion = input.nextInt(); //Aquí lee la opción que el usuario elige.

            if (opcion==7){
                break;
            }else{
                input.nextLine();//Necesario para consumir el salto de linea sobrante.
                mensaje = mensaje+opcion+";"; //Concatena la opción con el mensaje final.

                System.out.println(numeroEleccion);//Le pregunta al usuario que número quiere convertir.
                String num = input.nextLine();//Lee el número digitado por el usuario.
                mensaje = mensaje+num+";";//Concatena el mensaje con el número.

                if (opcion == 1 || opcion == 3 || opcion == 5 ){ //Este if necesario ya que estas opciones, es necesario indicar la cantidad de bits.
                    System.out.println(numeroBits);//Le pregunta al usuario cuantos bits desea.
                    int numBits = input.nextInt();//Lee el número de bits.
                    input.nextLine();
                    mensaje = mensaje+numBits;//Concatena el número de bits con el mensaje.
                }else{
                    mensaje = mensaje+" ";
                }
                System.out.println(mensaje);//Con esto se muestra en consola el mensaje terminado

                enviarMensajeAlServidor(mensaje+"\n");//Aquí se envia al servidor para que sea tratado el mensaje, se agrega \n ya que lo pide el RFC.
            }
        }
    }

    /**
     * Método que envía un mensaje al servidor y espera la respuesta.
     *
     * Flujo de comunicación:
     * 1. Se crea un socket para conectarse al servidor en el puerto 5000 (localhost).
     * 2. Se obtiene un flujo de salida (OutputStream) para enviar el mensaje al servidor.
     * 3. Se obtiene un flujo de entrada (InputStream) para recibir la respuesta del servidor.
     * 4. Se envía el mensaje usando println() (termina con \n, necesario para readLine()).
     * 5. Se espera la respuesta del servidor con readLine().
     * 6. Se cierra la conexión.
     *
     * @param mensaje El mensaje a enviar al servidor.
     * @return La respuesta enviada por el servidor.
     */
    public static String enviarMensajeAlServidor(String mensaje) {
        try {
            // 1. Crear socket y conectar al servidor en localhost:5000
            Socket socket = new Socket("localhost", 5000);

            // 2. Preparar flujo de salida para enviar mensajes al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // 3. Preparar flujo de entrada para leer respuesta del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 4. Enviar el mensaje al servidor
            salida.println(mensaje);

            // 5. Esperar y leer la respuesta del servidor
            String respuesta = entrada.readLine();

            // 6. Cerrar conexión
            socket.close();

            // Mostrar y retornar la respuesta recibida
            System.out.println(respuesta);
            return respuesta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}