public class Parenthesage{
   
	public static Pile<Character> pileParenthesesOuvrantes;
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a re�u en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println(messageErreur + ". Attendu=" + attendu + " re�u=" + recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur + ". Attendu=" + attendu + " re�u=" + recu);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {

		assertEquals("test ko : (a+b)", true, verificationParenthesage("(a+b)")); 
		assertEquals("test ko : (a+b]", false, verificationParenthesage("(a+b]")); 
		assertEquals("test ko : (a+b", false, verificationParenthesage("(a+b"));
		assertEquals("test ko :  a+b)", false, verificationParenthesage("a+b)"));
		assertEquals("test ko : if(a==b||a==c){return (tab[i]-1)*2}", true, verificationParenthesage("if(a==b||a==c){return (tab[i]-1)*2}"));
		assertEquals("test ko : if(a==b||a==c{return (tab[i]-1)*2}", false,verificationParenthesage("if(a==b||a==c{return tab[i]-1}")); 
		assertEquals("test ko : if a==b||a==c){return (tab[i]-1)*2}", false, verificationParenthesage("if a==b||a==c){return tab[i]-1}"));
		assertEquals("test ko : if((a==b||a==c){return (tab[i]-1)*2}", false,verificationParenthesage("if((a==b||a==c){return tab[i]-1}"));
		assertEquals("test ko : if(a==b||a==c){return (tab[i)-1)*2}", false,verificationParenthesage("if(a==b||a==c){return tab[i)-1}"));
		assertEquals("test ko : if(a==b||a==c)[return (tab[i]-1)*2}", false,verificationParenthesage("if(a==b||a==c)[return tab[i]-1}"));
		assertEquals("test ko : if(a==b||a==c){return (tab[i]-1)*2}}", false,verificationParenthesage("if(a==b||a==c){return tab[i]-1}}"));	
		assertEquals("test ko : if((a==b||a==c){return (tab[i]-1)*2}", false,verificationParenthesage("if((a==b||a==c){return tab[i]-1}"));
		System.out.println("Tous les tests ont reussi!");
	}
	
	
	/**
	 * Vérifie que le parenthesage (crochet, accolade et parenthese) est correct dans un texte.
	 * @param texte
	 * @return Vrai si le parenthesage est correct, faux sinon.
	 */
	public static boolean verificationParenthesage(String texte) {
		pileParenthesesOuvrantes = new PileImpl<Character>(texte.length());
		for (int i = 0; i < texte.length(); i++) {
			char charATraiter = texte.charAt(i);
			char parenthesesFermantes = parentheseFermeeCorrespondante(charATraiter);
			if (charATraiter == '(' || charATraiter == '{' || charATraiter == '[') {
				pileParenthesesOuvrantes.push(parenthesesFermantes);
			} else {
				if ((charATraiter == ')' || charATraiter == '}' || charATraiter == ']')
						&& (pileParenthesesOuvrantes.estVide() || pileParenthesesOuvrantes.pop() != charATraiter))
					return false;
			}
		}
		if (!pileParenthesesOuvrantes.estVide())
			return false;
		return true;
	}

	/**
	 * Vérifie si le caractere est une parenthèse ouvrante. Recherche la parenthèse fermnante correspondante.
	 * @param charATraiter 
	 * @return La parenthese fermée correspondant à la parenthèse en paramètre
	 */
	private static char parentheseFermeeCorrespondante(char charATraiter) {
		char parenthesesFermantes = ' ';
		if (charATraiter == '(')
			parenthesesFermantes = ')';
		else {
			if (charATraiter == '{')
				parenthesesFermantes = '}';
			else {
				if (charATraiter == '[')
					parenthesesFermantes = ']';
			}
		}
		return parenthesesFermantes;
	}
}
