package com.vinicius.lottery;

import com.vinicius.lottery.com.vinicius.lottery.model.Ticket;
import com.vinicius.lottery.com.vinicius.lottery.model.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberHandler {
    public List calculateDifferences(final Ticket[] tickets) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int game = 0; game < tickets.length; game++) {
            for (int num = 0; num < tickets[game].getNumbers().size(); num++) {
                if (!frequency.containsKey(tickets[game].getNumbers().get(num))) {
                    frequency.put(tickets[game].getNumbers().get(num), 0);
                }
                final int current = frequency.get(tickets[game].getNumbers().get(num));
                frequency.put(tickets[game].getNumbers().get(num), current + 1);
            }
        }

        List<Tuple<Integer, Integer>> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : frequency.entrySet()) {
            if(pair.getValue() > 1)
                answer.add(new Tuple<>(pair.getValue(), pair.getKey()));
        }

        Collections.sort(answer, new Comparator<Tuple<Integer, Integer>>() {
            @Override
            public int compare(Tuple<Integer, Integer> p1, Tuple<Integer, Integer> p2) {
                if(p1.first == p2.first) {
                    return p1.second - p2.second;
                }
                return p2.first - p1.first;
            }
        });

        while(answer.size() > 15) {
            answer.remove(answer.size() - 1);
        }

        return answer;
    }
}
