
public class TestCatalogue {
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);			
		}
	}
	
	
	
	public static void main(String[] args) {
		Catalogue c = new Catalogue();
		assertEquals("test 1 : consulter dans catalogue vide", null, c.consulter(5));
		assertEquals("test 2 : ajout o0 dans catalogue vide", 0, c.ajouter("o0"));
		assertEquals("test 3 : nombre oeuvres dans catalogue qui contient o0", 1, c.nombreOeuvres());
		assertEquals("test 4 : ajout o1 dans catalogue qui contient o0", 1, c.ajouter("o1"));
		assertEquals("test 5 : nombre oeuvres dans catalogue qui contient o0 et o1", 2, c.nombreOeuvres());
		assertEquals("test 6 : ajout o2 dans catalogue qui contient o0 et o1", 2, c.ajouter("o2"));
		assertEquals("test 7 : consulter oeuvre numero 2", "o2", c.consulter(2));
		assertEquals("test 8 : supprimer oeuvre numero 1", "o1", c.supprimer(1));
		assertEquals("test 9 : consulter oeuvre numero 2", "o2", c.consulter(2));
		assertEquals("test 10 : nombre oeuvres dans catalogue qui contient o0 et o2", 2, c.nombreOeuvres());
		assertEquals("test 11 : supprimer oeuvre numero 1", null, c.supprimer(1));
		assertEquals("test 12 : nombre oeuvres dans catalogue qui contient o0 et o2", 2, c.nombreOeuvres());
		assertEquals("test 13 : ajout nvo1 dans catalogue qui contient o0 et o2", 1, c.ajouter("nvo1"));
		assertEquals("test 14 : ajout o3 dans catalogue qui contient o0 nvo1 et o2", 3, c.ajouter("o3"));
		assertEquals("test 15 : nombre oeuvres dans catalogue qui contient o0 nvo1 o2 et o3", 4, c.nombreOeuvres());
		assertEquals("test 16 : supprimer oeuvre numero 1","nvo1", c.supprimer(1));
		assertEquals("test 17 : supprimer oeuvre numero 2","o2", c.supprimer(2));
		assertEquals("test 18 : supprimer oeuvre numero 2",null, c.supprimer(2));
		assertEquals("test 19 : supprimer oeuvre numero 2",null, c.supprimer(2));
		assertEquals("test 20 : ajout nvo2 dans catalogue qui contient o0 et o3", 2, c.ajouter("nvo2"));
		assertEquals("test 21 : nombre oeuvres dans catalogue qui contient o0 nvo2 et o3", 3, c.nombreOeuvres());
		assertEquals("test 22 : ajout x dans catalogue qui contient o0 nvo2 et o3", 1, c.ajouter("x"));
		System.out.println("tous les tests proposes ont reussis");
	}
}
