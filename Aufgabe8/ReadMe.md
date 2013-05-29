# **Aufgabe 6** #

We got 9 out of 10, because of there were no exception for cmd arguments (fixed).

Die Klassen des Java Collection Framework bieten eine Vielzahl an nützlichen Funktionalitäten. Die folgenden kleinen Übungsaufgaben sollen Sie mit dem Framework vertraut machen.

a) Schreiben Sie ein Programm, das die eingegebenen Kommandozeilenargumente (String args[]) daraufhin überprüft, ob sie mehrfach oder einfach vorkommen. Dabei soll das Programm zwei Mengen (Set<T>) bestimmen, wobei die eine der Menge der Duplikate und die andere der Menge der Unikate entspricht. Das Programm soll am Ende die Menge der Duplikate und die Menge der Unikate ausgeben.

Beispiel:
>java FindDups i came i saw i left
>
Unique words: [came, left, saw]
Duplicate words: [i]


(b) Schreiben Sie ein Programm, das ein Kartenspiel mit 52 Karten mit 4 Farben (Kreuz, Pik, Herz und Karo) zu je 13 Karten (Ass, König, Dame, Bube, 10, 9, 8, 7, 6, 5, 4, 3, 2) auf eine über die Kommandozeile definierte Anzahl von Spielern verteilt. Das zweite Kommandozeilenargument gibt an wie viele Karten jeder Spieler erhalten soll.

Beispielaufruf:
> java Geben 4 5
> 
[karo 6, herz ass, herz dame, pik 6, karo 2]
[kreuz 10, kreuz ass, karo 3, herz 8, kreuz 8]
[herz 2, kreuz koenig, pik 8, pik bube, karo ass]
[karo dame, pik 7, kreuz 2, pik ass, kreuz 9]

Hinweis: Karten können als String-Objekte repräsentiert werden ("karo 6","herz dame", ...). Eine Liste eignet sich zur Darstellung des Kartenstapels, mit der shuffle-Methode aus der Collections-Klasse kann der Kartenstapel gemischt werden und mit der Methode sublist(...) kann man ein Blatt je Spieler definieren und aus dem restlichen Kartenstapel löschen.