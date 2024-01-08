package com.mvger.otus.homework.patterns;

import com.mvger.otus.homework.patterns.handler.ComplexProcessor;
import com.mvger.otus.homework.patterns.listener.ListenerPrinterConsole;
import com.mvger.otus.homework.patterns.model.Message;
import com.mvger.otus.homework.patterns.processor.LoggerProcessor;
import com.mvger.otus.homework.patterns.processor.ProcessorConcatsFields;
import com.mvger.otus.homework.patterns.processor.ProcessorUppersField10;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        var processors = List.of(new ProcessorConcatsFields(),
                new LoggerProcessor(new ProcessorUppersField10()));

        var complexProcessor = new ComplexProcessor(processors, ex -> {});
        var listenerPrinter = new ListenerPrinterConsole();
        complexProcessor.addListener(listenerPrinter);

        var message = new Message.Builder(1L)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field6("field6")
                .field10("field10")
                .build();

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);
    }
}
