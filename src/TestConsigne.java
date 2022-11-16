
public class TestConsigne {

	public static void main(String[] args) {

		Consigne consigne = new Consigne(3);
		System.out.println("Les tests se font avec une consigne comportant 3 casiers");
		System.out.println("Vous devez verifier les resultats qui s'affichent");
		System.out.println("\ntest 1 : 3 casiers de libre sur les 3");
		System.out.println("casiers libres? " + consigne.resteUnCasierLibre());

		System.out.println("\ntest 2 : 4 attributions");
		System.out.println("consigne.attribuerCasier(mdpa) " + consigne.attribuerCasierLibre("mdpa"));
		System.out.println("consigne.attribuerCasier(mdpb) " + consigne.attribuerCasierLibre("mdpb"));
		System.out.println("consigne.attribuerCasier(mdpc) " + consigne.attribuerCasierLibre("mdpc"));
		System.out.println("casiers libres? " + consigne.resteUnCasierLibre());
		System.out.println("consigne.attribuerCasier(mdpx)" + consigne.attribuerCasierLibre("mdpx"));

		System.out.println("\ntest 3 : ouverture mauvais numeros de casier");
		System.out.println("consigne.ouvrirCasier(-1, blabla) " + consigne.libererCasier(-1, "blabla"));
		System.out.println("consigne.ouvrirCasier(3, blabla) " + consigne.libererCasier(3, "blabla"));
		System.out.println("consigne.ouvrirCasier(4, blabla) " + consigne.libererCasier(4, "blabla"));

		System.out.println("\ntest 4 : ouverture casier mdp correct");
		System.out.println("consigne.ouvrirCasier(2, mdpa) " + consigne.libererCasier(2, "mdpa"));

		System.out.println("\ntest 5 : ouverture casier mdp incorrect");
		System.out.println("consigne.ouvrirCasier(1, mdpa) " + consigne.libererCasier(1, "mdpa"));

		System.out.println("\ntest 6 : ouverture casier juste libere, mdp correct");
		System.out.println("consigne.ouvrirCasier(1, mdpa) " + consigne.libererCasier(2, "mdpa"));

		System.out.println("\ntest 7 : ouverture tous les casiers ordres non ordonnes");
		System.out.println("consigne.attribuerCasier(mdpa) " + consigne.attribuerCasierLibre("mdpa"));
		System.out.println("casiers libres? " + consigne.resteUnCasierLibre());
		System.out.println("consigne.ouvrirCasier(1, mdpb) " + consigne.libererCasier(1, "mdpb"));
		System.out.println("consigne.ouvrirCasier(0, mdpc) " + consigne.libererCasier(0, "mdpc"));
		System.out.println("consigne.ouvrirCasier(2, mdpa) " + consigne.libererCasier(2, "mdpa"));
		System.out.println("casiers libres? " + consigne.resteUnCasierLibre());
	}
}
