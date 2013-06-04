Anwendung des Beobachter-Musters (Observer)

In der vorliegenden Aufgabe soll der Lagerbestand von Produkten überwacht werden. Programmieren Sie dazu eine Klasse Produkt, die die folgenden Attribute besitzt:

    Produktnummer (int pNr)
    Produktbeschreibung (String pDescr)
    Lagerbestand (int holding)
    Mindestlagerbestand (int minHolding)

Neben geeigneten Konstruktoren und den notwendigen getter- und setter-Methoden soll die Klasse auch eine Methode zur Reduktion des Lagerbestandes besitzen (public void removeProducts(int amount);). Die Klasse erweitert java.util.Observable.

Der Lagerbestand von Produkten soll überwacht werden. Schreiben Sie eine Klasse WarehouseDisplay, welche den aktuellen Lagerbestand eines Produktes auf der Konsole ausgibt, sobald sich der Lagerbestand ändert. Schreiben Sie eine zweite Klasse WarehouseOrder, welche bei einer Lagerbestandsveränderung prüft. Ob der Mindestlagerbestand unterschritten wurde und ggf. automatisch eine Bestell-Warnung auf die Konsole ausgibt. Beide Klassen implementieren java.util.Observer.

Um Ihre Klassen testen zu können müssen Sie eine Klasse App programmieren, welche in ihrer main-Methode beispielhaft ein Produkt erzeugt, jeweils ein Objekt der beiden Observer-Klassen beim Produkt registriert und dann den Lagerbestand so verringert, dass beide Observer aktiv werden müssen. Im Falle, dass zu wenig Lagerbestand vorhanden ist soll eine RuntimeException geworfen werden.