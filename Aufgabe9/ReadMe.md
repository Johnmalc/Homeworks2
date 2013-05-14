**Aufgabe 9**

Die Klasse java.util.Collections enthält eine Methode, die binäre Suche (Methode binarySearch()) auf Listen realisiert. Binäre Suche ist eine effizientes Verfahren zur Suche von Elementen in sortierten Listen.

Methodensignatur:

	binarySearch(List<? extends Comparable<? super T>> list, T key)
>
Searches the specified list for the specified object using the binary search algorithm.



Erzeugen Sie in der main-Methode einer Klasse eine LIste der Größe n von ganzen Zahlen . Die Liste soll die Zahlen 0 bis (n-1) aufsteigend sortiert speichern. Verwenden Sie eine Listenimplementierung der Java-API, die für wahlfreie Zugriffe optimiert ist.

Vergleichen Sie die Laufzeiten der binären Suche mit den Laufzeiten einer linearen Suche (die sie selbst in einer Methode realisieren sollen) bei einer Suche nach der Zahl n (worst case, da die Zahl nicht gefunden wird).

Das Programm soll als Parameter den zu verwendenden Suchalgorithmus (0=lineare Suche, 1=binäre Suche) und die Zahl n (Größe der Liste) zum Start erhalten. Ausgabe des Programms ist die gemessene Zeit für die Suche.

Messen Sie die Laufzeiten der beiden Algorithmen für n=10.000, n=100.000, n=1.000.000 und n=10.000.000. Erstellen Sie mit Hilfe von **Excel** eine Kurvendiagramm, welches in der x-Achse die Werte von n und in der y-Achse die Laufzeiten enthält. Das Diagramm soll jeweils eine Kurve für jedes Verfahren beinhalten.

Welches Verfahren ist schneller? Binäre Suche oder Lineare Suche?

Eine Zeitmessung in Nanosekunden (ns) kann mit Hilfe der folgenden Klassenmethode der Klasse java.lang.System erfolgen:

static long nanoTime()

Returns the current value of the most precise available system timer, in nanoseconds.

Für die Kurvendiagramme müssen Sie ggf. eine andere Zeiteinheit als ns für die y-Achse verwenden, damit die Messwerte gut dargestellt werden können. Auf der x-Achse können Sie die nicht lineare Folge der Werte von n linear darstellen, damit die x-Achse nicht zu lang wird.

Beispiel-Anwendung: Zeitessung einer for-Schleife in Nanosekunden

    
    class Test {
    
       public static void main(String[] args) {
             long start = System.nanoTime();
             for(int i=0;i<100000;i++) {
                 System.out.print(".");
             }
             long stop = System.nanoTime();
             System.out.printf("Elapsed time %1$10d ns\n",stop-start);
       }
    }