package chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PriChat {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server------");
        ServerSocket server = new ServerSocket(8888);
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
                DataInputStream dis  = new DataInputStream(client.getInputStream());
                DataOutputStream dos  = new DataOutputStream(client.getOutputStream());

                boolean isRunning = true;
                while (isRunning) {
                    //接收消息
                    String msg = dis.readUTF();
                    dos.writeUTF(msg);
                    dos.flush();
                }
                dos.close();
                dis.close();
                client.close();
        }
}
