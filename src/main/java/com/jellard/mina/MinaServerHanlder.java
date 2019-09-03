package com.jellard.mina;

import org.apache.mina.core.service.IoHandlerAdapter;  
import org.apache.mina.core.session.IoSession;  
  
public class MinaServerHanlder extends IoHandlerAdapter {  
    private int count = 0;  
  
    public void sessionCreated(IoSession session) {  
        System.out.println("session created");  
    }  
  
    @Override  
    public void sessionOpened(IoSession session) throws Exception {  
        count++;  
        System.out.println("count+ " + count + session.getRemoteAddress());  
    }  
  
    @Override  
    public void sessionClosed(IoSession session) throws Exception {  
        session.close();  
        System.out.println("I'm Client &&  I closed!");  
    }  
  
    @Override  
    public void messageReceived(IoSession session, Object message)  
            throws Exception {  
        PlayerAccount_Entity ho = (PlayerAccount_Entity) message;  
        System.out.println("Client message="+ho.getId()+ho.getName()+ho.getEmailAdress()+ho.getSex()); 
        System.out.println(this);
        //session.write(ho);  
    }  
}  
