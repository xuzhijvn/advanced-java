package com.xzj.websocket.demo;

import java.io.IOException;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/ws2/{userId}")
public class WSServer2 {


    private static String userId;

    //连接时执行
    @OnOpen
    public void onOpen(@PathParam("userId") String userId,Session session) throws IOException{
        this.userId = userId;
        System.out.println("新连接: "+userId);
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            session.getBasicRemote().sendText(new Date().toGMTString()); //回复用户
        }
    }

    //关闭时执行
    @OnClose
    public void onClose(){
        System.out.println("连接: "+userId+"关闭");
    }

    //收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("收到："+message+"的消息"+message);
        session.getBasicRemote().sendText("收到 "+this.userId+" 的消息 "); //回复用户
    }

    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("用户id为: "+userId+"的连接发生错误");
        error.printStackTrace();
    }

}