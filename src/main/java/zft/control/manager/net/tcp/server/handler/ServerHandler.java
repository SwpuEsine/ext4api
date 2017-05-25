package zft.control.manager.net.tcp.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("serverHandler")
@Scope("prototype")
@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] req = (byte[]) msg;
        ctx.executor().execute(new TransRun(ctx, new String(req)));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    class TransRun implements Runnable {
        private String data;
        private ChannelHandlerContext ctx;

        public TransRun(ChannelHandlerContext ctx, String data) {
            this.data = data;
            this.ctx = ctx;
        }

        @Override
        public void run() {
            System.out.println(data);
            ctx.write("00101111111111".getBytes());
            ctx.flush();
        }
    }


    /*
    private int UNCONNECT_NUM_S = 0;
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            if (UNCONNECT_NUM_S != 0) {
                ctx.close();
                return;
            }
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    UNCONNECT_NUM_S++;
                    break;
                default:
                    break;
            }
        }
    }
*/
}
