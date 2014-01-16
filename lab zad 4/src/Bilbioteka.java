import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Biblioteka // metod kolekcji
{
	ArrayList<Ksiazka> ksiazki = new ArrayList<Ksiazka>();
	String nazwaBiblioteki;

	// Dodaj implementacje odpowiednich metod
	public static void main(String[] argumenty) {
		// Stworz dwie biblioteki
		Biblioteka pierwsza = new Biblioteka("Armi Krajowej 24");
		try {
			// System.out.println(new java.io.File(".").getCanonicalPath());
			BufferedReader wejscie = new BufferedReader(new FileReader(
					"nowe_ksiazki.csv"));
			String linia;
			while ((linia = wejscie.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(linia, "\t");

				String tytul = token.nextToken();
				String autor = token.nextToken();
				String wydawnictwo = token.nextToken();
				String opis = token.nextToken();

				Ksiazka k = new KsiazkaHistoryczna(tytul, autor, wydawnictwo,
						opis);
				pierwsza.dodajKsiazke(k);
				// System.out.println(k);
			}
			wejscie.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(pierwsza.ksiazki.size());
		/*wypozyczam Templariusze:
		pierwsza.wypozyczKsiazke("Templariusze");
		pierwsza.wypozyczKsiazke("Templariusze");
		pierwsza.wypozyczKsiazke("Templariusze");
		pierwsza.wypozyczKsiazke("Żukow");
		pierwsza.oddajKsiazke("Żukow");
		pierwsza.oddajKsiazke("Żukow");
		pierwsza.wypozyczKsiazke("pupa");
		*/
	}

	public Biblioteka(String nazwaBiblioteki) {

		this.nazwaBiblioteki = nazwaBiblioteki;
	}

	public void dodajKsiazke(Ksiazka ksiazka) {
		ksiazki.add(ksiazka);
	}

	public static void wypiszGodzinyOtwarcia() {
		System.out
				.println("Biblioteki sa otwarte codziennie od 9:00 do 17:00.");
	}

	public void wypiszAdres() {
		System.out.println(nazwaBiblioteki);
	}

	public void wypozyczKsiazke(String tytul) {
		Ksiazka szukana = null;
		for (Ksiazka k : ksiazki) {
			if (k.dajTytul().equals(tytul)) {
				szukana = k;
				if (!k.czyWypozyczona()) {
					k.wypozycz();
					System.out.println("Udało się wypozyczć książkę " +tytul);
					return;
				}
			}
		}
		if (szukana == null) {
			System.out.println("Przykro nam, nie mamy takiej książki.");
		} else {
			System.out.println("Przykro nam, ksiazka jest juz wypozyczona.");
		}
	}

	public void wypiszDostepneKsiazki() {
		if (ksiazki.isEmpty()) {
			System.out.println("Brak ksiazek w bibliotece.");
			return;
		}
		for (Ksiazka k : ksiazki) {
			System.out.println(k);
		}

	}

	public void oddajKsiazke(String tytul) {
		Ksiazka szukana = null;
		for (Ksiazka k : ksiazki) {
			if (k.dajTytul().equals(tytul)) {
				szukana = k;
				if (k.czyWypozyczona()) {
					k.oddaj();
					System.out
							.println("Udało Ci sie zwrócic ksiazke: " + tytul);
					return;
				}
			}
		}
		if (szukana == null)
			System.out.println("Nie ma takiej książki.");
		else
			System.out.println("Książka o tytule " + tytul
					+ " nie jest wypożyczona.");

	}
}
