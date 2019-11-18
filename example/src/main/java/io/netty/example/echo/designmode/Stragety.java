package io.netty.example.echo.designmode;

/**
 * @Author: lancer.yao
 * @time: 2019/11/17 下午5:39
 * 策略模式 封装一系列可相互替换的算法家族   动态选择某一策略
 * @see io.netty.util.concurrent.DefaultEventExecutorChooserFactory
 */
public class Stragety {
    private Cache cacheMemory = new CacheMemoryImpl();
    private Cache cacheRedis = new CacheRedisImpl();

    private interface Cache {
        Boolean add(String key, Object object);
    }

    public class CacheMemoryImpl implements Cache {

        @Override
        public Boolean add(String key, Object object) {
            return null;
        }
    }

    public class CacheRedisImpl implements Cache {

        @Override
        public Boolean add(String key, Object object) {
            return null;
        }
    }
    public Cache getCache(String key){
        if(key == "redis"){
            return cacheRedis;
        }
        return cacheRedis;
    }
}
