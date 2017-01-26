package com.infinityworks.boozer;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.io.IOException;

/**
 * Created by IWC-NeilDunlop on 26/01/2017.
 */
public class Application {

    public static void main(String[] args) throws IOException {

        ActorSystem system = ActorSystem.create("sample1");
        ActorRef counter = system.actorOf(Counter.props(), "bartender");

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        counter.tell(new Message(), ActorRef.noSender());
                    }
                }
            }).start();
        }


        System.out.println("ENTER to terminate");
        System.in.read();
    }
}
