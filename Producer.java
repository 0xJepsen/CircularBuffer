import java.util.Random;

public class Producer implements Runnable
{
   private final Buffer buffer;
   private final int MAX_CAPACITY = 1000;
   private int counter = 0;
   private Random random;
   private double cumulative = 0.0; 
   private int hundredThousand= 0;
 
   public Producer(Buffer buffer){
      this.buffer =  buffer;   
   }
 //initializing variables
   @Override
   public void run()
   {
      while (counter < 1000000) // produce a million elements
      {
         random = new Random();
         double bufferElement = (double)(random.nextDouble() * 100.0);
         try
         {
            cumulative += bufferElement; //tally the cumulative values
            produce(bufferElement); //helper defined below
            counter++;
            if (counter % 100000 == 0){ // print every 100,000
               hundredThousand++;
               System.out.printf("Producer: Generated %d00,000 items, Cumulative value of generated items=%.3f %n", hundredThousand, cumulative);
            }
         } 
         catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
      System.out.print("Producer: Finished generating 1,000,000 items\n");
   }
 
   private void produce(double i) throws InterruptedException
   {
      synchronized (buffer)
      {
         while (buffer.element_count == MAX_CAPACITY) //check to see if buffer is full
         {
            buffer.wait();
         }
         buffer.insert(i); //produce value
         buffer.notifyAll();
      }
   }
}