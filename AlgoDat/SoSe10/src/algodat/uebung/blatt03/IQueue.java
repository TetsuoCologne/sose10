package algodat.uebung.blatt03;

public interface IQueue {

  /**
   * F�gt ein Element hinzu. Wird verwendet, wenn ein Fehler erwartet wird, hier
   * z.B. weil das zirkul�re Feld nicht vergr��ert wird, also "�berlaufen" kann
   * 
   * @param value
   *          = Wert der eingef�gt werden soll
   * @return true bei Erfolg, false wenn Einf�gen nicht m�glich, weil z.B. Liste
   *         voll
   */
  boolean offer (int value);

  /**
   * L�scht den Head der Queue
   * 
   * @return Head der Queue oder Integer.MAX_VALUE falls Queue leer
   */
  int poll ();

  /**
   * gibt den Head der Queue zur�ck ohne diesen zu l�schen
   * 
   * @return Head der Queue
   */
  int peek ();

  /**
   * gibt Anzahl der Element der Queu zur�ck
   */
  int getCount ();

  /**
   * l�scht die aktuelle Queue
   */
  void clear ();

}
