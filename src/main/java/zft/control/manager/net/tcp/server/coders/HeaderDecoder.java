package zft.control.manager.net.tcp.server.coders;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class HeaderDecoder extends ByteToMessageDecoder {
    private int HEAD_LENGTH = 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < HEAD_LENGTH) {
            return;
        }
        byteBuf.markReaderIndex();
        byte[] b = new byte[HEAD_LENGTH];
        byteBuf.readBytes(b);
        int dataLength;
        try {
            dataLength = Integer.parseInt(new String(b));
        } catch (Exception e) {
            ctx.close();
            return;
        }

        if (byteBuf.readableBytes() < dataLength) {
            byteBuf.resetReaderIndex();
            return;
        }

        byte[] body = new byte[dataLength];
        byteBuf.readBytes(body);
        list.add(body);
    }
}
