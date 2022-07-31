package week1;
import java.util.*;

public class linkedlist {
    //declaring variables to store totalsize
    Queue<Integer> list;
    int totalSize;

    linkedlist(LinkedList[] a) {

        // int size = a.length;
        int whole = 0;
        // traverse cordinate upto the length of array[] a
        for (int i = 0; i < a.length; i++) {

            whole += a[i].size();

        }
        // storing the value from whole
        totalSize = whole;

        //creating new priority queue
        list = new PriorityQueue<Integer>(whole);

        LinkedList current;
        // traverse upto the length of 'a'
        for (int i = 0; i < a.length; i++) {

            current = a[i];

            int internalItterator = 0;

            while (internalItterator < current.size()) {

                // System.out.println(current.get(0));
                int adder = (Integer) current.get(0);
                list.add(adder);
                current.removeFirst();
            }
            internalItterator++;

        }

    }

    int[] queueItterator() {

        int[] returner = new int[totalSize];
        // traverse cordinate upto the length of totalsize 
        for (int i = 0; i < totalSize; i++) {
            returner[i] = list.remove();
        }
        // return value  of that paticular array
        return returner;

    }
    // main function
    public static void main(String[] args) {
        // given values for first linkedlist

        LinkedList a = new LinkedList<Integer>();

        a.add(2);
        a.add(4);
        a.add(7);
        a.add(5);
        a.add(10);

        // given values for second linkedlist
        LinkedList b = new LinkedList<Integer>();

        b.add(3);
        b.add(2);
        b.add(7);
        b.add(9);

        // given values for third linkedlist
        LinkedList c = new LinkedList<Integer>();

        c.add(12);
        c.add(5);
        c.add(6);
        c.add(9);

        LinkedList[] list = { a, b, c };

        // creates instance of the class
        linkedlist medianFinder = new linkedlist(list);
        // calling function
        int[] requiredArr = medianFinder.queueItterator();

        int median = (requiredArr.length + 1) / 2;

        // displaying the output
        System.out.println(requiredArr.length);
        // prints median
        System.out.println(median);
        // prints requiredArr median
        System.out.println(requiredArr[median]);

    }

}