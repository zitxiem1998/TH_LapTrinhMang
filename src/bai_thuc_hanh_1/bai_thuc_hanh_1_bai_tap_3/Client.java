package bai_thuc_hanh_1.bai_thuc_hanh_1_bai_tap_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String formClient;
            String formServer;
            while (true) {
                Socket soc = new Socket("localhost", 5000);
                DataOutputStream dataOutputStream = new DataOutputStream(soc.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(soc.getInputStream());
                System.out.print("Client: ");
                formClient = scanner.nextLine();
                if (formClient != null) {
                    dataOutputStream.writeUTF("Client: "+formClient);
                }
                formServer = dataInputStream.readUTF();
                System.out.println(formServer);
                if (formServer.equals("bye")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
