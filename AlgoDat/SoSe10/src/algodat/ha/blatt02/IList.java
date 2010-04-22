package algodat.ha.blatt02;

public interface IList {

  /*Exception, wenn der Index größer als die aktuelle Anzahl der elemente ist, z.B.:
   *getCount() --> 5
   *insertAt(10, 10) --> IllegalAccesException*/
  void insertAt (int i,
                 int value) throws IllegalAccessException;

  /*Exception, wenn der Index nicht existiert
   *bei -1 wird das letzte Element gelöscht*/
  void removeAt (int i) throws IllegalAccessException;

  /*Exception, wenn der Index nicht existiert
   *bei -1 wir das letzte Element zurückgegeben*/
  int getAt (int i) throws IllegalAccessException;

  /*Rückgabewert -1, falls kein Ergebnis*/
  int search (int value);

  void clear ();

  int getCount ();
}
