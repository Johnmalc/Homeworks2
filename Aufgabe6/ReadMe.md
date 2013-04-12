**Facultative exercise: Not to sent** 


Für ein CAD-Programm sollen grundlegende Klassen für zweidimensionale Formen (engl. Shape) programmiert werden.

(a) Implementieren Sie eine Klasse die ein Rechteck beschreibt (Rectangle) und eine Klasse die einen Kreis beschreibt (Circle). Versehen Sie beide Klassen mit geeigneten Konstruktoren, Feldern und Methoden. Beide Klassen implementieren das Interface Shape:

public interface Shape {
/**
* Die Methode area() gibt den Flächeninhalt der Form
* zurück
*/
public double area();
/**
* Die Methode circumference() gibt den Umfang der
* Form zurück
*/
public double circumference();
}

Schreiben Sie ein Testprogramm (Klasse Test) zur Überprüfung der Methoden. Bemerkung: Mathematische Funktionen und Konstanten wie PI gibt es in der Klasse java.lang.Math als statische Elemente (z.B. Math.PI; siehe Java-API Dokumentation)

(b) Schreiben Sie eine Klasse Util, die zwei statische Methoden enthält, die den Gesamtflächenbedarf bzw. den Gesamtumfang aller Formen in einem Array berechnet. Die beiden Methoden haben die folgende Signatur:

public static double accumulateArea(Shape[] shapes) {
...
}
public static double accumulateCircumference(Shape[] shapes)
{
...
}

Erweitern Sie das Testprogramm aus Teilaufgabe (a) in der Form, dass Sie ein Shape-Array erstellen und es mit diversen Rechtecken und Kreisen füllen. Verwenden Sie die Methoden aus der Klasse Util zur Berechnung der Gesamtfläche bzw des Gesamtumfangs der Objekte im Array.

(c) Ein C-Programmierer, der auch php4 toll findet sieht Ihren Code und sagt: "Das kapiere ich nicht! Wozu verwendest Du Schnittstellen, dass geht doch auch ohne!". Er grinst und fügt der Klasse Util eine Methode mit folgender Signatur hinzu, die tatsächlich das Gleiche macht ohne die Schnittstelle Shape zu verwenden:

public static double accumulateArea(Object[] objects) {
...
}

Programmieren Sie diese Methode. Welche Nachteile hat diese Methode gegenüber der Variante, welche die Schnittstelle Shape verwendet? (Tipps gibt's im Praktikum;-)

(d) Erstellen Sie eine neue Form unter Verwendung der Formenklassen aus Teilaufgabe (a). Die neue Form ist ein Rechteck, das einen Kreis zentriert enthält (Klasse RectangleCircle). Zur Fläche dieser neuen Form zählt nur der Bereich, der sich zwischen den Rechteckbegrenzungen und dem Kreis befindet. Der Umfang ist durch die Summe des Umfangs von Kreis und Rechteck gegeben. Überlegen Sie sich welche Konstruktoren, Felder und Methoden nötig sind. Die neue Klasse muss ebenfalls die Schnittstelle Shape implementieren. Versuchen Sie so viel wie möglich von den bestehenden Klassen wiederzuverwenden!!!

Skizze der Form RectangleCircle

Beachten Sie, das der Durchmesser des Kreises nie größer sein darf als eine der Seitenlängen des Rechtecks (sonst: Exception werfen!). Verändern Sie Ihr Testprogramm in der Art, dass Sie jetzt auch Objekte der Klasse RectangleCircle im Array speichern und damit auch ihr Flächeninhalt bzw. Umfang in die Berechnung einfließt.
