package com.mvger.otus.homework.patterns.listener.forhw;

import com.mvger.otus.homework.patterns.listener.Listener;
import com.mvger.otus.homework.patterns.model.Message;
import com.mvger.otus.homework.patterns.model.ObjectForMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    private final Map<Long, Message> messageHistory = new HashMap<>();

    @Override
    public void onUpdated(Message msg) {
        ObjectForMessage field13Copy = new ObjectForMessage(new ArrayList<>(msg.getField13().getData()));
        Message messageCopy = new Message.Builder(msg.getId())
                .field1(msg.getField1())
                .field2(msg.getField2())
                .field13(field13Copy)
                .build();
        messageHistory.put(msg.getId(), messageCopy);
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(messageHistory.get(id));
    }
}
