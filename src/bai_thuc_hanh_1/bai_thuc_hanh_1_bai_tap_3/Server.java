package bai_thuc_hanh_1.bai_thuc_hanh_1_bai_tap_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final int port=5000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Server server = new Server();
        ServerSocket serverSocket;
        String formClient;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                formClient = dataInputStream.readUTF();
                if (formClient != null) {
                    dataOutputStream.writeUTF(formClient);
                }
                if (formClient.equals("bye")) {
                    break;
                }
                socket.close();
            }
        } catch (Exception e) {
        }
    }

    public String chatClient(String charClient) {
        switch (charClient) {
            case "hello": {
                return "Xin chao ban";
            }
            case "who": {
                return "Toi la server";
            }
            case "bye": {
                return "bye";
            }
            case "hihi": {
                return "Cuoi cai qq. haha.";
            }
            default: {
                return "Toi khong hieu ban dang noi gi";
            }
        }
    }
}
