package io.netty.example.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lancer.yao
 * @time: 2019/11/16 上午9:21
 */
public class OutBoundHandlerB extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("OutBoundHandlerB: " + msg);
        ctx.write(msg,promise);
    }

    @Override
    public void handlerAdded(final ChannelHandlerContext ctx) throws Exception {
        ctx.executor().schedule(new Runnable() {
            @Override
            public void run() {
                ctx.channel().writeAndFlush("Hello World");
            }
        },3, TimeUnit.SECONDS);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("OutBoundHandlerB.exceptionCaught()");
        ctx.fireExceptionCaught(cause);
    }
}
