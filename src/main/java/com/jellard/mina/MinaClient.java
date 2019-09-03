package com.jellard.mina;

import java.net.InetSocketAddress;  
import java.nio.charset.Charset;  
  
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;  
import org.apache.mina.core.future.ConnectFuture;  
import org.apache.mina.filter.codec.ProtocolCodecFilter;  
import org.apache.mina.transport.socket.nio.NioSocketConnector;  
  
public class MinaClient {  
    private static final int bindPort=8899;  
    
    public static void main(String[] args){  
    	
    	for (int i = 0; i < 3; i++) {
            NioSocketConnector connector=new NioSocketConnector();  
            DefaultIoFilterChainBuilder chain=connector.getFilterChain();  
              
            ProtocolCodecFilter filter= new ProtocolCodecFilter(new HCoderFactory(Charset.forName("UTF-8")));   
            chain.addLast("objectFilter",filter);  
            connector.setHandler(new MinaClientHanlder());  
            connector.setConnectTimeoutCheckInterval(30);  
            ConnectFuture cf = connector.connect(new InetSocketAddress("192.168.1.18",bindPort));  
            cf.awaitUninterruptibly();  
            cf.getSession().getCloseFuture().awaitUninterruptibly();  
            connector.dispose();
		}
          
    }  
}  
