package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Klasa VulkanizerskaRadnja koja implementira interfejs Radnja.
 * Implementira sve motode iz klase Radnja i sadrzi privatnu listu guma.
 * Klasa ima mogucnost dodavanja i pronalazenja guma preko String vrednosti koja predstavlja marku gume.
 * 
 * @author Djordje Novakovic
 * @version 0.0.2
 */
public class VulkanizerskaRadnja implements Radnja {
	
	/**
	 * Privatna lista svih guma koja ne sadrzi duplikate.
	 * Implementira preko klase LinkedList
	 */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}

	@Override
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}
	
}