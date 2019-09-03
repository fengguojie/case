package com.jellard.mina;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
	
	private static final int bindPort=8899; 
	
	private static final int bindPort2 = 8888;
	
    public static void main(String[] args){  
        SocketAcceptor acceptor = new NioSocketAcceptor();  
          
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();  
          
        ProtocolCodecFilter filter= new ProtocolCodecFilter(new HCoderFactory(Charset.forName("UTF-8")));   
        chain.addLast("objectFilter",filter);  
        acceptor.setHandler(new MinaServerHanlder());  
          
        try {  
            // �󶨶˿�  
        	List<SocketAddress> sa = new ArrayList<SocketAddress>();
        	sa.add(new InetSocketAddress(InetAddress.getByName("192.168.1.18"), bindPort));
        	sa.add(new InetSocketAddress(InetAddress.getLocalHost(), bindPort2));
        	acceptor.bind(sa);
            // acceptor.bind(new InetSocketAddress(bindPort));  
        } catch (IOException e) {  
            System.out.println("Mina Server start for error!"+bindPort);  
            e.printStackTrace();  
        }  
          
        System.out.println("Mina Server run done! on port:"+bindPort);  
    }  

}
