README
======

This package includes the following files.

|-- Buffer.java [This file contains the class where a buffer object is defined along with it's corelating methods: insert() remove() isFull() and is Empty()]
|-- Producer.java [This file contains the class written to produce elements and insert them onto a buffer object]
|-- Consumer.java [This file contains the class written to consumer elements and remove them from a buffer object]
|-- ProducerConsumer.java [This file contains our main method and acts as the driver to ensure synchronisity of both consumer and producer threads]
|-- Makefile [A make file that performs make clean and make all]
|-- README.txt [This file]

To compile:
    make all
To clean:
    make clean
To run:
    make run