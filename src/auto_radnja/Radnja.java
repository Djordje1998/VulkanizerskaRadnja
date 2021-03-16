package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji sadrzi sve potrebne metode za neku radnju koja ima mogucnost dodavanja i pretrage guma.
 * Liste su implementirane preko LinkedList, a ima mogucnost da dodaje objekte klase AutoGuma i vrsi pretragu preko String-a koji predstavlja marku gume.
 * 
 * @author Djordje Novakovic
 * @version 0.0.2
 */
public interface Radnja {
	
	/**
	 * Metoda prima parametar kao objekat klase AutoGuma i dodaje ga u listu.
	 * Kako bi objekat bio uspesno dodat potrebno je da bude razlicit od null.
	 * U slucaju da guma vec postoji nece biti dodata u listu.
	 * 
	 * @param a Objekat klase AutoGuma koji se dodaje u listu.
	 * @throws java.lang.RuntimeException u slucaju ako guma vec postoji u listi.
	 * @throws java.lang.NullPointerException u slucaju ako se kao parametar prosledi null.
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Metoda prima String parametar koji predstavlja model gume i vrsi pretragu kroz postojecu listu.
	 * Za sve gume koje imaju jednak model kao parametar ubacuju se u novu listu koja se vraca kao rezultat.
	 * 
	 * @param markaModel String vrednost koja predstavlja model gume i preko koje se vrsi pretraga.
	 * @return 
	 * <ul>
	 * 		<li>LinkedLista objekata klase AutoGuma koje poseduje radnja, moze biti prazna ako nema dodatih guma.</li>
	 * 		<li>Null u slucaju da je String parametar null.</li>
	 * </ul>
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}