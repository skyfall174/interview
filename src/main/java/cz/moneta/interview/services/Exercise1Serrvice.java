package cz.moneta.interview.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Exercise1Serrvice implements Exercise1 {

    @Override
    public String reverseString(String input) {
        List<Integer> indexToUpperCase = indexesToUpper(input);
        String reversed = new StringBuilder(input).reverse().toString().toLowerCase();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            if (indexToUpperCase.contains(i)) {
                ret.append(String.valueOf(reversed.charAt(i)).toUpperCase());
            } else {
                ret.append(String.valueOf(reversed.charAt(i)).toLowerCase());
            }
        }
        return StringUtils.normalizeSpace(ret.toString());
    }

    private List<Integer> indexesToUpper(String orig) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < orig.length(); i++) {
            if ("aeiouáéíóú".contains(String.valueOf(orig.charAt(i)))) {
                ret.add(i);
            }
        }
        return ret;
    }

}
