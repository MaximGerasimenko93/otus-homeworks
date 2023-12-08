package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.exception.CheckSumException;
import com.mvger.otus.homework.solid.exception.IsDividableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CheckerImplTest {

    @InjectMocks
    CheckerImpl checker;

    private static final int querySum = 250;
    private static final int balance = 150;

    @Test
    void checkSumTest() {
        assertThrows(CheckSumException.class, () -> checker.checkSum(querySum, balance));
    }

    @Test
    void isDividableTest() {
        assertThrows(IsDividableException.class, () -> checker.isDividable(querySum));
    }
}
