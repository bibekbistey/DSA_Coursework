package week4;

public class kth {
    public class wheatContainer {

        // sorting array
        static void forEachVillage(int array[]) {
            for (int i = 1; i < array.length; i++) {
                int j = i;
                int a = array[i];
                // executes loop until j is greater than 0
                // array[j-1] is grater than a
                while ((j > 0) && (array[j - 1] > a)) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = a;
             }
         }

        //function to calculate the number of container required
        static void forCurrentVillage(int array[]){

        //declaring variables
            int a;
            int total_container = 0;
            int previous_value = 0;
            int forthisvillage = 0;
            // traverse upto the lenth of array
            for (a = 0; a < array.length; a++) {
              if (array[a] != previous_value) {
                    previous_value = array[a];
                    forthisvillage = forthisvillage + 1;
                    total_container = total_container + forthisvillage;
            } else {
                     previous_value = array[a];
                    total_container = total_container + forthisvillage;
            }
            }

            //printing the no of containers required
             System.out.println("The minimum number of containers required to distribute wheat to each village is: " + total_container);
         }

        //calling the main function
        public static void main(String[] args) {

            // initializing an array
            int array[] = { 5,2,6 };
            //declaring variables
            int a;
            int total_container = 0;
            int previous_value = 0;
            int forthisvillage = 0;
    // traverse cordinate upto the length of array[] 
    for (a = 0; a < array.length; a++) {
            // comparing statements
            if (array[a] != previous_value) {
                    previous_value = array[a];
                    forthisvillage = forthisvillage + 1;

                    total_container = total_container + forthisvillage;
            } else {
                    previous_value = array[a];
                    total_container = total_container + forthisvillage;
            }
        }
            //printing the no of containers required
            System.out.println("The minimum number of containers required to distribute wheat to each village is: " + total_container);


            // sorting the array
            forEachVillage(array);

            // //calling the function to calculate the no of containers required
            // forCurrentVillage(array);
        }
    }
}


