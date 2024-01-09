package com.mvger.otus.homework.patterns.listener;

import com.mvger.otus.homework.patterns.model.Message;

public interface Listener {

    void onUpdated(Message msg);
}
