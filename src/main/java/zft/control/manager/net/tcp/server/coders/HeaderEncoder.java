package zft.control.manager.net.tcp.server.coders;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class HeaderEncoder extends MessageToByteEncoder<byte[]> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, byte[] body, ByteBuf out) throws Exception {
        int dataLength = body.length;
        out.writeBytes(String.format("%04d", dataLength).getBytes());
        out.writeBytes(body);
    }
}
