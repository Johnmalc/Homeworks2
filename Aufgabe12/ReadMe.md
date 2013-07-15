# Aufgabe 10 #

We got 7 out of 10, because using the instanceof was (of course) wrong. 

> Anwendung des Kompositum-Musters (Composite)
> 
> Eine Java-Applikation soll Verzeichnisbäume verwalten können. Ein Verzeichnisbaum besteht analog zum Dateisystem eines Betriebssystems aus Verzeichnissen und Dateien. Verzeichnisse können weitere Verzeichnisse oder Dateien enthalten. Dateien sind atomar, d.h. sie enthalten keine Verzeichnisse oder Dateien.
> 
> Realisieren Sie diese Situation unter Verwendung des Kompositum-Musters. Kompositum-Objekte sind die Verzeichnisse (Klasse Directory), die Blätter sind Dateien (Klasse File). Das gemeinsame Interface beschreibt die Funktionen eines Eintrags (Interface Entry). Ein Eintrag kann also gemäß des Musters sowohl ein Verzeichnis, als auch eine Datei sein.
> 
> Programmieren Sie die Klassen Directory und File sowie das Interface Entry.
> Die Klasse Directory benötigt Methoden und Attribute zur Verwaltung von Einträgen (Verzeichnisse und Dateien). Beide Klassen sollen den Namen des Verzeichnisses bzw. der Datei als Attribut verwalten (wird für die Ausgabe benötigt).
> Über die gemeinsamen Methoden des Interface Entry sollen zwei Funktionalitäten ermöglicht werden:
> 
> 1. Mittels einer Methode print soll die verschachtelte Struktur auf der Konsole ausgegeben werden.
> 2. Mittels einer Methode numberOfEntries soll die Anzahl der Einträge in dem jeweiligen Teilbaum ermittelt werden.
> 
> Programmieren Sie darüber hinaus eine Klasse App, die in ihrer main-Methode einen beispielhaften Verzeichnisbaum erstellt, mittels der Methode print ausgibt und auch die Anzahl der Einträge im Beispiel-Verzeichnisbaum mittels der Methode numberOfEntries bestimmt.