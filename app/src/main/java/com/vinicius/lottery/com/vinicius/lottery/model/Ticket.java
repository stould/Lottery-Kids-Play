package com.vinicius.lottery.com.vinicius.lottery.model;

import java.util.List;

public class Ticket {
    private int id;
    private List<Integer> numbers;

    public Ticket() {
    }

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
