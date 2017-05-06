import java.util.Scanner;

public class Jeu {
	
	private static Labyrinthe laby;
	private static final short DIM_X = 40;
	private static final short DIM_Y = 40;
	private static Heros heros;
	private static short nbMonstresVivants = 5;
	private static Scanner sc = new Scanner(System.in);
	private static Lutin lutin1;
	private static Lutin lutin2;
	private static Orc orc1;
	private static Fisk fisk1;
	private static Ballrog ballrog; 
	
	private static void initialisation() {
		CaseActeur ca;		
		short px, py;
		laby = new Labyrinthe(DIM_X, DIM_Y);
		StringBuffer str_buffer_temp;
		char type_heros;
		boolean recommencer;
		
		System.out.println("\tBienvenue dans Demonio !\n");
		
		//Recherche d'une case où mettre le héros
		do {
			px = (short)(Math.random() * DIM_X);
			py = (short)(Math.random() * DIM_Y);
		} while(!(laby.estCaseLibre(px, py)));
		
		ca = new CaseActeur(px, py);
		
		//Création du héros
		System.out.println("Quel type de héros désirez-vous incarner pour cette aventure ?");
		System.out.println("Voici les différents types de héros possibles : ");
		System.out.println("\t1 - Guerrier");
		System.out.println("\t2 - Amazone");
		System.out.println("\t3 - Magicien");
		System.out.println("\t4 - Troubadour");
		
		do {
			System.out.print("\n-> Tapez le chiffre correspondant au type de héros désiré puis validez : ");
			str_buffer_temp = new StringBuffer(sc.nextLine());
			
			if(str_buffer_temp.length() == 0)
				recommencer = true;
			else {
				if(str_buffer_temp.length() > 1)
					recommencer = true;
				else {
					type_heros = str_buffer_temp.charAt(0);
					switch(type_heros) {
					case '1' :
						recommencer = false;
						heros = new Guerrier(ca);
						break;
					case '2' :
						recommencer = false;
						heros = new Amazone(ca);
						break;
					case '3' :
						recommencer = false;
						heros = new Magicien(ca);
						break;
					case '4' :
						recommencer = false;
						heros = new Troubadour(ca);
						break;
					default :
						recommencer = true;
						break;
					}
				}
			}
			
			if(recommencer)
				System.out.println("Nous n'avons pas compris votre choix");
		} while(recommencer);

			
		
		//Nommage du héros
		System.out.println("\n-> Comment voulez-vous nommer votre héros ? (20 caractères au maximum)");
		str_buffer_temp = new StringBuffer(sc.nextLine());
		if(str_buffer_temp.length() == 0)
			str_buffer_temp = str_buffer_temp.append("DefaultName");
		else if (str_buffer_temp.length() > 20)
				str_buffer_temp.delete(20, str_buffer_temp.length());
		heros.setNom(str_buffer_temp);
		
		laby.setCaseLabyrinthe(px, py, ca);
		
		//Création des montres
		do {
			px = (short)(Math.random() * DIM_X);
			py = (short)(Math.random() * DIM_Y);
		} while(!(laby.estCaseLibre(px, py)));
		ca = new CaseActeur(px, py);
		lutin1 = new Lutin(ca);
		laby.setCaseLabyrinthe(px, py, ca);
		
		do {
			px = (short)(Math.random() * DIM_X);
			py = (short)(Math.random() * DIM_Y);
		} while(!(laby.estCaseLibre(px, py)));
		ca = new CaseActeur(px, py);
		lutin2 = new Lutin(ca);
		laby.setCaseLabyrinthe(px, py, ca);
		
		do {
			px = (short)(Math.random() * DIM_X);
			py = (short)(Math.random() * DIM_Y);
		} while(!(laby.estCaseLibre(px, py)));
		ca = new CaseActeur(px, py);
		orc1 = new Orc(ca);
		laby.setCaseLabyrinthe(px, py, ca);
		
		do {
			px = (short)(Math.random() * DIM_X);
			py = (short)(Math.random() * DIM_Y);
		} while(!(laby.estCaseLibre(px, py)));
		ca = new CaseActeur(px, py);
		fisk1 = new Fisk(ca);
		laby.setCaseLabyrinthe(px, py, ca);
		
		do {
			px = (short)(Math.random() * DIM_X);
			py = (short)(Math.random() * DIM_Y);
		} while(!(laby.estCaseLibre(px, py)));
		ca = new CaseActeur(px, py);
		ballrog = new Ballrog(ca);
		laby.setCaseLabyrinthe(px, py, ca);
	}
	
