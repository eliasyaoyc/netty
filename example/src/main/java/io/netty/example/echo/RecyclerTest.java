package io.netty.example.echo;

import io.netty.util.Recycler;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: lancer.yao
 * @time: 2019/11/25 下午3:47
 */
public class RecyclerTest {

    private static Recycler<HandledObject> newRecycler(int max) {
        return new Recycler<HandledObject>(max) {
            @Override
            protected HandledObject newObject(
                    Recycler.Handle<HandledObject> handle) {
                return new HandledObject(handle);
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        Recycler<HandledObject> recycler = newRecycler(1024);
        final HandledObject object = recycler.get();
        final AtomicReference<IllegalStateException> exceptionStore = new AtomicReference<IllegalStateException>();
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.recycle();
            }
        });
        thread1.start();
        thread1.join();
        recycler.get();

//        final Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    object.recycle();
//                } catch (IllegalStateException e) {
//                    exceptionStore.set(e);
//                }
//            }
//        });
//        thread2.start();
//        thread2.join();
        IllegalStateException exception = exceptionStore.get();
        if (exception != null) {
            throw exception;
        }
    }

    static final class HandledObject {
        Recycler.Handle<HandledObject> handle;

        HandledObject(Recycler.Handle<HandledObject> handle) {
            this.handle = handle;
        }

        void recycle() {
            handle.recycle(this);
        }
    }
}
