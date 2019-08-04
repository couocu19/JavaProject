package chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标：使用多线程实现多个客户可以正常收发多条消息
 * 问题：其他客户必须等待之前的客户退出，才能继续
 *
 *
 * */
public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server------");
        ServerSocket server = new ServerSocket(8888);
        while(true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");

            new Thread(()->{
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    //接收消息
                    String msg;
                    try {
                        msg = dis.readUTF();
                        //返回消息
                        dos.writeUTF(msg);
                        //释放资源
                        dos.flush();
                    } catch (IOException e) {
                        //e.printStackTrace();
                        isRunning = false; //停止线程
                    }
                }
                try {
                    if(null==dos) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(null==dis) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if(null==client) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();


        }



    }
}
