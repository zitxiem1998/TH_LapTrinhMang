package bai_thuc_hanh_1.bai_thuc_hanh_1_bai_tap_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try {
            Socket soc = new Socket("localhost", 5000);
            DataOutputStream dataOutputStream=new DataOutputStream(soc.getOutputStream());
            DataInputStream dataInputStream=new DataInputStream(soc.getInputStream());
            System.out.print("Moi ban nhap chuoi: ");
            String strings = scanner.nextLine();
            dataOutputStream.writeUTF(strings);
            String resultLowercase= dataInputStream.readUTF();
            String resultUppercase =dataInputStream.readUTF();
            int lengthOfStrings=dataInputStream.readInt();
            System.out.println("Chuoi cua ban sau khi chuyen doi thanh chuoi thuong la: "+resultLowercase);
            System.out.println("Chuoi cua ban sau khi chuyen doi thanh chuoi hoa la: "+resultUppercase);
            System.out.println("Do dai cua chuoi ban nhap vao la: "+ lengthOfStrings);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
