import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class FizzBuzz {
   public int n = 15;
    public  BlockingQueue<String> outputQueue = new LinkedBlockingQueue<>();


    Thread A = new Thread(()->{
        System.out.println("A started ");

       for(int i =1; i<=n; i++){
            if(fizz(i)){
                try {
                        outputQueue.put("fizz");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
        System.out.println("A ended");
   });

   Thread B = new Thread(()->{
       System.out.println("B started");
        for(int i =1; i<=n; i++){
            if(buzz(i)){
                try {
                        outputQueue.put("buzz");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
       System.out.println("B ended");
   });
   Thread C = new Thread(()->{
       System.out.println("C started");
       for(int i =1; i<=n; i++){
           if(fizzbuzz(i)){
               try {
                   outputQueue.put("fizzbuzz");
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
       System.out.println("C ended");

   });

   Thread D = new Thread(()->{
       System.out.println("D started");
    for(int i =1; i<=n; i++){
       if(!(fizz(i))&&!(buzz(i))&&!(fizzbuzz(i))){
           try {
               outputQueue.put(Integer.toString(i));
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
       System.out.println("D ended");

   });

   public boolean fizz(int number){
       if(number%3==0&&number%5!=0){
           return true;
       }else
           return false;
   }

   public boolean buzz(int number){
       if(number%5==0&&number%3!=0){
           return true;
       }else
           return false;
   }

   public  boolean fizzbuzz(int number){
       if(number%5==0&&number%3==0){
           return true;
       }else
           return false;
   }




}
