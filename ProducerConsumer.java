class producerConsumer {

    public static void main(String[] args) {
        System.out.println("program starting");
        buffer buffer = new buffer(1000); // buffer has size 5
        producer prod = new producer(buffer);
        consumer cons = new consumer(buffer);
        producer.start();
        consumer.start();
        try {
        prod.join();
        cons.interrupt();
        } catch (InterruptedException e) {}
        System.out.println("End of Program");
        2

        buffer bufferThread = new buffer();
        buffer bufferObj = new makeBuffer(1000);
        producer producerThread = new producer(bufferObj);
        consumer  = new consumer(bufferObj);

        Thread producerThread = new Thread(new Producer(b));
        Thread consumerThread = new Thread(new Consumer(b));
    }

}

    // creates producer, consumer, buffer
    //
    //starts producer and consumer threads
    


//java has built in monittors for mutial exclusion

//wait() for something to become true, waitts until another thread
//invokes notify() or notifyAll()

// example this.wait() this.notify this.notifyAll()

//notify() wakes up one thread from the block

//notifyAll()wakes up all threads