import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class FizzBuzz {
   public int n = 15;
    private static BlockingQueue<String> outputQueue = new LinkedBlockingQueue<>();


    Thread A = new Thread(()->{

       for(int i =1; i<=n; i++){
            if(fizz(i)){
                try {
                        outputQueue.put("fizz");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {

            }
       }
   });

   Thread B = new Thread(()->{
        for(int i =1; i<=n; i++){
            if(buzz(i)){
                try {
                        outputQueue.put("buzz");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
   });
   Thread C = new Thread(()->{
       for(int i =1; i<=n; i++){
           if(fizzbuzz(i)){
               try {
                   outputQueue.put("fizzbuzz");
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }

   });

   Thread D = new Thread(()->{
    for(int i =1; i<n; i++){
        String result = null;
        try {
            result = outputQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }

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
