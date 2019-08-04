package chat01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装了接收端
 * 1.接收消息
 * 2.释放资源
 * 3.重写run()
 * */
public class TReceive implements Runnable {
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning = true;

    public TReceive(Socket client){
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("===2===");
            release();
        }

    }
    //接收消息
    private String receive(){
        String msg= "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("===4===");
            release();
        }

        return msg;
    }


    public void run(){
        while(isRunning){
            String msg = receive();
            if(!msg.equals("")){

                System.out.println(msg);
            }


        }

    }

    private  void release(){
        this.isRunning = false;
        ReleaseReasours.close(dis,client);
    }
}
