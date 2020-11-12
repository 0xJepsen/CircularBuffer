FILES = Buffer.java Consumer.java Producer.java ProducerConsumer.java
all:
	javac $(FILES)
run:
	java ProducerConsumer
clean:
	rm *.class