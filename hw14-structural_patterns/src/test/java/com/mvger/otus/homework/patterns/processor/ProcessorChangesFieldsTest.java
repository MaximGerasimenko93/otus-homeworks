package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.model.Message;
import com.mvger.otus.homework.patterns.model.ObjectForMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



class ProcessorChangesFieldsTest {

    ProcessorChangesFields processor = new ProcessorChangesFields();
    Message message = new Message.Builder(1,
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
            new ObjectForMessage(new ArrayList<>()))
            .build();

    @Test
    void testProcessToChangeFields() {
        Message processedMessage = processor.process(message);
        assertEquals(message.getField11(), processedMessage.getField12());
        assertEquals(message.getField12(), processedMessage.getField11());
    }
}