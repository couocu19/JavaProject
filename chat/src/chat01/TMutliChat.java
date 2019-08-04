package chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *服务端：：：
 * 目标：1.加入容器实现群聊
 *       2.私聊
 *
 * */
public class TMutliChat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

    public static void main(String[] args) throws IOException {
        System.out.println("----Server------");
        ServerSocket server = new ServerSocket(8888);
        while(true) {
            Socket client = server.accept();

            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);//容器管理所有成员
            new Thread(c).start();
        }
    }

    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                //获取名称
                this.name = receive();
                this.send("欢迎你的到来哦");
                sendOthers(this.name+"来到了coucou聊天室",true);

            } catch (IOException e1) {
                //只要出错，就结束运行
                System.out.println("-----1-----");
                release();
            }
        }

        //接收消息
        private String receive(){
            String msg= "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("----2----");
                release();
            }

            return msg;
      }

    //发送消息
    private  void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("----3----");
            release();
        }

    }

    //群聊：获取自己的消息，发给其他人
        private  void sendOthers(String msg,boolean isSys) {
            boolean isPrivate = msg.startsWith("@");
            if (isPrivate) {
                int idx = msg.indexOf(":");
                //获取目标和数据
                String targetName = msg.substring(1,idx);
                msg = msg.substring(idx+1);
                for(Channel other:all){
                    if(other.name.equals(targetName)){
                        //目标
                        other.send(this.name+"悄悄地对你说:"+msg);
                        break;
                    }

                }


            } else {
                for (Channel other : all) {
                    if (other == this) {

                        continue;
                    }
                    if (!isSys) {
                        other.send(this.name + "::" + msg); //群聊

                    } else {
                        other.send(msg); //系统消息

                    }

                }
            }
        }

    //释放资源
    private void release(){
            this.isRunning = false;
            ReleaseReasours.close(dis,dos,client);
            //退出聊天
            all.remove(this);
            sendOthers(this.name+"离开了聊天室……",true);
    }


    public void run(){
            while(isRunning){
                String msg = receive();
                if(!msg.equals("")){
                   //send(msg);
                    sendOthers(msg,false); //代表不是系统消息
                }

            }
    }

}
}
