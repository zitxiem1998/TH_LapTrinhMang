package bai_thuc_hanh_1.bai_thuc_hanh_1_bai_tap_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 5000;

    public static void main(String[] args) {
        Server server=new Server();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String charClient = dataInputStream.readUTF();
                dataOutputStream.writeUTF(server.convertLowerCase(charClient));
                dataOutputStream.writeUTF(server.convertUpperCase(charClient));
                dataOutputStream.writeInt((charClient.length()));
                socket.close();
            }
        } catch (Exception e) {
        }
    }

    public String convertUpperCase(String strings) {
        return strings.toUpperCase();
    }
    public String convertLowerCase(String strings) {
        return strings.toLowerCase();
    }
}
