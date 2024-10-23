package leccion19;

import utilitarios.UtilitariosGenerales;

import java.io.*;
import java.net.Socket;

public class EjemploSocket {

    public void crearSocketParaSolicitudServidorLocal() {
        String servidor = "localhost";
        int puerto = 8080;

        try (Socket socket = new Socket(servidor, puerto)) {
            System.out.println("Conectado al servidor en " + servidor + ":" + puerto);

            // Envía un mensaje al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            salida.println("¡Hola, servidor!");
            salida.flush();

            // Lee la respuesta del servidor
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cierra el socket después de la comunicación
            socket.close();
            System.out.println("Conexión cerrada con el servidor");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearSocketParaSolicitudHTTP() {
        String host = "example.com"; // Un servidor público o una API REST pública.
        int puerto = 80;  // Puerto por defecto para HTTP

        try (Socket socket = new Socket(host, puerto)) {
            // Escribir la solicitud HTTP
            OutputStream salida = socket.getOutputStream();
            String solicitud = "GET / HTTP/1.1\r\n" +
                "Host: " + host + "\r\n" +
                "Connection: close\r\n\r\n";
            salida.write(solicitud.getBytes());
            salida.flush();

            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EjemploSocket ejemploSocket = new EjemploSocket();
        // ejemploSocket.crearSocketParaSolicitudServidorLocal();
        UtilitariosGenerales.imprimirLineasSeparacion();
        ejemploSocket.crearSocketParaSolicitudHTTP();
    }
}
