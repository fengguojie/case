package com.jellard.netty;

import java.net.SocketAddress;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter { // (1)

	@Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//        SocketAddress remoteAddress = ctx.channel().remoteAddress();
//        System.out.println("new client connect: "+remoteAddress);
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener(new ChannelFutureListener() {
//        	
//            public void operationComplete(ChannelFuture future) {
//                assert f == future;
//                //ctx.close();//also a asynchronous method 
//            }
//        }); // (4)
		UnixTime pojo = new UnixTime();
		pojo.setName("jellard");
        ChannelFuture f = ctx.writeAndFlush(pojo);
        f.addListener(ChannelFutureListener.CLOSE);

    }
	
	@Override
    public void channelInactive(ChannelHandlerContext ctx) {
		SocketAddress remoteAddress = ctx.channel().remoteAddress();
    	System.out.println("client active to close connect: "+remoteAddress);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
