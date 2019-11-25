package io.netty.example.echo;

import io.netty.util.concurrent.FastThreadLocal;

/**
 * @Author: lancer.yao
 * @time: 2019/11/24 下午1:28
 */
public class FastThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal2 = new ThreadLocal();
        FastThreadLocal threadLocal = new FastThreadLocal();
        threadLocal.set("lancer.yao");
        FastThreadLocal threadLocal1 = new FastThreadLocal();
        threadLocal1.set("lancer.yao1");
        Object o = threadLocal.get();
        Object o1 = threadLocal1.get();
        System.out.println(o);
        System.out.println(o1);
    }
}
