/**
 * @see <a href="https://leetcode.com/problems/fraction-to-recurring-decimal/">Fraction to Recurring Decimal</a>
 */

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException(" denominator can not be zero");
        }
        long longN = numerator;
        long longD = denominator;
        return myFractionToDecimal(longN, longD);
    }
    public String myFractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) return "0";
        if (numerator < 0 && denominator > 0) {
            return new String("-" + myFractionToDecimal(-1 * numerator, denominator));
        }
        if (numerator > 0 && denominator < 0) {
            return new String("-" + myFractionToDecimal(numerator, -1 * denominator));
        }
        if (numerator < 0 && denominator < 0) {
            return myFractionToDecimal(-1 * numerator, -1 * denominator);
        }
        
        long iPart = numerator / denominator;
        long remainder = numerator % denominator;
        StringBuilder sb = new StringBuilder();
        sb.append(iPart);
        if (remainder == 0) return new String(sb);
        // 1 / 7
        sb.append(".");
        // if a remainder starts repeating once. the fraction will re-occur from now on.
        List<Long> fraction = new ArrayList<Long>(); // arraylist stores long
        Map<Long, Integer> hm = new HashMap<Long, Integer>(); // map stores long and integer.
        int repeatIndex = -1;
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                repeatIndex = hm.get(remainder);
                break;
            }
            else {
                hm.put(remainder, fraction.size()); // the digits for this remainder starts here.
                while (remainder * 10 < denominator) {
                    remainder *= 10;
                    fraction.add(0l);
                    if (!hm.containsKey(remainder)) {
                        hm.put(remainder, fraction.size());
                    }
                    else {
                        repeatIndex = hm.get(remainder);
                        break; // recurring starts here, jump out
                    }

                }
                if (repeatIndex != -1) break; // recurring detected, jump out.
                
                long digit = remainder * 10 / denominator;
                fraction.add(digit);
                remainder = remainder * 10 % denominator;
            }
        }
        
        if (repeatIndex == -1) { // no re-occurring tails.
            for (int i = 0; i < fraction.size(); ++i) {
                sb.append(fraction.get(i));
            }
        }
        else {
            for (int i = 0; i < repeatIndex; ++i) {
                sb.append(fraction.get(i));
            }
            sb.append("(");
            for (int i = repeatIndex; i < fraction.size(); ++i) {
                sb.append(fraction.get(i));
            }
            sb.append(")");
        }
        return new String(sb);
    }
}
