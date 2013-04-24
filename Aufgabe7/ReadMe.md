Implementieren Sie eine Queue (Klasse Queue<K>) welche nach dem First-In First-Out Prinzip funktioniert. Die Implementierung soll auf dem Prinzip der Verkettung basieren (analog zur Liste). 

a)Implementieren sie dabei die folgenden Methoden:

    public String toString() {…}
    public boolean isEmpty() {…}
    public void push(K element) {…} (Methode zum Einfügen eines Elements in die Queue)
    public K pull() {…} (Methode zum herausnehmen eines Elements aus der Warteschlange)
    Public int size() {…} (Gibt die Anzahl der in der Liste gespeicherten Elemente zurück)

Schreiben Sie eine Klasse Main, die eine ausführbare main-Methode enthält, in der Sie ihre Queue testen können. Erzeugen Sie dazu eine neue Queue für Strings, fügen Sie die Zeichenketten „Erstes Element“, „Zweites Element“ und „Drittes Element“ hinzu und geben Sie die Liste auf der Konsole aus. Prüfen Sie vor und nach dem Hinzufügen der Elemente den Rückgabewert der Methode isEmpty(). Entfernen sie Elemente der Queue mit pull(). Überprüfen Sie dabei, ob Ihre Queue nach dem FIFO-Prinzip gearbeitet hat, indem Sie sie erneut auf der Konsole ausgeben.

b) Freiwillig!
Implementieren Sie die Methode java.util.Iterator<K> iterator() {...} unter Verwendung einer geeigneten inneren Klasse wie in der Vorlesung besprochen. Testen Sie Ihren Iterator ausführlich!