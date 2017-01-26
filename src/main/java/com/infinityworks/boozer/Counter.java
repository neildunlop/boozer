package com.infinityworks.boozer;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

/**
 * A simple actor that keeps track of how many messages it has received.
 */
public class Counter extends AbstractLoggingActor {

    //private final Logger logger = LoggerFactory.getLogger(Counter.class);

    private int counter = 0;

    {
        receive(ReceiveBuilder
                .match(Message.class, this::onMessage)
                .build()
        );
    }

    private void onMessage(Message message) {
        counter++;
        log().info("Increased counter " + counter);
    }

    public static Props props() {
        return Props.create(Counter.class);
    }
}
