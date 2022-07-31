package week2;
// week 2

class SubsetFinder {
    // declaring variables  
    int realArrLen;
    int[] a;
    // constructor
    SubsetFinder(int realArrLen, int[] a) {

        this.realArrLen = realArrLen;
        // this.a = a;
        int len = 0;
        int[] passer = new int[a.length];
        // traverse cordinate upto the length of array[] a
        for (int i = 0; i < a.length; i++) {
            boolean push = false;
            // nested loop
            for (int j = 0; j < a.length; j++) {
                if (i >= j) {
                    if (i == a.length - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }
                // comparing statements for push
                if (a[i] == a[j]) {
                    push = false;
                    break;
                } else if (a[i] != a[j]) {
                    push = true;
                }
            }
            if (push) {
                passer[len] = a[i];
                push = false;
                len++;
            }
        }

        int[] originalPasser = new int[len];
        // traverse cordinate upto the length of len
        for (int i = 0; i < len; i++) {
            originalPasser[i] = passer[i];
            // System.out.println(passer[i]);
        }

        this.a = originalPasser;

    }
    // function to find result
    void resultFinder() {

        // Compilation of whole required functions or steps
        // initialyzing
        int[][] outputValues = findPrime(a);
        int[] primeValues = outputValues[0];
        int primeItterator = outputValues[1][0];
        // System.out.println(primeItterator);
        // comparing
        if (primeItterator == realArrLen) {
            // traverse each co ordinate
            for (int i = 0; i < primeItterator; i++) {
                System.out.println(primeValues[i]);
            }
        } else {

            int[] extra = extrasSearch(primeValues, primeItterator);
            // System.out.println(extra[0]);
            // traverse each coordinate
            for (int i = 0; i < realArrLen; i++) {
                // coparing
                if (i >= primeItterator) {
                    int num = i - primeItterator;
                    System.out.println(extra[num]);
                } else {
                    System.out.println(primeValues[i]);
                }

            }
        }

    }

    int[] extrasSearch(int[] primes, int primeItterator) {
        // initialyzing
        int[] extras = new int[realArrLen];
        int extrasin = 0;
        boolean skip = false;
        // traverse cordinate upto the length of array[] a
        for (int i = 0; i < a.length; i++) {
            for (int ext = 0; ext < primes.length; ext++) {
                if (a[i] == primes[ext]) {
                    skip = true;
                    break;
                }
            }
            if (skip) {
                skip = false;
                continue;
            }

            boolean push = true;
            // traverse each cordinate 
            for (int j = 0; j < primeItterator; j++) {
                // comparing
                if (primes[j] == 1) {
                    continue;
                } else {
                    // System.out.println(a[i]);
                    float checkval = (float) a[i] / (float) primes[j];
                    if (checkval == Math.floorDiv(a[i], primes[j])) {
                        push = false;
                    }
                }
            }

            if (push) {
                extras[extrasin] = a[i];
                extrasin++;
            }

        }

        return extras;

    }
    // function to find prime numbers
    int[][] findPrime(int[] arr) {
        // Findout Prime numbers among element of given array arr
        int[] ourPrimeElements = new int[realArrLen];
        int primeItterator = 0;
        // traverse cordinate upto the length of array[] arr
        for (int i = 0; i < arr.length; i++) {
            // comparing using statements
            if (arr[i] == 0) {
                continue;
            } else if (arr[i] == 1) {
                ourPrimeElements[primeItterator] = 1;
                primeItterator++;

            } else if (arr[i] == 2) {
                ourPrimeElements[primeItterator] = 2;
                primeItterator++;
            } else if (arr[i] == 3) {
                ourPrimeElements[primeItterator] = 3;
                primeItterator++;
            }

            else {

                boolean prime = true;
                // int element = Math.floorDiv(arr[i], 2);
                int divideLimit = Math.floorDiv(arr[i], 2);
                // traverse each cordinate 
                for (int j = 2; j <= divideLimit; j++) {

                    float check = (float) a[i] / j;
                    

                    if (check == Math.floorDiv(a[i], j)) {

                        prime = false;

                    }
                }
                // comparing statements
                if (prime == true) {

                    ourPrimeElements[primeItterator] = a[i];
                    primeItterator++;
                }

            }

        }

        int[][] returner = { ourPrimeElements, { primeItterator } };

        return returner;

    }

    // Main function
    public static void main(String[] args) {
        // providing data
        int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 };

        // calling instance
        SubsetFinder sub = new SubsetFinder(3, input);
        sub.resultFinder();
    }

}

