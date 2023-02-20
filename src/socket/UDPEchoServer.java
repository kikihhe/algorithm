package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-11 21:33
 */
public class UDPEchoServer {
    private DatagramSocket socket;

    public UDPEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    // 启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动了..");
        while (true) {
            //1. 读取请求并解析
            //   socket将数据存放到DatagramPacket中
            DatagramPacket datagramPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(datagramPacket);

            //2. 根据请求计算响应

            //3. 把响应返回客户端
        }
    }
}
