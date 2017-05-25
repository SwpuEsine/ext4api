package zft.control.manager.net.tcp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.net.tcp.server.coders.HeaderDecoder;
import zft.control.manager.net.tcp.server.coders.HeaderEncoder;
import zft.control.manager.net.tcp.server.handler.ServerHandler;

@Service("tcpServer")
public class TcpServer implements Runnable {
    private String IP = "127.0.0.1";
    private int PORT = 60001;
    protected static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2;
    protected static final int BIZTHREADSIZE = 4;
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);
    private ServerBootstrap bootstrap;
    @Autowired
    private ServerHandler serverHandler;

    @Override
    public void run() {
        try {
            bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_REUSEADDR, true);
            bootstrap.option(ChannelOption.SO_BACKLOG, 10000);
            bootstrap.option(ChannelOption.SO_RCVBUF, 1024);
            bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);

            ChannelInitializer channelInitializer = new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    //pipeline.addLast(new IdleStateHandler(10, 0, 0));
                    pipeline.addLast("decoder", new HeaderDecoder());
                    pipeline.addLast("encoder", new HeaderEncoder());
                    pipeline.addLast(serverHandler);
                }
            };
            bootstrap.childHandler(channelInitializer);
            bootstrap.bind(IP, PORT).sync().channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        } catch (Exception e) {
        }
    }
}