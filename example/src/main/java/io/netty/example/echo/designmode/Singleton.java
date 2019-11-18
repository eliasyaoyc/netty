package io.netty.example.echo.designmode;

/**
 * @Author: lancer.yao
 * @time: 2019/11/17 下午4:44
 * 单例模式在netty的应用
 * @see io.netty.handler.timeout.ReadTimeoutException
 * @see io.netty.handler.codec.mqtt.MqttEncoder
 */
public class Singleton {
    private static Singleton singleton;

    public Singleton() {
    }

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
