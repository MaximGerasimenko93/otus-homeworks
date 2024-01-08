package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.exception.EvenSecondException;
import com.mvger.otus.homework.patterns.model.Message;

public interface Processor {

    Message process(Message message) throws EvenSecondException;
}
