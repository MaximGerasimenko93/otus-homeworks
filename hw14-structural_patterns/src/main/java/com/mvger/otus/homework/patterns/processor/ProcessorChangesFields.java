package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.model.Message;

public class ProcessorChangesFields implements Processor {

    @Override
    public Message process(Message message) {
        Message.Builder builder = message.toBuilder();
        String field11 = builder.getField11();
        builder.field11(builder.getField12());
        builder.field12(field11);
        return builder.build();
    }
}
