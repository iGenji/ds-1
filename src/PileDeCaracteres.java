// interface pile de caracteres

public interface PileDeCaracteres {

	/**
	 * renvoie le nombre de caracteres qui se trouvent sur la pile
	 * @return nombre de caracteres
	 */
	public int taille();


	/**
	 * verifie la presence de caracteres sue la pile
	 * @return true si la pile est vide, false sinon
	 */
	public boolean estVide();


	/**
	 * ajoute le caractere c sur la pile
	 * @param caractere le caractere a ajouter
	 */
	public void push(char caractere);



	/**
	 * renvoie le caractere qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char pop() throws PileVideException;


	/**
	 * renvoie le caractere qui se trouve au sommet de la pile sans l'enlever de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char sommet()throws PileVideException;




} // interface
