package algodat.uebung.blatt03;

import java.util.ArrayList;

public class Time {

  public static void arrayListSearchTime () {
    ArrayList<Integer> list = new ArrayList<Integer> ();
    for (int i = 1; i <= 1000000; i++) {
      list.add (i);
    }
    //Zahl die gesucht wird
    int randomElement = (int) (Math.random () * 1000000);
    System.out.println (randomElement);
    System.out.println ();

    //list.contains
    long begin = System.currentTimeMillis ();
    for (int i = 0; i < 100; i++) {
      list.contains (randomElement);
    }
    long end = System.currentTimeMillis ();
    System.out.println ("list.contains");
    double time = (end - begin) / 1000.0;
    Time.message ("Zeit für 1 Suchen", time / 100);
    Time.message ("Zeit für 100 mal Suchen", time);
    System.out.println ();

    //binarySearch
    begin = System.currentTimeMillis ();
    for (int i = 0; i < 1000000; i++) {
      java.util.Collections.binarySearch (list, randomElement);
    }
    end = System.currentTimeMillis ();
    System.out.println ("binarySearch");
    time = (end - begin) / 1000.0;
    Time.message ("Zeit für 1 Suchen", time / 1000000);
    Time.message ("Zeit für 1000000 mal Suchen", time);
    System.out.println ();

    //myBinarySearch
    int temp = 0;
    begin = System.currentTimeMillis ();
    for (int i = 0; i < 1000000; i++) {
      temp = Time.myBinarySearch (list, randomElement);
    }
    end = System.currentTimeMillis ();
    System.out.println (temp);
    System.out.println ("myBinarySearch");
    time = (end - begin) / 1000.0;
    Time.message ("Zeit für 1 Suchen", time / 1000000);
    Time.message ("Zeit für 1000000 mal Suchen", time);
    System.out.println ();

  }

  private static void message (String message,
                               double d) {
    System.out.println (message + ": " + d + "sec");
  }

  private static int myBinarySearch (ArrayList<Integer> list,
                                     int value) {
    int links = list.get (0);
    int rechts = list.get (list.size () - 1);
    int mitte = rechts / 2;
    while (mitte != value) {
      if (value > mitte) {
        links = mitte;
        mitte = (rechts + links) / 2;
      } else {
        rechts = mitte;
        mitte = (rechts + links) / 2;
      }
    }
    return mitte;
  }
}
