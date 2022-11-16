public class CabinesDEssayage {

	private Pile<Integer> pileNumerosCabinesLibres;
	private int nombreCabines;
	
	/**
	 * construit nombreCabines libres
	 * La numerotation des cabines commence a 1
	 * @param nombreCabines : le nombre de cabines d'essayage
	 * @throws IllegalArgumentException si le nombre de cabines est negatif ou nul
	 */
	public CabinesDEssayage(int nombreCabines) {
		if (nombreCabines <= 0)
			throw new IllegalArgumentException();
		this.nombreCabines = nombreCabines;
		this.pileNumerosCabinesLibres = new PileImpl<Integer>(nombreCabines);
		for (int i = 1; i <= nombreCabines; i++) {
			pileNumerosCabinesLibres.push(i);
		}
	}
	
	/**
	 * renvoie le nombre de cabines libres
	 * @return le nombre de cabines libres
	 */
	public int nombreCabinesLibres() {
		return pileNumerosCabinesLibres.taille();
	}
	
	/**
	 * recherche une cabine libre
	 * @return le numero d'une cabine libre ou -1 si toutes les cabines sont occupees
	 */
	public int attribuerCabineLibre() {
		if (nombreCabinesLibres() == 0)
			return -1;
		return pileNumerosCabinesLibres.pop();
	}
	
	/**
	 * libere une cabine
	 * precondition : la cabine est occupee
	 * Votre methode ne doit pas verifier cette precondition
	 * @param numeroCabine le numero de la cabine a liberer
	 * @throws IllegalArgumentException si aucune cabine porte ce numero
	 */
	public void libererCabine(int numeroCabine) {
		if (numeroCabine <= 0 || numeroCabine > nombreCabines)
			throw new IllegalArgumentException();
		pileNumerosCabinesLibres.push(numeroCabine);
	}
}
