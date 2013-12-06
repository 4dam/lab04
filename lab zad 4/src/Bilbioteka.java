import java.util.HashMap;

class Biblioteka //metod¹ kolekcji
{
	HashMap<String, Integer> ksiazki;
	String nazwaBiblioteki;
	

	//Dodaj implementacje odpowiednich metod
	public static void main( String[] argumenty )
	{
		//Stworz dwie biblioteki
		Biblioteka pierwsza = new Biblioteka( "Armi Krajowej 24" );
		Biblioteka druga = new Biblioteka( "Plac Grunwaldzki 6" );

		//Dodaj cztery ksiazki do pierwszej biblioteki
		pierwsza.dodajKsiazke( new Epopeja( "Pan Tadeusz", "Zaperaj¹cy dech w piersiach poemat w 12 ksiêgach wierszem pisany" ) ); // , kontrol spacja i pogrubione
		pierwsza.dodajKsiazke( new Ksiazka( "Pan Tadeusz"));
		pierwsza.dodajKsiazke( new KsiazkaFantastyczna( "Gra o Tron", "Tutaj ka¿dy umiera" ) );
		pierwsza.dodajKsiazke( new Kryminal( "Tozsamosc Bourne'a", "Bourne szuka swojej to¿samoœci", 44 ) );
		pierwsza.dodajKsiazke( new KsiazkaNaukowa( "Analiza Matematyczna", "matematyka" ) );

		//Wypisz godziny urzedowania bibliotek
		System.out.println( "Godziny otwarcia bibliotek ");
		wypiszGodzinyOtwarcia();
		System.out.println(); //pusta linijka

		System.out.println( "Adresy bibliotek " );
		pierwsza.wypiszAdres();
		druga.wypiszAdres();
		System.out.println(); //pusta linijka

		//wypozycz Pana Tadeusza z obu bibliotek
		System.out.println( "Wypozyczanie Pana Tadeusza" );
		pierwsza.wypozyczKsiazke( "Pan Tadeusz" );
		System.out.println();
		pierwsza.wypozyczKsiazke( "Pan Tadeusz" ); //sprobuj jeszcze raz

		druga.wypozyczKsiazke( "Pan Tadeusz" );

		System.out.println(); //pusta linijka

		//Wypisz dostepne tytuly w obu bibliotekach
		System.out.println( "Ksiazki dostepne w pierwszej bibliotece" );
		pierwsza.wypiszDostepneKsiazki();
		System.out.println(); //pusta linijka
		System.out.println( "Ksiazki z drugiej biblioteki" );
		druga.wypiszDostepneKsiazki();
		System.out.println();

		// zwroc Pana Tadeusza do biblioteki
		System.out.println( "Zwrot Pana Tadeusza" );
		pierwsza.oddajKsiazke( "Pan Tadeusz" );
		System.out.println();

		// Wypisz tytuly dostepne w pierwszej bibliotece
		System.out.println( "Ksiazki dostepne w pierwszej bibliotece" );
		pierwsza.wypiszDostepneKsiazki();
	}
	
	public Biblioteka(String nazwaBiblioteki) {
		ksiazki = new HashMap<String, Integer>(); //tworze mape ksiazek(String->Integer)
		this.nazwaBiblioteki = nazwaBiblioteki;
	}

	public void dodajKsiazke(Ksiazka ksiazka) {
		if (ksiazki.containsKey(ksiazka.tytul)){ //czy istnieje tu taka ksiazka
			Integer ilosc = ksiazki.get(ksiazka.tytul); //zmienna ilosci ksiazek
			ksiazki.put(ksiazka.tytul, ++ilosc); //wpisuje do mapy ze jest o 1 ksiazke wiecej
		} else {
			ksiazki.put(ksiazka.tytul, 1); //ustawiam ilosc ksiazek na 1
		}
		
	}
	public static void wypiszGodzinyOtwarcia() {
		System.out.println("Biblioteki sa otwarte codziennie od 9:00 do 17:00.");
	}
	public void wypiszAdres() {
		System.out.println(nazwaBiblioteki);
	}
	public void wypozyczKsiazke(String tytul) {
		 if (!ksiazki.containsKey(tytul)){ //czy nie istnieje tu taka ksiazka
			 System.out.println("Przykro nam, nie mamy takiej ksi¹¿ki.");
			 return;
		 }
		 Integer ilosc = ksiazki.get(tytul);
		// System.out.println(ilosc);
		 if (ilosc > 0){ //czy ta ksiazka jest wypozyczona
			 System.out.println("Uda³o siê wypo¿yczyæ Ksi¹¿kê: " + tytul);
			 ksiazki.put(tytul, --ilosc); //wypozyczylem ksiazke
		 } 		 
		 else 
			 System.out.println("Przykro nam, ksiazka jest juz wypozyczona.");
	}
	public void wypiszDostepneKsiazki() {
		if (ksiazki.isEmpty()){
			System.out.println("Brak ksiazek w bibliotece.");
			return;
		}
		 for (String tytul : ksiazki.keySet()){ //przelatuje przez abcd
			 if (ksiazki.get(tytul)>0) //pozbywam sie wypozyczonych
				 System.out.println(tytul);
		 }
				
	}
	public void oddajKsiazke(String tytul) {
		Integer ilosc = ksiazki.get(tytul); //ilosc aktualnych ksiazek
		ksiazki.put(tytul, ++ilosc); //oddalem jedna
		System.out.println("Uda³o Ci sie zwrócic ksiazke: " +tytul);
	}
}
		
