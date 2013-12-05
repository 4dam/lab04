
public class Epopeja extends Ksiazka {
	String krotkiOpis;
public Epopeja(String tytul, String krotkiOpis){
	super(tytul);
	this.krotkiOpis = krotkiOpis;
}
public String dajRodzaj(){
 return "epopeja";
 }
public String dajOpis() {
	return krotkiOpis;
}
}
