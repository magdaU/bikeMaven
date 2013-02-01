package Akcesoria;

public class Akcesoria  implements IAkcesoria {
	int id;
	String nazwa;
	String opis;
	Double cena;
	
	
	
	public Akcesoria(int id, String nazwa, String opis, Double cena) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.opis = opis;
		this.cena = cena;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void dodajAkcesoria() {

	}
	public void ustawCene() {
		
	}
}
