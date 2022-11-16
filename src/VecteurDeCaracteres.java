
public interface VecteurDeCaracteres {
	
	
	public boolean estVide();
	
	public int taille(); 
	
	public String toString();
	
	public char element(int rang)throws VecteurOutException;
	
	public void insere(int rang, char caractere)throws VecteurOutException;

	public void ajoute(char caractere); 
	
	public char remplace(int rang, char caractere)throws VecteurOutException;
	
	public char supprime(int rang)throws VecteurOutException;

}
