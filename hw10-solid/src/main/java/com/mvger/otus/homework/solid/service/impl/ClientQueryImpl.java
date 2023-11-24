package com.mvger.otus.homework.solid.service.impl;

import com.mvger.otus.homework.solid.service.ClientQuery;

import java.util.Scanner;

public class ClientQueryImpl implements ClientQuery {
    Scanner scanner = new Scanner(System.in);
    @Override
    public int readQuery() {
        System.out.println("Введите сумму");
        return scanner.nextInt();
    }
}
