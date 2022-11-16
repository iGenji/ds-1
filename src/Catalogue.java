public class Catalogue {
	
	private Pile<Integer> placesLibres;
	private Vecteur<String> oeuvresExposees;
	
	/**
	 * construit un catalogue vide
	 */
	public Catalogue() {
		placesLibres = new PileImpl<Integer>();
		oeuvresExposees = new VecteurImpl<String>();
	}

	/**
	 * renvoie le nombre d'oeuvres contenues dans le catalogue
	 * @return le nombre d'oeuvres contenues dans le catalogue
	 */
	public int nombreOeuvres() {
		return oeuvresExposees.taille() - placesLibres.taille();
	}

	/**
	 * ajoute une oeuvre dans le catalogue
	 * precondition : l'oeuvre n'y est pas encore
	 * Votre methode ne doit pas faire cette verification!
	 * @param oeuvre l'oeuvre a ajouter
	 * @return le numero de l'oeuvre ajoutee
	 * @throws IllegalArgumentException si l'oeuvre est vide ou null
	 */
	public int ajouter(String oeuvre) {
		if (oeuvre == null || oeuvre.equals(""))
			throw new IllegalArgumentException();
		int rangAjout;
		if (placesLibres.estVide()) {
			rangAjout = oeuvresExposees.taille();
			oeuvresExposees.ajoute(oeuvre);
		} else {
			rangAjout = placesLibres.pop();
			oeuvresExposees.remplace(rangAjout, oeuvre);
		}
		return rangAjout;
	}

	/**
	 * renvoie l'oeuvre correspondante au numero passe en parametre
	 * @param numeroOeuvre le numero de l'oeuvre recherchee
	 * @return l'oeuvre ou null si le numeroOeuvre ne correspond a aucune oeuvre actuellement exposee 
	 */
	public String consulter(int numeroOeuvre) {
		if (numeroOeuvre > nombreOeuvres())
			return null;
		return oeuvresExposees.element(numeroOeuvre);
	}

	/**
	 * supprime l'oeuvre correspondante au numero passe en parametre
	 * @param numeroOeuvre le numero de l'oeuvre a supprimer
	 * @return l'oeuvre ou null si le numeroOeuvre ne correspond a aucune oeuvre actuellement exposee 
	 */
	public String supprimer(int numero0euvre) {
		String nomOeuvre = consulter(numero0euvre);
		if (nomOeuvre == null)
			return null;
		oeuvresExposees.remplace(numero0euvre, null);
		placesLibres.push(numero0euvre);
		return nomOeuvre;
	}
	
	/**
	 * renvoie un String avec les oeuvres existantes (pas de null!)
	 * Les numeros et les descriptifs doivent apparaitre 
	 */
	public String toString() {
		String texte = "";
		for (int i = 0; i < oeuvresExposees.taille(); i++) {
			String oeuvreCourrante = consulter(i);
			if (oeuvreCourrante != null)
				texte += "\nNumero : " + i + " Description : " + oeuvreCourrante + " ";
		}
		return texte;
	}
}
