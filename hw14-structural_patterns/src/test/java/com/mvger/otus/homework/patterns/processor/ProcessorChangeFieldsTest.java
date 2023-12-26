package com.mvger.otus.homework.patterns.processor;

import com.mvger.otus.homework.patterns.model.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProcessorChangeFieldsTest {

    @Mock
    Message message;

    @Mock
    Message.Builder builder;

    @InjectMocks
    ProcessorChangeFields processor;

    @Test
    void processToChangeFields() {
        when(message.toBuilder()).thenReturn(builder);
        when(builder.getField11()).thenReturn("field11");
        when(builder.getField12()).thenReturn("field12");

        processor.process(message);

        verify(builder).getField11();
        verify(builder).getField12();
        verify(builder).field11("field12");
        verify(builder).field12("field11");
        verify(builder).build();
    }
}