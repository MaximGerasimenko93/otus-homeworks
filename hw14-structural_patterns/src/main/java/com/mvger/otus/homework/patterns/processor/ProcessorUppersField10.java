package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.model.Message;

public class ProcessorUppersField10 implements Processor {

    @Override
    public Message process(Message message) {
        return message.toBuilder().field4(message.getField10().toUpperCase()).build();
    }
}
