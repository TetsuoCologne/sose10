package algodat.uebung.blatt03;

public interface IQueue {

  /**
   * Fügt ein Element hinzu. Wird verwendet, wenn ein Fehler erwartet wird, hier
   * z.B. weil das zirkuläre Feld nicht vergrößert wird, also "Überlaufen" kann
   * 
   * @param value
   *          = Wert der eingefügt werden soll
   * @return true bei Erfolg, false wenn Einfügen nicht möglich, weil z.B. Liste
   *         voll
   */
  boolean offer (int value);

  /**
   * Löscht den Head der Queue
   * 
   * @return Head der Queue oder Integer.MAX_VALUE falls Queue leer
   */
  int poll ();

  /**
   * gibt den Head der Queue zurück ohne diesen zu löschen
   * 
   * @return Head der Queue
   */
  int peek ();

  /**
   * gibt Anzahl der Element der Queu zurück
   */
  int getCount ();

  /**
   * löscht die aktuelle Queue
   */
  void clear ();

}
