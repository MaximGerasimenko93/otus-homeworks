package com.mvger.otus.homework.patterns.listener.forhw;

import com.mvger.otus.homework.patterns.model.Message;

import java.util.Optional;

public interface HistoryReader {

    Optional<Message> findMessageById(long id);
}
