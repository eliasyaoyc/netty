package io.netty.example.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: lancer.yao
 * @time: 2019/11/15 下午5:05
 */
public class InBoundHandlerB extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandlerB ：" + msg);
        ctx.fireChannelRead(msg);
        //测试异常捕捉
//        throw new Exception("Test CaughtException");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().pipeline().fireChannelRead("Hello World");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("InBoundHandlerB.exceptionCaught()");
        ctx.fireExceptionCaught(cause);
    }
}
