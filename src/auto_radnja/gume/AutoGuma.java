package auto_radnja.gume;

/**
 * Klasa AutoGuma koja ima atribute visina gume, sirina gume i presnik gume kao Integer vrednosti i marka i model gume kao String.
 * Klasa AutoGuma sadrzi kontruktor sa svim parametrim i prazan(default) konstruktor.
 * 
 * @author Djordje Novakovic
 * @version 0.0.1 
 */
public class AutoGuma {
	
	/**
	 * Marka modela auto gume koja se cuva kao String vrednost.
	 */
	private String markaModel = null;
	
	/**
	 * Precnik auto gume koja se cuva kao Integer vrednost.
	 */
	private int precnik = -1;
	
	/**
	 * Sirina auto gume koja se cuva kao Integer vrednost.
	 */
	private int sirina = -1;
	
	/**
	 * Visina auto gume koja se cuva kao Integer vrednost.
	 */
	private int visina = -1;

	/**
	 * Prazan(default) konstruktor klase AutoGuma.
	 */
	public AutoGuma() {
	}

	/**
	 * Konstruktor koji prima sve atribute klase AutoGuma kao parametre.
	 * Svi parametri se proveravaju da li zadovoljavaju vrednosti preko seter metoda.
	 * 
	 * @param markaModel Marka modela auto gume koja se cuva kao String vrednost.
	 * @param precnik Precnik auto gume koja se cuva kao Integer vrednost.
	 * @param sirina Sirina auto gume koja se cuva kao Integer vrednost.
	 * @param visina Visina auto gume koja se cuva kao Integer vrednost.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Metoda koja vraca postavljenu marku modela gume koja predstavlja String vrednost.
	 * 
	 * @return Marka modela auto gume kao String vrednost.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Metoda prima parametar u obliku Stringa i proverava da li zadovoljava uslove da postane atribut markaModel.
	 * 
	 * @param markaModel Marka modela auto gume koja se cuva kao String vrednost.
	 * @throws java.lang.NullPointerException u slucaju kada je parametar poslat kao null vrednost.
	 * @throws java.lang.RuntimeException u slucaju kada je parametar String koji je kraci od 3 karaktera.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Metoda vraca Integer vrednost koja je sacuvana u atributu precnik.
	 * 
	 * @return Integer vrednost koja predstavlja precnik auto gume.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Metoda prima parametar u obliku Integer vrednosti i provera da li zadovoljava opseg da postane atribut precnik.
	 * 
	 * @param precnik Precnik auto gume koja se cuva kao Integer vrednost.
	 * @throws java.lang.RuntimeException u slucaju kada vrednost parametra ne upada u dozvoljeni opseg.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Metoda vraca Integer vrednost koja se cuva u atributu sirina.
	 * 
	 * @return Sirina auto gume koja se cuva kao Integer vrednost.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Metoda prima parametar u obliku Integer vrednosti i provera da li zadovoljava opseg da postane atribut sirina.
	 * 
	 * @param sirina Sirina auto gume koja se cuva kao Integer vrednost.
	 * @throws java.lang.RuntimeException u slucaju kada vrednost parametra ne upada u dozvoljeni opseg.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Metoda vraca Integer vrednost koja se cuva u atributu visina.
	 * 
	 * @return Visina auto gume koja se cuva kao Integer vrednost.
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Metoda prima parametar u obliku Integer vrednosti i provera da li zadovoljava opseg da postane atribut visina.
	 * 
	 * @param visina Visina auto gume koja se cuva kao Integer vrednost.
	 * @throws java.lang.RuntimeException u slucaju kada vrednost parametra ne upada u dozvoljeni opseg.
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Metoda koja vraca String vrednost koja predstavlja vrednosti svih parametara konkretnog objekta klase AutoGuma.
	 * 
	 * @return String vrednost koja predstvalja sve vrednosti parametara konkretne auto gume.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Metoda koja proverava da li su dva objekta klase AutoGuma jednakih vrednosti atributa.
	 * Metoda zakljucuje jednakost dva ovjekta na osnovu atributa markaModela, precnik, sirina i visina.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>Boolean vrednost true u slucaju da je prosledjeni objekat jednak onom nad kojim je pozvana metoda</li>
	 * 		<li>Boolean vrednost false u slucaju da prosledjeni objekat nije jednak onom nad kojim je pozvana metoda</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
