package cz.moneta.interview.services;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Exercise2Impl implements Exercise2 {
    static final Integer SWAP_UNDER = 3;

    @Override
    public String compute(Long input) {
        final String swapped = this.swapNumbersToRight(input.toString());
        final String multiply = this.multiplyNumbers(swapped);
        final String noSevens = deleteAllSevens(multiply);
        final Integer evens = countEvenNumbers(noSevens);
        //a tímto poctem výsledné císlo vydelí a zaokrouhlí dolù na celá císla. Napr: 45326181 / 4 => 11331545
        return String.valueOf(Math.floorDiv(Long.parseLong(noSevens), evens));
    }

    /**
     * všechny císlice 8 a 9 vynásobí 2. Napr.: 45326791 => 453267181
     *
     * @param swapped
     * @return
     */
    protected String multiplyNumbers(String swapped) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < swapped.length(); i++) {
            if (swapped.charAt(i) == '8' || swapped.charAt(i) == '9') {
                builder.append(((swapped.charAt(i) - '0') * 2));
            } else {
                builder.append((swapped.charAt(i)));
            }
        }
        return builder.toString();
    }

    /**
     * všechny císlice menší 3 (vcetne) posune o jednu pozici doprava. Napr: 43256791 => 43526791  
     *
     * @param from
     * @return
     */
    protected String swapNumbersToRight(final String from) {
        final StringBuilder ret = new StringBuilder();
        List<Pair<Character, Integer>> indexes = new ArrayList<>();
        final int length = from.toCharArray().length;
        for (int i = 0; i < length; i++) {
            Character ch = from.charAt(i);
            if (Integer.parseInt(ch.toString()) <= Exercise2Impl.SWAP_UNDER) {
                int index = length - i - 1;
                indexes.add(Pair.of(ch, index));
            } else {
                ret.append(ch.toString());
            }

        }

        indexes.forEach(pair -> {
            ret.insert(Math.min(length - pair.getSecond(), ret.length()), pair.getFirst().toString());
        });

        return ret.toString();
    }

    /**
     * všechny císlice 7 smaže: Napr: 453267181 => 45326181
     *
     * @param input
     * @return
     */
    protected String deleteAllSevens(String input) {
        return input.replace("7", "");
    }

    /**
     * ve výsledném císle spocte poet sudých císlic
     *
     * @param input
     * @return
     */
    protected Integer countEvenNumbers(String input) {
        return input.split("[2468]").length - 1;
    }


}
