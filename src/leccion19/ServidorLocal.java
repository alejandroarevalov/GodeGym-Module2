package leccion19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorLocal {

    public void lanzarServidorLocal() {
        int puerto = 8080;
        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);
            while(true) {
                Socket socket = servidorSocket.accept();
                System.out.println("Cliente conectado desde: " + socket.getInetAddress());

                BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );
                String mensaje = entrada.readLine();
                System.out.println("Mensaje recibido del cliente: " + mensaje);

                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                salida.println("Mensaje recibido correctamente");

                socket.close();
                System.out.println("Conexión cerrada con el cliente");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ServidorLocal servidorLocal = new ServidorLocal();
        servidorLocal.lanzarServidorLocal();
    }
}
