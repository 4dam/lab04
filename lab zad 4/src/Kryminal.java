public class Kryminal extends Ksiazka {
	String opis;
	int liczbaOfiar;

	public Kryminal(String tytul, String opis, int liczbaOfiar) {
		super(tytul);
		this.opis = opis;
		this.liczbaOfiar = liczbaOfiar;
	}

	public String dajOpis() {
		return opis;
	}

	public String dajRodzaj() {
		return "Krymina³";
	}

	public int dajLiczbeOfiar() {
		return liczbaOfiar;
	}

}
