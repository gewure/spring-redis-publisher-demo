# spring-redis-publisher-demo
A minimal Spring Boot demo of a Redis PubSub publisher implementation


## See https://github.com/gewure/spring-redis-subscriber-demo for the subscriber 

# Run

start REDIS on localhost:

`redis.cli`

get into SYNC Mode to monitor if everything works:

`SYNC`

start both applications, go to PublisherService API, `localhost:8080/msg` and submit a message like:

`http://localhost:8080/msg?msg=test&sender=test`

if everything works you should see this in the Subscriber:

`Message received: SomeMessageClass(id=33f82f42-5d94-4a35-afcf-be2d2bd507ec, sender=test, message=test, timestamp=1607357572787)`

and something like this in Redis:
<pre>
127.0.0.1:6379> SYNC
Entering replica output mode...  (press Ctrl-C to quit)
SYNC with master, discarding 178 bytes of bulk transfer...
SYNC done. Logging commands from master.
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"PING"
"SELECT","0"
"PUBLISH","testtopic","SomeMessageClass(id=33f82f42-5d94-4a35-afcf-be2d2bd507ec, sender=test, message=test, timestamp=1607357572787)"
</pre>
