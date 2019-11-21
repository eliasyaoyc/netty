package io.netty.example.echo.designmode;

import io.netty.buffer.PooledByteBufAllocator;

/**
 * @Author: lancer.yao
 * @time: 2019/11/21 下午4:57
 */
public class Scratch {
    public static void main(String[] args) {
        int page = 1024 * 8;
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        allocator.directBuffer(2 * page);
    }
}
