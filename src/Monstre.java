public abstract class Monstre extends Acteur {
	
//**********		ATTRIBUTS		**********	
	
	protected short experience_donnee;
	protected short or_donnee;
	
	
//**********		CONSTRUCTEUR		**********	
	
	public Monstre(CaseActeur c) {
		super(c);
	}

	
//**********		METHODES		**********
	
	public short getExperience_donnee() {
		return this.experience_donnee;
	}

	public void setExperience_donnee(short experience) {
		this.experience_donnee = experience;
	}


	public short getOr_donnee() {
		return this.or_donnee;
	}

	public void setOr_donnee(short or) {
		this.or_donnee = or;
	}


	public Heros seDeplace(Heros heros, Labyrinthe labyrinthe) {
		short memo_x = this.case_dans_le_labyrinthe.getAbscisse();
		short memo_y = this.case_dans_le_labyrinthe.getOrdonnee();
		short i = memo_x;
		short j = memo_y;
		boolean bouger = true;
		boolean recommencer;
		Heros h = null;
		
		/* 
		Recherche de la distance entre le monstre et le héros du labyrinthe 
		s'il y a 3 cases ou moins de distance entre les 2, le monstre se déplacera vers le héros
		sinon il ira dans une direction aléatoire
		*/
		short diff_x = (short) (heros.case_dans_le_labyrinthe.getAbscisse() - memo_x);
		short diff_y = (short) (heros.case_dans_le_labyrinthe.getOrdonnee() - memo_y);
		
		if(diff_x <= 3 && diff_x >= -3 && diff_y <= 3 && diff_y >= -3) {
			//si le heros est à 1 case de distance, la méthode renverra le heros pour enclencher le système de combat
			if (diff_x <= 1 && diff_x >= -1 && diff_y <= 1 && diff_y >= -1)
				h = heros;
			else { 
				if(diff_x > 0) {
					if(diff_y > 0) {
						i++;
						j++;
					}
					if(diff_y == 0)
						i++;
					if(diff_y < 0) {
						i++;
						j--;
					}
				}
				if(diff_x == 0) {
					if(diff_y > 0)
						j++;
					if(diff_y < 0)
						j--;
				}
				if(diff_x < 0) {
					if(diff_y > 0) {
						i--;
						j++;
					}
					if(diff_y == 0)
						i--;
					if(diff_y < 0) {
						i--;
						j--;
					}
				}
				if (labyrinthe.getCaseLabyrinthe(i, j) instanceof CaseLibre) {
					CaseActeur ca = new CaseActeur(i, j);
					ca.setActeur(this);
					this.case_dans_le_labyrinthe = ca;
					labyrinthe.setCaseLabyrinthe(memo_x, memo_y, new CaseLibre(memo_x, memo_y));
					labyrinthe.setCaseLabyrinthe(i, j, this.case_dans_le_labyrinthe);
				}
			}
		}	
		else {
			do {
				recommencer = false;
				byte direction = (byte)(Math.random() * 9 + 1);
				switch (direction) {
				case 1 :
					i++;
					j--;
					break;
				case 2 :	
					i++;
					break;	
				case 3 :	
					i++;
					j++;
					break;
				case 4 :	
					j--;
					break;
				case 5 :
					bouger = false;
					break;
				case 6 :	
					j++;
					break;
				case 7 :	
					i--;
					j--;
					break;
				case 8 :	
					i--;
					break;
				case 9 :	
					i--;
					j++;
					break;
				}
			
				
				if (bouger) {
					if (labyrinthe.getCaseLabyrinthe(i, j) instanceof Mur) {
						i = memo_x;
						j = memo_y;
						recommencer = true;
					}
					if (labyrinthe.getCaseLabyrinthe(i, j) instanceof CaseLibre) {
						CaseActeur ca = new CaseActeur(i, j);
						ca.setActeur(this);
						this.case_dans_le_labyrinthe = ca;
						labyrinthe.setCaseLabyrinthe(memo_x, memo_y, new CaseLibre(memo_x, memo_y));
						labyrinthe.setCaseLabyrinthe(i, j, this.case_dans_le_labyrinthe);
					}	
				}
			
			} while(recommencer);
		}
		return h;
	}

}