	public static void nouveauTour() {
		char dir;
		boolean recommencer;
		StringBuffer str_buffer_temp;
		Monstre m;
		Heros h;		

		System.out.println("\tChoix possibles :\n");
		System.out.println("\t  7   8   9");
		System.out.println("\t      ^     ");
		System.out.println("\t  4 < 5 > 6");
		System.out.println("\t      v     ");
		System.out.println("\t  1   2   3\n");
		
		do {
			System.out.print("\n-> Dans quelle direction voulez-vous aller ? ");
			str_buffer_temp = new StringBuffer(sc.nextLine());
			if (str_buffer_temp.length() == 0) {
				dir = '5'; 	//On initialise la variable au cas où on sortirait de la boucle sans qu'elle soit initialisée
				recommencer = true;
			}
			else {
				if (str_buffer_temp.length() > 1 ) {
					dir = '5'; 	//On initialise la variable au cas où on sortirait de la boucle sans qu'elle soit initialisée
					recommencer = true;
				}
				else { 
					dir = str_buffer_temp.charAt(0);
					if( dir == '1' || dir == '2' || dir == '3' || dir == '4' || dir == '5' ||
						dir == '6' || dir == '7' || dir == '8' || dir == '9')
						recommencer = false;
					else recommencer = true;
				}
			}
			
			if(recommencer)
				System.out.println("Nous n'avons pas compris votre choix");
		} while(recommencer);
		
		System.out.println();
		m = heros.seDeplace(dir, laby);
		if(m != null)
			nouveauCombat(m);	
		
		if(!(lutin1.estMort())) {
			h = lutin1.seDeplace(heros, laby);
			if(h != null)
				nouveauCombat(lutin1);
		}
		
		if(!(lutin2.estMort())) {
			h = lutin2.seDeplace(heros, laby);
			if(h != null)
				nouveauCombat(lutin2);
		}
		
		if(!(fisk1.estMort())) {
			h = fisk1.seDeplace(heros, laby);
			if(h != null)
				nouveauCombat(fisk1);
		}
		
		if(!(orc1.estMort())) {
			h = orc1.seDeplace(heros, laby);
			if(h != null)
				nouveauCombat(orc1);
		}
		
		if(!(ballrog.estMort())) {
			h = ballrog.seDeplace(heros, laby);
			if(h != null)
				nouveauCombat(ballrog);
		}
		
		laby.afficheLabyrinthe();
	}
	
	public static void nouveauCombat(Monstre m) {
		short memo_x = heros.getCase_dans_le_labyrinthe().getAbscisse();
		short memo_y = heros.getCase_dans_le_labyrinthe().getOrdonnee();
		short i = m.getCase_dans_le_labyrinthe().getAbscisse();
		short j = m.getCase_dans_le_labyrinthe().getOrdonnee();
		
		System.out.println("\n\nUn combat s'engage entre " + heros.getNom() + " et un " + m.getNom() + " !");
		System.out.println("Vie de " + heros.getNom() + " : " + heros.getVie());
		System.out.println("Vie du " + m.getNom() + " : " + m.getVie() + "\n");
		while(!(m.estMort()) && !(heros.estMort())) {
			if(!(heros.estMort())) {
				System.out.println();
				heros.attaque(m);
				System.out.println("Vie de " + m.getNom() + " : " + m.getVie());
			}
			else System.out.println(heros.getNom() + " est mort !");
			if(!(m.estMort())) {
				System.out.println();
				m.attaque(heros);
				System.out.println("Vie de " + heros.getNom() + " : " + heros.getVie());
			}
			else System.out.println(m.getNom() + " est mort !");
		}
		
		//si le monstre est battu par le heros
		if(m.estMort()) {
			nbMonstresVivants = (short)(nbMonstresVivants - 1);
			System.out.println("\nFélicitations ! " + heros.getNom() + " a battu un " + m.getNom() + " !");
			System.out.println("Sa vie restante est de " + heros.getVie());
			System.out.println(heros.getNom() + " gagne " + m.getExperience_donnee() + " points d'expérience et " + m.getOr_donnee() + " pièces d'or ! \n\n" );
			
			heros.setExperience(m.getExperience_donnee());
			heros.setBourse(m.getOr_donnee());
			
			heros.setCase_dans_le_labyrinthe(m.getCase_dans_le_labyrinthe());
			((CaseActeur) (heros.getCase_dans_le_labyrinthe()) ).setActeur(heros);
			
			laby.setCaseLabyrinthe(memo_x, memo_y, new CaseLibre(memo_x, memo_y));
			laby.setCaseLabyrinthe(i, j, heros.getCase_dans_le_labyrinthe());
			
		}
		
		//si le heros est battu par le monstre
		if(heros.estMort()) {
			System.out.println("Dommage ! " + heros.getNom() + " a été battu par un " + m.getNom() + " !");
			System.out.println("\n\n\n\tGAME OVER ");
		}
	}
	public static void main(String[] args) {
		initialisation();
		System.out.println("Bien ! Votre héros se prépare désormais à arpenter le labyrinthe, voici ses caractéristiques :");
		System.out.println(heros);
		System.out.println("\n\n");
		laby.afficheLabyrinthe();
		
		while(!(heros.estMort()) && nbMonstresVivants != 0) {
			nouveauTour();
		}
		if (nbMonstresVivants == 0) {
			System.out.println("Bravo vous avez fini cette partie !");
		}
		
		sc.close();
	}

}
