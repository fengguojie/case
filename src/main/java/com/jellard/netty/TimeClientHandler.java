package com.jellard.netty;

import java.net.SocketAddress;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
	
	/**
	 *  the problem is that it can be fragmented, 
	 *  and the possibility of fragmentation will increase as the traffic increases.
	 */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf m = (ByteBuf) msg; // (1)
//        try {
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        } finally {
//            m.release();
//        }
    	UnixTime m = (UnixTime) msg;
        System.out.println(m);
        ctx.close();
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
    	SocketAddress remoteAddress = ctx.channel().remoteAddress();
    	System.out.println("server active to close connect :"+remoteAddress);
    }
    

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
