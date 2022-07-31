package week6;
//week 6

import java.util.HashMap;

class RandomUniqueEqualizer {
    // declaring varibales
    String[] leftSide;
    String rightSide;
    HashMap<String, String> mapper = new HashMap<String, String>();
    // constructor
    RandomUniqueEqualizer(String[] leftSide, String rightSide) {

        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    boolean processor() {
        // initialyzing

        String checkval1 = String.join("", leftSide);
        String checkvalFinal = checkval1 + rightSide;
        // System.out.println(checkval);

        String uniqueCheck = uniqueFinder(checkvalFinal, checkval1.charAt(checkval1.length() - 1));

        int leftSum = leftItterSum();

        String rightSum = "";
        // traverse cordinate upto the length of rightside
        for (int i = 0; i < rightSide.length(); i++) {
            rightSum += mapper.get("" + rightSide.charAt(i));
        }


        // comparing left sum and right sum
        if (leftSum == Integer.parseInt(rightSum)) {
            return true;
        }

        return false;

    }

    int leftItterSum() {

        // declaring 
        int unitsItter = 0;
        // creating new units array
        String[] units = new String[leftSide.length];
        // declaring
        int leftTotal = 0;

        // traverse upto the length of leftside
        for (int i = 0; i < leftSide.length; i++) {

            units[unitsItter] = "";

            for (int j = 0; j < leftSide[i].length(); j++) {

                // System.out.println(mapper.get("H"));
                units[unitsItter] += mapper.get("" + leftSide[i].charAt(j));

            }
            leftTotal += Integer.parseInt(units[unitsItter]);
            unitsItter++;

        }

        

        return leftTotal;
    }
    // new function
    String uniqueFinder(String a, char leftend) {

        int len = 0;
        char[] passer = new char[a.length()];
        // traverse upto the length of 'a'
        for (int i = 0; i < a.length(); i++) {
            boolean push = false;
            // nested loop
            for (int j = 0; j < a.length(); j++) {
                if (i >= j) {
                    if (i == a.length() - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }
                // comparing the charater at i with character at j
                if (a.charAt(i) == a.charAt(j)) {
                    push = false;
                    break;
                } else if (a.charAt(i) != a.charAt(j)) {
                    push = true;
                }
            }
            if (push) {
                passer[len] = a.charAt(i);
                push = false;
                len++;
            }
        }
        // initialyzing
        String combined = "";
        int itter = 0;
        // creating new leftrightsum array
        String[] leftRightSum = new String[2];
        // traverse upto len
        for (int i = 0; i < len; i++) {
            combined += passer[i];
            mapper.put("" + passer[i], "" + i);
            

        }

        // System.out.println(combined);

        return combined;
        // return leftRightSum;

    }
    // calling main function
    public static void main(String[] args) {
        // given values
        String[] leftInput = { "THER", "MOL", "NIS" };
        // displaying output
        System.out.println(new RandomUniqueEqualizer(leftInput, "HRLI").processor());
    }

}