package io.netty.example.echo.designmode;

/**
 * @Author: lancer.yao
 * @time: 2019/11/17 下午5:55
 * 装饰模式
 * 装饰者和被装饰者继承同一个接口  装饰者给被装饰者动态修改行为
 * @see io.netty.buffer.SimpleLeakAwareByteBuf
 */
public class Decorate {
    //优惠方案
    public interface OnSalePlan{
        float getPrice(float oldPrice);
    }

    //无优惠
    public static class NonePlan implements OnSalePlan{
        static final NonePlan INSTANCE = new NonePlan();
        private NonePlan() {
        }

        @Override
        public float getPrice(float oldPrice) {
            return oldPrice;
        }
    }

    //立减优惠
    public static class KnockPlan implements OnSalePlan{
        //立减金额
        private float amount;

        private KnockPlan(float amount) {
            this.amount = amount;
        }

        @Override
        public float getPrice(float oldPrice) {
            return oldPrice - amount;
        }
    }

    //打折优惠
    public static class DiscountPain implements OnSalePlan{
        //折扣
        public int discount;
        private OnSalePlan previousPlan;

        public DiscountPain(int discount, OnSalePlan previousPlan) {
            this.discount = discount;
            this.previousPlan = previousPlan;
        }

        private DiscountPain(int discount) {
            this(discount,NonePlan.INSTANCE);
        }

        @Override
        public float getPrice(float oldPrice) {
            return previousPlan.getPrice(oldPrice) * discount / 10;
        }
    }

    public static void main(String[] args) {
        DiscountPain simpleDiscountPlan = new DiscountPain(5);
        System.out.println(simpleDiscountPlan.getPrice(100));

        KnockPlan knockPlan = new KnockPlan(50);
        DiscountPain discountPain = new DiscountPain(5,knockPlan);
        System.out.println(discountPain.getPrice(100));
    }
}
