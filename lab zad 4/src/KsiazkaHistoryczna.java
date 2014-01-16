public class KsiazkaHistoryczna extends Ksiazka {
	String autor;
	String wydawnictwo;
	String opis;

	public KsiazkaHistoryczna(String tytul, String autor, String wydawnictwo,
			String opis) {
		super(tytul);
		this.autor = autor;
		this.wydawnictwo = wydawnictwo;
		this.opis = opis;
	}
	public String toString() {
		return tytul + autor + wydawnictwo + opis;
	}
}
