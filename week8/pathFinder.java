package week8;
//week 8


class PathFinder {
    //declaring variables
    String[] input;
    int rows;
    int columns;

    //constructor
    PathFinder(String[] input) {
        this.input = input;
        this.rows = input.length;
        this.columns = input[0].length();
    }

    int processor() {
        // initializing
        int keys = keysNumberFinder();
        int totalTravelled = 0;
        int keysFound = 0;
        boolean run = true;
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        char[] foundK = new char[2];
        // while loop to check and compare travelled rows and key found
        while (run) {
            // comparing statements either it is equal to "#"
            if (input[travelledRow].charAt(x + adder) != '#') {

                if (input[travelledRow].charAt(x + adder) == '*') {
                    x += adder;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow].charAt(x + adder);
                        x += adder;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;
                        // traverse cordinate upto the length of array[] a=foundk
                        for (int l = 0; l < foundK.length; l++) {
                            //comparing array found[k] with travelled row
                            if (foundK[l] == input[travelledRow].toLowerCase().charAt(x + adder)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            //increases total travelled
                            totalTravelled++;
                            x += adder;
                            continue;
                        } else {
                            adder *= -1;
                            continue;
                        }

                    }
                }

            }
            // comparing it to '#'
            if (input[travelledRow + 1].charAt(x) != '#') {
                // comparing if it is equal to '*'
                if (input[travelledRow + 1].charAt(x) == '*') {

                    travelledRow += 1;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow + 1].charAt(x);
                        travelledRow += 1;
                        keysFound++;
                        // comparing statements
                        if (keysFound == keys) {
                            run = false;
                            break;
                        } 
                        // if the above statement fails
                        else {
                            continue;
                        }

                    } else {

                        boolean yes = false;
                        // traverse upto the length of foundk
                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow + 1].toLowerCase().charAt(x)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            
                            // increases the totalTravelled 
                            totalTravelled++;
                            // increases the travelledROw
                            travelledRow++;
                            continue;
                        }

                    }
                }

            }
        }

        return totalTravelled;
    }

    int keysNumberFinder() {

        int alphabets = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#'
                        || input[i].charAt(j) == '*') {
                    continue;
                } else {
                    // increases alphabets
                    alphabets++;
                }
            }
        }

        int keys = alphabets / 2;

        return keys;
    }

    // calling the main function
    public static void main(String[] args) {
        // given values
        String[] value = { "@*a*#", "###*#", "b*A*B" };
        // calling instance
        PathFinder pth = new PathFinder(value);
        // printing output
        System.out.println(pth.processor());
    }

}

