public abstract class Heros extends Acteur {
	
//**********		ATTRIBUT		**********	

	protected short bourse;
	protected short experience;
	protected short experience_max;
	protected short niveau;

	
//**********		CONSTRUCTEUR		**********	
	
	public Heros(CaseActeur c) {
		super(c);
		this.bourse = 0;
		this.experience = 0;
		this.experience_max = 100;
		this.niveau = 1;
	}

	
//**********		METHODES		**********
	
	public short getBourse() {
		return this.bourse;
	}

	public void setBourse(short or) {
		this.bourse = (short) (this.bourse + or);
	}
	

	public short getExperience() {
		return this.experience;
	}

	public void setExperience(short xp) {
		if(this.niveau < 50)
			this.experience = (short) (this.experience + xp);
			setNiveau();
	}


	public short getNiveau() {
		return niveau;
	}

	public void setNiveau() {
		if(this.experience >= this.experience_max) {
			this.niveau++;
			System.out.println("\nFélicitations ! " + this.nom + " gagne un niveau !");
			System.out.println(this.nom + " est maintenant niveau " + this.niveau);
			this.experience = (short) (this.experience - this.experience_max);
			this.experience_max = (short) (this.niveau * 50 + 50); 
			
			if(this instanceof Amazone) {
				this.force++;
				if((this.niveau % 2) == 0 )
					this.vie_maximum++;
			}
			if(this instanceof Guerrier) {
				this.force++;
				this.vie_maximum++;
			}
			if(this instanceof Magicien) {
				if((this.niveau % 2) == 0 ) {
					this.vie_maximum++;
					this.force++;
				}
			}
			if(this instanceof Troubadour) {
				this.vie_maximum++;
				if((this.niveau % 2) == 0 )
					this.force++;
			}
			
			//restauration de 50% de la vie max du heros
			if((this.vie_actuelle + 0.5 * this.vie_maximum) >= this.vie_maximum)
				this.vie_actuelle = vie_maximum;
			else 
				this.vie_actuelle = (short) (this.vie_actuelle + 0.5 * this.vie_maximum);
			
		}
	}


	public Monstre seDeplace(char direction, Labyrinthe labyrinthe) {
		short memo_x = this.case_dans_le_labyrinthe.getAbscisse();
		short memo_y = this.case_dans_le_labyrinthe.getOrdonnee();
		short i = memo_x;
		short j = memo_y;
		boolean bouger = true;
		Monstre m = null;
		
		switch (direction) {
		case '1' :
			i++;
			j--;
			break;
		case '2' :	
			i++;
			break;	
		case '3' :	
			i++;
			j++;
			break;
		case '4' :	
			j--;
			break;
		case '5' :
			bouger = false;
			break;
		case '6' :	
			j++;
			break;
		case '7' :	
			i--;
			j--;
			break;
		case '8' :	
			i--;
			break;
		case '9' :	
			i--;
			j++;
			break;
		}
			
		if (bouger) {
			if (labyrinthe.getCaseLabyrinthe(i, j) instanceof Mur) {
				System.out.println(" /!\\ Un mur vous empêche d'aller par là ! /!\\ \n");
			}
			if (labyrinthe.getCaseLabyrinthe(i, j) instanceof CaseActeur) {
				if(((CaseActeur)(labyrinthe.getCaseLabyrinthe(i, j))).getActeur() instanceof Monstre)
					//si le heros rencontre un monstre là où il veut aller, la méthode renverra le monstre pour enclencher le système de combat
					m = (Monstre) (((CaseActeur)(labyrinthe.getCaseLabyrinthe(i, j))).getActeur());
			}
			if (labyrinthe.getCaseLabyrinthe(i, j) instanceof CaseLibre) {
				CaseActeur ca = new CaseActeur(i, j);
				ca.setActeur(this);
				this.case_dans_le_labyrinthe = ca;
				labyrinthe.setCaseLabyrinthe(memo_x, memo_y, new CaseLibre(memo_x, memo_y));
				labyrinthe.setCaseLabyrinthe(i, j, this.case_dans_le_labyrinthe);
			}
		}
		return m;
	}

	public String toString() {
		return (super.toString() +
				"\n\tExpérience : " + this.experience + "/" + this.experience_max +
				"\n\tPossède " + this.bourse + " pièces d'or");
	}
}
