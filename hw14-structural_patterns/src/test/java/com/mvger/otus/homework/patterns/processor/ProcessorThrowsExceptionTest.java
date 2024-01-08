package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.exception.EvenSecondException;
import com.mvger.otus.homework.patterns.model.Message;
import com.mvger.otus.homework.patterns.model.ObjectForMessage;
import com.mvger.otus.homework.patterns.processor.provider.DateTimeProvider;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorThrowsExceptionTest {

    @Test
    void testProcessToThrowException() {
        DateTimeProvider dateTimeProvider = () -> LocalDateTime.of(2023, 1, 1, 0, 0, 2);
        ProcessorThrowsException processor = new ProcessorThrowsException(dateTimeProvider);
        assertThrows(EvenSecondException.class, () -> processor.process(new Message(1,
                "field1",
                "field2",
                "field3",
                "field4",
                "field5",
                "field6",
                "field7",
                "field8",
                "field9",
                "field10",
                "field11",
                "field12",
                new ObjectForMessage(new ArrayList<>()))));
    }
}