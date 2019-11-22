package io.netty.example.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @Author: lancer.yao
 * @time: 2019/11/21 下午4:57
 */
public class Scratch {
    public static void main(String[] args) {
        int page = 1024 * 8;
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        //Page 级别内存
        allocator.directBuffer(2 * page);
        //subPage 级别内存
        ByteBuf byteBuf = allocator.directBuffer(16);
        //释放内存
        byteBuf.release();
    }
}
