package leccion19;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

public class EmisorUDP {
    private String host;
    private int puerto;

    public EmisorUDP(String host, int port) {
        this.host = host;
        this.puerto = port;
    }

    public void enviarMensaje(String mensaje) {
        try {
            byte[] data = mensaje.getBytes();
            InetAddress direccion = InetAddress.getByName(host);
            DatagramPacket paquete = new DatagramPacket(data, data.length, direccion, puerto);
            DatagramSocket socket = new DatagramSocket();
            socket.send(paquete);
            socket.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        EmisorUDP cliente = new EmisorUDP("localhost", 9876);
        String message = "Hola receptor!";

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cliente.enviarMensaje(message);
                System.out.println("Mensaje enviado: " + message);
                System.out.println("---");
            }
        }, 5000, 2000);
    }

}
