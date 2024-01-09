package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.exception.EvenSecondException;
import com.mvger.otus.homework.patterns.model.Message;
import com.mvger.otus.homework.patterns.processor.provider.DateTimeProvider;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ProcessorThrowsException implements Processor {

    private final DateTimeProvider dateTimeProvider;

    @Override
    public Message process(Message message) throws EvenSecondException {
        LocalDateTime currentTime = dateTimeProvider.getDateAndTime();
        int second = currentTime.getSecond();

        if (second % 2 == 0) {
            throw new EvenSecondException("Четная секунда");
        }

        return message;
    }
}
