package io.netty.example.echo.designmode;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;

/**
 * @Author: lancer.yao
 * @time: 2019/11/17 下午5:46
 * 迭代器   迭代器接口   对容器里面各个对象进行访问
 */
public class Iterable {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(new byte[]{1, 2, 3});
        byteBuf.forEachByte(new ByteProcessor() {
            @Override
            public boolean process(byte value) throws Exception {
                System.out.println(value);
                return true;
            }
        });
    }
    public ByteBuf merge(ByteBuf header,ByteBuf body){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        byteBuf.writeBytes(header);
        byteBuf.writeBytes(body);
        return byteBuf;
    }

    public ByteBuf mergeComposite(ByteBuf header,ByteBuf body){
        //netty 零拷贝
        CompositeByteBuf byteBuf = ByteBufAllocator.DEFAULT.compositeBuffer();
        byteBuf.addComponents(true, header, body);
        return byteBuf;
    }
}
