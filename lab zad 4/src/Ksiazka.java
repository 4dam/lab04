class Ksiazka
{
	String tytul;
	boolean czyWypozyczona;

	public Ksiazka( String tytul )
	{
	this.tytul = tytul;
	this.czyWypozyczona = false;
	}

	public void wypozycz()
	{ if (this.czyWypozyczona){
		System.out.println("Juz wypozyczona.");
		return;
	}
		this.czyWypozyczona = true;
		
	}
	
	public void oddaj()
	{ if (!this.czyWypozyczona){
		System.out.println("Nie mo¿na oddaæ.");
	}
		this.czyWypozyczona = false;
		;
	}

	public boolean czyWypozyczona()
	{
	return	this.czyWypozyczona;
	}

	public String dajTytul()
	{
		return this.tytul;
	}

	public String dajRodzaj()
	{
		return "";
	}

	public String dajOpis()
	{
		return "";
	}
	
	public String toString() {
		return dajTytul() + dajOpis();
	}

	public static void main( String[] argumenty ) 
	{
		Ksiazka przykladowa = new Ksiazka( "Pan Tadeusz" );
		System.out.println( "Tytul: (powinno byc Pan Tadeusz) " + przykladowa.dajTytul() );
		System.out.println( "Czy wypozyczona (powinna byc false)? " + przykladowa.czyWypozyczona() );
		przykladowa.wypozycz();
		System.out.println( "Czy wypozyczona (powinno byc true)? " + przykladowa.czyWypozyczona() );
		przykladowa.oddaj();
		System.out.println( "Czy wypozyczona (powinno byc false)? " + przykladowa.czyWypozyczona() );	
	}

}