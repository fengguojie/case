package com.jellard.netty;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class TimeDecoder extends ByteToMessageDecoder { // (1)
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        if (in.readableBytes() < 4) {
            return; // (3)
        }
        System.out.println(in.readableBytes());
        UnixTime pojo = new UnixTime(in.readUnsignedInt());
        System.out.println(in.readableBytes());
        byte[] name = new byte[in.readableBytes()];
        in.readBytes(name);
        pojo.setName(new String(name));
        out.add(pojo);
        //out.add(in.readBytes(4)); // (4)
    }
}
