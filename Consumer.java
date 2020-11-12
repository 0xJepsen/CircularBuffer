public class Consumer implements Runnable
{
    private final Buffer buffer;
    private int counter = 0;
    private double cumulative; 
    private int hundredThousand= 0;
   
   public Consumer(Buffer buffer1){
      this.buffer = buffer1;
   }
 //initiallize variables
   @Override
   public void run()
   {
      while (counter < 1000000) //consume a million elements
      {
         try
         {
            double i = consume(); // uses simple helper defined below
            counter++;
            cumulative+= i; //tally cumulative values
            if (counter % 100000 == 0){
                hundredThousand++;
               System.out.printf("Consumer: Consumed %d00,000 items, Cumulative value of generated items=%.3f %n",hundredThousand, cumulative);
            }
         } catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
      if (counter == 1000000){
        System.out.print("Consumer: Finished consuming 1,000,000 items\n");

      }
   }
 
   private double consume() throws InterruptedException
   {
      synchronized (buffer)
      {
         while (buffer.element_count == 0) //make sure buffer isn't empty
         {
            buffer.wait();
         }
         double i = buffer.remove(); //consume the elements
         buffer.notifyAll();
         return i;
      }
   }
}