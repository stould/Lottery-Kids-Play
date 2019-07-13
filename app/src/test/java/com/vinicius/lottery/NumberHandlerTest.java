package com.vinicius.lottery;

import com.vinicius.lottery.com.vinicius.lottery.model.Ticket;
import com.vinicius.lottery.com.vinicius.lottery.model.Tuple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NumberHandlerTest {

    final List<Integer> g1 = new ArrayList(Arrays.asList(15,2,3,4,5,6,7,8,9,10,11,12,13,14,1));
    final List<Integer> g2 = new ArrayList(Arrays.asList(2,11,18,19,20,21,22,23,24,25,26,27,28,29,30));
    final List<Integer> g3 = new ArrayList(Arrays.asList(8,11,31,32,33,34,35,36,14,38,39,40,41,42,43));

    final NumberHandler nh = new NumberHandler();

    @Test
    public void shouldHandleOneGame() {
        Ticket ticket = new Ticket();
        ticket.setNumbers(g1);

        Ticket[] tickets = new Ticket[1];
        tickets[0] = ticket;


        List<Integer> ans = nh.calculateDifferences(tickets);
        assertEquals(0, ans.size());
    }

    @Test
    public void shouldHandleTwoGames() {
        Ticket[] tickets = new Ticket[2];
        tickets[0] = new Ticket(g1);
        tickets[1] = new Ticket(g2);

        List<Integer> ans = nh.calculateDifferences(tickets);
        assertNotEquals(0, ans.size());
    }


    @Test
    public void shouldHandleTwoGames_correctValues() {
        Ticket[] tickets = new Ticket[2];
        tickets[0] = new Ticket(g1);
        tickets[1] = new Ticket(g2);

        List<Integer> expectedOutputValues = new ArrayList<>(Arrays.asList(2,11));
        List<Integer> expectedOutputFrequency = new ArrayList<>(Arrays.asList(2,2));

        List<Tuple> ansTuple = nh.calculateDifferences(tickets);
        List<Integer> ansValues = new ArrayList<>();
        List<Integer> ansFrequency = new ArrayList<>();

        for(Tuple<Integer, Integer> tuple : ansTuple) {
            ansValues.add(tuple.second);
            ansFrequency.add(tuple.first);
        }

        assertEquals(expectedOutputValues, ansValues);
        assertEquals(expectedOutputFrequency, ansFrequency);
    }

    @Test
    public void shouldHandleThreeGames_correctValues() {
        Ticket[] tickets = new Ticket[3];
        tickets[0] = new Ticket(g1);
        tickets[1] = new Ticket(g2);
        tickets[2] = new Ticket(g3);

        List<Integer> expectedOutputValues = new ArrayList<>(Arrays.asList(11, 2, 8, 14));
        List<Integer> expectedOutputFrequency = new ArrayList<>(Arrays.asList(3, 2, 2, 2));

        List<Tuple> ansTuple = nh.calculateDifferences(tickets);
        List<Integer> ansValues = new ArrayList<>();
        List<Integer> ansFrequency = new ArrayList<>();

        for(Tuple<Integer, Integer> tuple : ansTuple) {
            ansValues.add(tuple.second);
            ansFrequency.add(tuple.first);
        }

        assertEquals(expectedOutputValues, ansValues);
        assertEquals(expectedOutputFrequency, ansFrequency);
    }

    @Test
    public void shouldHandleTwoGames_correctValuesParticularCase() {
        final List<Integer> g1Ptc = new ArrayList(Arrays.asList(1,2,3,4,5));
        final List<Integer> g2Ptc = new ArrayList(Arrays.asList(5,10,4,11,1));

        Ticket[] tickets = new Ticket[2];
        tickets[0] = new Ticket(g1Ptc);
        tickets[1] = new Ticket(g2Ptc);

        List<Integer> expectedOutputValues = new ArrayList<>(Arrays.asList(1,4,5));
        List<Integer> expectedOutputFrequency = new ArrayList<>(Arrays.asList(2,2,2));

        List<Tuple> ansTuple = nh.calculateDifferences(tickets);
        List<Integer> ansValues = new ArrayList<>();
        List<Integer> ansFrequency = new ArrayList<>();

        for(Tuple<Integer, Integer> tuple : ansTuple) {
            ansValues.add(tuple.second);
            ansFrequency.add(tuple.first);
        }

        assertEquals(expectedOutputValues, ansValues);
        assertEquals(expectedOutputFrequency, ansFrequency);
    }

    @Test
    public void shouldHandleThreeGames_correctValuesParticularCase() {
        final List<Integer> g1Ptc = new ArrayList(Arrays.asList(1,2,3,4,5,6));
        final List<Integer> g2Ptc = new ArrayList(Arrays.asList(5,10,4,11,1,12));
        final List<Integer> g3Ptc = new ArrayList(Arrays.asList(20,19,18,17,16,5));

        Ticket[] tickets = new Ticket[3];
        tickets[0] = new Ticket(g1Ptc);
        tickets[1] = new Ticket(g2Ptc);
        tickets[2] = new Ticket(g3Ptc);

        List<Integer> expectedOutputValues = new ArrayList<>(Arrays.asList(5,1,4));
        List<Integer> expectedOutputFrequency = new ArrayList<>(Arrays.asList(3,2,2));

        List<Tuple> ansTuple = nh.calculateDifferences(tickets);
        List<Integer> ansValues = new ArrayList<>();
        List<Integer> ansFrequency = new ArrayList<>();

        for(Tuple<Integer, Integer> tuple : ansTuple) {
            ansValues.add(tuple.second);
            ansFrequency.add(tuple.first);
        }

        assertEquals(expectedOutputValues, ansValues);
        assertEquals(expectedOutputFrequency, ansFrequency);
    }
}