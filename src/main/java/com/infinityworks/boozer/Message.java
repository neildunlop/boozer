package com.infinityworks.boozer;

/**
 * A really simple message that we can pass between actors.
 */
public class Message {

    private String payload;

    public Message() {
    }

    private Message(Builder builder) {
        payload = builder.payload;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Message copy) {
        Builder builder = new Builder();
        builder.payload = copy.payload;
        return builder;
    }


    public static final class Builder {
        private String payload;

        private Builder() {
        }

        public Builder withPayload(String val) {
            payload = val;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
