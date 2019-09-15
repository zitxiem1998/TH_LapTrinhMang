package bai_thuc_hanh_1.bai_thuc_hanh_1_bai_tap_2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 4500;

    public static void main(String[] args) {
        Server server = new Server();
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String charClient = dataInputStream.readUTF();
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                System.out.println((Integer)engine.eval(charClient));
                dataOutputStream.writeInt((Integer) engine.eval(charClient));
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
