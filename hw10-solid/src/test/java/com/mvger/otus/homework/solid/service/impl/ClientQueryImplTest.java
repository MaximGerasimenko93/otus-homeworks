package com.mvger.otus.homework.solid.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientQueryImplTest {

    @InjectMocks
    ClientQueryImpl clientQuery;
    @Mock
    Scanner scanner;

    @Test
    void readQueryNotNullTest() {
        int query = clientQuery.readQuery();
        assertNotNull(query);
    }

    @Test
    void readQueryTest() {
        when(scanner.nextInt()).thenReturn(500);
        int query = clientQuery.readQuery();
        verify(scanner).nextInt();
        assertEquals(500, query);
    }
}
