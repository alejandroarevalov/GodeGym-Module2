package leccion19;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceptorUDP {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            System.out.println("Esperando entrega de paquetes...");
            while (true) {
                DatagramPacket paquete = new DatagramPacket(new byte[1024], 1024);
                socket.receive(paquete);
                String recibido = new String(paquete.getData(), 0, paquete.getLength());
                System.out.println("Mensaje recibido: " + recibido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}