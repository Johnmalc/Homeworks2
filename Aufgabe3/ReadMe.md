Also this time we got a homework in Germany. Don't worry, be happy 
We could get 10 points and we got: **to add**:
I thank to guys at [http://stackoverflow.com/questions/2047003/print-arraylist-element](http://stackoverflow.com/questions/2047003/print-arraylist-element) and at [http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGeneric.html](http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGeneric.html)  <<<< This is a very good page.

**I got (written for the group but myself) 9.5/10. The mistake was in the package.**

> In einer Warenhaussoftware sollen Produkte verwaltet werden. In der vorliegenden Übungsaufgabe sollen die grundlegenden Typen entwickelt werden.
> 
> (a) Schreiben Sie eine generische Klasse Product, die ein Produkt repräsentiert. Ein Product- Objekt besteht aus zwei Attributen. Das erste Attribut ist die Produktbeschreibung, das zweite Argument ist der Produktpreis. Das zweite Attribut Produktpreis ist vom Datentyp double. **Die tatsächliche Klasse für das Attribut Produktbeschreibung soll erst bei der Verwendung der Klasse festgelegt werden, verwenden Sie deshalb eine Typvariable (Stellvertreterbuchstaben).** 
> 
>  Die Klasse Product soll einen Konstruktor besitzen, der Werte für beide Attribute als Argumente übergeben bekommt. Schreiben Sie ein Testprogramm, welches eine Anzahl von Product-Objekten erzeugt (Verwenden Sie die Klasse String als Klasse für die Produktbeschreibung), in einem Array speichert und auf die Standardausgabe ausgibt. 
>  
>  Verwenden Sie zur Ausgabe des Arrays die "neue" for-Schleife von Java (Seit der Version 1.5 kann die for-Schleife im Sinne einer foreach-Schleife verwendet werden. Es ist dann keine Laufvariable zur Indizierung in ein Array oder eine Collection notwendig, sondern die Laufvariable nimmt selber den Wert an.)
> 
> (b) Schreiben Sie eine Klasse ProductDescription, die eine Produktbeschreibung repräsentiert. Die Klasse hat 2 Attribute, eine **Produktgruppe** und einen **Beschreibungstext**. Beide Attribute werden durch
> die Klasse **String** repräsentiert. Implementieren Sie alle nötigen Konstruktoren und die Methode public String toString() (Der Ergebnis-String soll die Produktgruppe und den Text enthalten). Verändern Sie das Testprogramm aus Teilaufgabe (a) **in der Art, dass an Stelle eines String-Objekts ein Objekt der Klasse ProductDescription als Produktbeschreibung verwendet wird.**
> 
> (c) Das Preissystem der Warenhaussoftware soll umgestellt werden. Produktpreise sollen nicht mehr beliebig vergeben werden können. Stattdessen gibt es 4 Preisstufen, denen ein Produkt zugeordnet wird. Die Stufen sind LOW (9,99), MEDIUM (19,99), HIGH (49,99) und EXCLUSIVE (99,99). Innerhalb der Warenhaussoftware sollen die Preisstufen durch einen Enum-Typ (enum PriceLevel) repräsenstiert werden. Programmieren Sie den enum PriceLevel, passen Sie die Klasse Product und Ihr Testprogramm aus Teilaufgabe (a) an.
> 
> Hinweis: Der Preis muss als **double-Datentyp** im enum PriceLevel verwaltet werden. Der enum-Typ muss zusätzlich public String toString() überschreiben (gibt den Preis als String zurück) und einen **privaten** Konstruktor besitzen, der den Preis als Argument erhält.