public class GestionSalleExposition {

	private static Catalogue catalogue;
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		catalogue = new Catalogue();
		int choix;
		System.out.println("Gestion des oeuvres de la salle d'exposition...");
		do {
			System.out.println("\n1 ---> Ajouter une oeuvre");
			System.out.println("2 ---> Consulter une oeuvre");
			System.out.println("3 ---> Supprimer une oeuvre");
			System.out.println("4 ---> Afficher toutes les oeuvres");
			System.out.println("0 ---> Fin");
			System.out.print("\nTon choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				ajouterOeuvre();
				break;
			case 2:
				consulterOeuvre();
				break;
			case 3:
				supprimerOeuvre();
				break;
			case 4:
				afficherOeuvres();
				break;
			}
		} while (choix > 0 && choix < 5);
		System.out.println("Au revoir!\n");
	}

	public static void ajouterOeuvre() {
		System.out.println("Donnez la description de l'oeuvre : ");
		try {
			String description = scanner.next();
			catalogue.ajouter(description);
		} catch (Exception e) {
			System.out.println("Description invalide.");
		}
	}

	public static void consulterOeuvre() {
		System.out.println("Donnez le numero de l'oeuvre :");
		int numero = scanner.nextInt();
		try {
			String descriptionOeuvre = catalogue.consulter(numero);
			if (descriptionOeuvre == null) {
				System.out.println("Oeuvre non présente.");
			} else {
				System.out.println("Description : " + catalogue.consulter(numero));
			}
		} catch (Exception e) {
			System.out.println("Oeuvre" + numero + " pas presente.");
		}

	}

	public static void supprimerOeuvre() {
		System.out.println("Donnez le numero de l'oeuvre :");
		int numero = scanner.nextInt();
		try {
			if (catalogue.supprimer(numero) == null)
				System.out.println("Oeuvre " + numero + " pas presente.");
			else
				System.out.println("Oeuvre " + numero + " supprimee.");
		} catch (Exception e) {
			System.out.println("Oeuvre " + numero + " pas presente.");
		}
	}

	public static void afficherOeuvres() {
		if (catalogue.nombreOeuvres() == 0) {
			System.out.println("Aucune oeuvre presente.");
		} else {
			System.out.println(catalogue);
		}
	}
}
