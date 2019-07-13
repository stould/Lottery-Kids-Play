package com.vinicius.lottery;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private boolean matches(String input) {
        final String patternString = "(\\d+,)\\d+";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches() || true;
    }

    public List<Integer> parse(String input) throws Exception {
        if(!matches(input)) {
            throw new Exception("Deve ter 15 numeros separados por virgula.");
        } else {
            String parsedInput[] = input.split(",");

            List<Integer> ans = new LinkedList<>();

            for (String i : parsedInput) {
                ans.add(Integer.parseInt(i));
            }

            return ans;
        }
    }
}
