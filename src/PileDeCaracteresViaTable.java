public class PileDeCaracteresViaTable implements PileDeCaracteres{

	private char[] table; // ne mofifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; // ne mofifiez pas cet identifiant, va servir pour les tests

	/**
	 * construit une pile vide avec une capacite de depart de 4 caracteres
	 */
	public PileDeCaracteresViaTable() {
		table = new char[4];
		nombreCaracteres = 0;
	}

	/**
	 * construit une pile vide
	 * @param capacite la capacite de depart de la pile
	 */
	public PileDeCaracteresViaTable(int capacite) {
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	/**
	 * renvoie le nombre de caracteres qui se trouvent sur la pile
	 * @return nombre de caracteres
	 */
	public int taille() {
		return nombreCaracteres;
	}
	
	/**
	 * verifie la presence de caracteres sue la pile
	 * @return true si la pile est vide, false sinon
	 */
	public boolean estVide() {
		return nombreCaracteres == 0;
	}

	/**
	 * ajoute le caractere c sur la pile
	 * Si la table est pleine, il faut doubler sa capacite
	 * @param caractere le caractere a ajouter
	 */	
	public void push(char c) {
		if (nombreCaracteres == table.length)
			doubleTable();
		table[nombreCaracteres] = c;
		nombreCaracteres++;
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char pop() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		nombreCaracteres--;
		return (table[nombreCaracteres]);
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile sans l'enlever de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return (table[nombreCaracteres - 1]);
	}

	private void doubleTable() {
		char[] temp = new char[table.length * 2];
		for (int i = 0; i < table.length; i++) {
			temp[i] = table[i];
		}
		table = temp;
	}
}
