public class KsiazkaFantastyczna extends Ksiazka {
	String opis;

	public KsiazkaFantastyczna(String tytul, String opis) {
		super(tytul);
		this.opis = opis;
	}

	public String dajOpis() {
		return opis;
	}

	public String dajRodzaj() {
		return "Ksi¹¿ka fantastyczna";
	}
}
