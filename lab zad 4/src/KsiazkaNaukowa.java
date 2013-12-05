
public class KsiazkaNaukowa extends Ksiazka {
String dziedzina;

public KsiazkaNaukowa(String tytul, String dziedzina){
	super(tytul);
	this.dziedzina = dziedzina;
	
}
public String dajOpis(){
	return "Ksi¹¿ka z dziedziny: " + dziedzina;
}
public String dajDziedzine() {
	return dziedzina;
}
public String dajRodzaj() {
	return "naukowa";
}
}
