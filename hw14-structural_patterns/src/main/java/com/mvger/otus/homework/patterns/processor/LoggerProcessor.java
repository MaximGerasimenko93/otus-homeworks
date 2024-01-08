package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.exception.EvenSecondException;
import com.mvger.otus.homework.patterns.model.Message;

public class LoggerProcessor implements Processor {

    private final Processor processor;

    public LoggerProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public Message process(Message message) throws EvenSecondException {
        System.out.println("log processing message:" + message);
        return processor.process(message);
    }
}
