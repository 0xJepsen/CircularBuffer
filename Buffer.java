public class buffer implements Runnable {
    @Override
        public void run(){
            final int MaxBuffSize;
            double[] store;
            int BufferStart;
			int BufferEnd;
			int BufferSize;
        
            public buffer(){
                this.MaxBuffSize = new double[1000];
                BufferEnd = -1;
                BufferStart = 0;
                BufferSize = 0;
                store = new double[MaxBuffSize];
            }
            //holds a maximum of 1,000 units        
            // insert(), remove(), isFull(), isEmpty()
            public synchronized void insert(double value){
                // inserts a value to the circular buffer.
                //used by producer
                try {
                    while (BufferSize == MaxBuffSize) {
                    wait();
                }
                BufferEnd = (BufferEnd + 1) % MaxBuffSize;
                store[BufferEnd] = value;
                BufferSize++;
                notifyAll();
                } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
            }
        
            public synchronized double remove(){
                try {
                    while (BufferSize == 0) {
                        wait();
                    }
                    double num = store[BufferStart];
                    BufferStart = (BufferStart + 1) % MaxBuffSize;
                    BufferSize--;
                    notifyAll();
                    return num;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return 0.0;
                }
            }
            public synchronized boolean isFull(){
                if (store.length == MaxBuffSize){
                    return true;
                } else {
                    return false; 
                }
            }

    }

    //calls this.wait() this.notity() this.notifyAll()
    
    // producer and consumer share same instance
}


