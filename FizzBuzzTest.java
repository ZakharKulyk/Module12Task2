public class FizzBuzzTest {
    public static void main(String[] args) {
        System.out.println("Main started");
        FizzBuzz fizzBuzz = new FizzBuzz();

        fizzBuzz.A.start();
        fizzBuzz.B.start();
        fizzBuzz.C.start();
        fizzBuzz.D.start();

        try {
            fizzBuzz.A.join();
            fizzBuzz.B.join();
            fizzBuzz.C.join();
            fizzBuzz.D.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(fizzBuzz.outputQueue);

        System.out.println("Main ended");
    }
}
