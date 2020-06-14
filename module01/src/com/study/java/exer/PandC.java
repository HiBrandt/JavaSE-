package com.study.java.exer;


/**
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
   取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
   生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
   知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
   果店中有产品了再通知消费者来取走产品

       感悟：生产者和消费者其实不是自己生产和消费产品，都只是在调用产品类的生产和消费方法而已
 */
public class PandC {

    public static void main(String[] args) {
        Product product=new Product();

        Producer producer=new Producer(product);
        producer.setName("生产者1");

        Consumer consumer=new Consumer(product);
        consumer.setName("消费者1");

        producer.start();
        consumer.start();


    }

}


/**
 * 产品
 */
class Product{

    private int productNum;


    /**
     * 生产产品的方法
     * synhornized 是为了保证线程的同步安全。
     */
    public synchronized void createproduct() {

         if(productNum<20){
             productNum++;

             notify();//当有了产品就开始唤醒消费者可以消费了

             System.out.println("生产者开始生产第"+productNum+"个产品");
         }else {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

    }

    /**
     * 消费产品的方法
     */
    public synchronized void consumeproduct() {

        if(productNum>0){
            System.out.println("消费者开始消费第"+productNum+"个产品");

            notify();  //当消费了产品就开始唤醒生产者可以生产了

            productNum--;
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 生产者线程
 */
class  Producer extends Thread{

    //生产的是产品 所以要有产品属性也能调用产品的方法
       private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {

        System.out.println("生产者开始生产");
        while (true){

            //可以不写的哦
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            product.createproduct();
        }
    }
}


/**
 * 消费者线程
 */
class Consumer extends Thread{

   //消费的是产品 所以要有产品属性也能调用产品的方法
   private Product product;

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while (true){

            //可以不写的哦
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            product.consumeproduct();
        }
    }

    public Consumer(Product product) {
        this.product = product;
    }
}
