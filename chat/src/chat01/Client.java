package chat01;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室：客户端
 * 目标：加入容器实现群聊
 * 私聊：约定数据格式：@xxx：msg
 *
 * */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("----Client------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name = br.readLine();
        Socket client = new Socket("192.168.1.90",8888);
        //客户端发送消息
        new Thread(new TSend(client,name)).start();
        new Thread(new TReceive(client)).start();

    }
}
