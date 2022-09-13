package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class CilentHandler implements Runnable{
    private Socket socket;

    public CilentHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            String line=readLine();
            System.out.println("读取内容"+line);
            //请求的相关信息
            String method;//请求方式
            String uri;//抽象路径
            String protocol;//版本
            String[] spString = line.split(" ");
            method = spString[0];
            uri = spString[1];
            protocol = spString[2];
            System.out.println("method"+method);
            System.out.println("uri"+uri);
            System.out.println("protocol"+protocol);
            while(true) {
                //读取消息头
                line = readLine();
                //如果单独读到空的则为空行，结束
                if (line.isEmpty()){
                    break;
                }
                System.out.println("消息头:"+line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public String readLine() throws IOException{
        InputStream in=socket.getInputStream();
        StringBuilder builder=new StringBuilder();
        int d;
        char pre = 'a', cur = 'a';
        while ((d = in.read()) != -1) {
            cur = (char) d;//本次读到的字符
            if (pre == 13 && cur == 10) {
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }
}
