package chat01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.Socket;

/**
 * 使用多线程封装了发送端
 * 1.发送消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重新run
 * */
public class TSend implements Runnable{
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning = true;
    public TSend(Socket client,String name){
        this.client = client;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream()) ;
            //发送名称
            send(name);
        } catch (IOException e) {
            System.out.println("==1==");
            this.release();
        }

    }

    public void run(){

        while(isRunning){
            String msg = getStrFromConsole();
            if(!msg.equals("")){
                send(msg);
            }
        }
    }

    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("===3===");
            release();
        }


    }


    //从控制台获取消息
    private String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private  void release(){
        this.isRunning = false;
        ReleaseReasours.close(dos,client);
    }
}
