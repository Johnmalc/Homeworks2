a) Programmieren Sie eine Swing-Oberfläche für die CashMachine (Aufgabe 1)!

Der Benutzer soll über die Oberfläche die Kontonummer eingeben können (das simuliert die Eingabe einer CashCard). Die Überprüfung der Existenz des Kontos erfolgt durch die Betätigung einer Schaltfläche. Ist das Konto vorhanden, soll es möglich sein den PIN einzugeben und zu bestätigen.

Ist eine korrekte Kontonummer angegeben oder der PIN korrekt eingegeben, soll eine Kontoinformationenabfrage möglich sein (in beiden Fällen).

Ist der PIN korrekt eingegeben soll es möglich sein aus einer Auswahl festgelegte Geldbeträge vom Konto abzuheben.

Die Zustände und Meldungen sollen auf der Oberfläche in einem Informationsbereich angezeigt werden (z.B. mittels eines JLabel-Objekts), Expections sollen weiterhin zusätzlich auf der Konsole ausgegeben werden. Die Logik des Programmes soll dabei durch Wiederverwendung der Klasse CashMachine aus Aufgabe 1 erfolgen!

Im Prinzip sind Sie frei die Oberfläche zu gestalten (Komponenten, Layout, etc.). Eine Möglichkeit wäre es für die Eingaben (Kontonr, PIN) die Klasse JTextField zu nutzen. Für die Bestätigung oder den Abfragen wären Button (Klasse JButton) möglich und für die Wahl der Geldbeträge eine Auswahlbox (Klasse JComboxBox).

Achtung: Fehlerhafte Eingaben müssen erkannt, die entsprechenden Exceptions abgefangen und geeignete Hinweise den Benutzern im Informationsbereich angezeigt werden.

Geldautomat

Abb. 1: Beispiel Oberfläche für die CashMachine

b)

Ändern Sie das Abheben so ab, dass zusätzlich zur Auswahl eines vorgegebenen Betrags ein Betrag frei eingegeben werden kann. Die Oberfläche muss jedoch verhindern, dass gleichzeitig ein vorgegebener Betrag ausgewählt und ein freier Betrag eingegeben werden kann. Nutzen Sie für die Lösung die Klasse JRadioButton, mit der ein Nutzer auswählen kann ob die Auswahl eines vorgegebenen Betrags oder die Eingabe eines freien Betrags berücksichtigt werden soll.