public class Consigne{

	private Pile<Casier> pileCasiersLibres;
	private Vecteur<Casier> vecteurCasiers;
	private int nombreCasiers;
	
	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public Consigne(int nombreCasiers){
		if (nombreCasiers <= 0) throw new IllegalArgumentException();
		this.nombreCasiers = nombreCasiers;
		this.pileCasiersLibres = new PileImpl<Casier>(nombreCasiers);
		this.vecteurCasiers = new VecteurImpl<Casier>(nombreCasiers);
		remplirPileVecteur(nombreCasiers);
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		return pileCasiersLibres.taille() > 0;
	}

	/**
	 * attribue un casier libre
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		if (motDePasse.equals("") || motDePasse == null)
			throw new IllegalArgumentException();
		if (!resteUnCasierLibre())
			return -1;
		Casier casierLibre = pileCasiersLibres.pop();
		casierLibre.setMotDePasse(motDePasse);
		return casierLibre.getNumero();
	}
	
	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le numero de casier existe et le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		if (numeroCasier >= 0 && numeroCasier < nombreCasiers
				&& vecteurCasiers.element(numeroCasier).getMotDePasse().equals(motDePasse)) {
			pileCasiersLibres.push(vecteurCasiers.element(numeroCasier));
			vecteurCasiers.element(numeroCasier).setMotDePasse("");
			return true;
		}
		return false;
	}
	
	private void remplirPileVecteur(int nombreCasiers) {
		for (int i = 0; i < nombreCasiers; i++) {
			Casier casier = new Casier(i);
			vecteurCasiers.ajoute(casier);
			pileCasiersLibres.push(casier);
		}
	}
}
