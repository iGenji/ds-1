
public class VecteurImpl<E> implements Vecteur<E>{
	
	private Object[] table;
	private int taille;

	public VecteurImpl() {
		this.table=new Object[16];
		this.taille=0;
	}

	public VecteurImpl(int taillePhysique) {
		if(taillePhysique<=0)
			throw new IllegalArgumentException("la taillePhysique ne peut etre negative ou nulle");
		this.table=new Object[taillePhysique];
		this.taille=0;
	}

	public boolean estVide() {
		return taille==0;
	}

	// taille logique
	public int taille() {
		return taille;
	}

	public String toString(){
		String aRenvoyer="";
		if(taille>0){
			aRenvoyer+=table[0];
			for (int i = 1; i < taille; i++) {
				aRenvoyer+=" "+table[i];
			}
		}
		return aRenvoyer;
	}

	private boolean rangValide(int rang){
		if(rang<0||rang>=taille)
			return false;
		return true;
	}

	private boolean rangValidePourAjout(int rang){
		if(rang<0||rang>taille)
			return false;
		return true;
	}

	public E element(int rang) throws VecteurOutException {
		if(!rangValide(rang))
			throw new VecteurOutException("rang invalide");
		return (E)table[rang];
	}

	public void insere(int rang, E element) throws VecteurOutException {
		if(!rangValidePourAjout(rang))
			throw new VecteurOutException("rang invalide pour ajout");
		if(taille == table.length){
			Object[] temp = new Object[table.length*2];
			for(int i = 0; i < taille; i++){
				temp[i]=table[i];
			}
			table=temp;
		}
		for(int i = taille-1; i >= rang; i--){
			table[i+1]=table[i];
		}
		taille++;
		table[rang]=element;
	}


	public void ajoute(E element) {
			insere(taille, element);
	}


	public E remplace(int rang, E element)throws VecteurOutException {
		if(!rangValide(rang))
			throw new VecteurOutException("rang invalide");
		E oARenvoyer = (E)table[rang];
		table[rang]=element;
		return oARenvoyer;
	}


	public E supprime(int rang) throws VecteurOutException {
		if(!rangValide(rang))
			throw new VecteurOutException("rang invalide");
		E oARenvoyer = (E)table[rang];
		for(int i = rang; i<taille-1;i++){
			table[i]=table[i+1];
		}
		taille--;
		return oARenvoyer;
	}	
}
