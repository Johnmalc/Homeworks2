package de.ana;


public class File implements Entry {
String name;


public File(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public void print() {
	System.out.println(name);
	
}

@Override
public int numberOfEntries() {
		//throws Exception {
	//throw new Exception("SORRY! Dateien sind atomar.Sie enthalten keine Verzeichnisse oder Dateien. ");
	System.out.print("SORRY! Dateien sind atomar.Sie enthalten keine Verzeichnisse oder Dateien. ");
	return 0;
}
}
