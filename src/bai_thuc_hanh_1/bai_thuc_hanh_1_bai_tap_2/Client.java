package bai_thuc_hanh_1.bai_thuc_hanh_1_bai_tap_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try {
        Socket soc = new Socket("localhost", 4500);
        DataOutputStream dataOutputStream=new DataOutputStream(soc.getOutputStream());
        DataInputStream dataInputStream=new DataInputStream(soc.getInputStream());
        System.out.print("Moi ban nhap chuoi: ");
        String strings = scanner.nextLine();
        dataOutputStream.writeUTF(strings);
        int result= dataInputStream.readInt();
            System.out.println(result);

    } catch (Exception e) {
        System.out.println("Error");
    }
}
}
