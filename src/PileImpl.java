
public class PileImpl<E> implements Pile<E> {

	Object[] table;
	int taille; 

	public PileImpl(){
		table = new Object[4];
		taille = 0;
	}
	
	public PileImpl(int capacite){
		table = new Object[capacite];
		taille = 0;
	}

	public int taille(){
		return taille;
	}

	public boolean estVide(){
		return taille == 0;
	}

	public void push(E element){
		if(taille==table.length){
			Object[] temp = new Object[table.length*2];
			for(int i = 0;i<taille;i++) temp[i] = table[i];
			table = temp;
		}
		table[taille]=element;
		taille++;
	}


	public E pop() throws PileVideException{
		if(taille==0) throw new PileVideException();
		taille--;
		return (E) table[taille];
	}

	
	public E sommet()throws PileVideException{
		if(taille==0) throw new PileVideException();
		return (E) table[taille-1];
	}

}
