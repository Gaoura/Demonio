public abstract class Acteur {

//**********		ATTRIBUTS		**********

	protected String nom;
	protected char representation;
	protected short vie_actuelle;
	protected short vie_maximum;
	protected short force;
	protected Case case_dans_le_labyrinthe;


//**********		CONSTRUCTEURS		**********

	public Acteur(CaseActeur c) {
		this.case_dans_le_labyrinthe = c;
		c.setActeur(this);
	}


//**********		METHODES		**********

	public String getNom() {
		return this.nom;
	}

	public void setNom(String n) {
		this.nom = n;
	}

	public void setNom(StringBuffer n) {
		this.nom = n.toString();
	}


	public char getRepresentation() {
		return this.representation;
	}

	public void setRepresentation(char r) {
		this.representation = r;
	}


	public short getVieActuelle() {
		return this.vie_actuelle;
	}

	public void setVieActuelle(short vie_actuelle) {
		this.vie_actuelle = vie_actuelle;
	}


	public short getVieMaximum() {
		return this.vie_maximum;
	}

	public void setVieMaximum(short vie_maximum) {
		this.vie_maximum = vie_maximum;
	}

	public Case getCase_dans_le_labyrinthe() {
		return case_dans_le_labyrinthe;
	}


	public void setCase_dans_le_labyrinthe(Case case_dans_le_labyrinthe) {
		this.case_dans_le_labyrinthe = case_dans_le_labyrinthe;
	}


	//Méthode qui servira seulement à afficher : vie_actuelle/vie_maximum
	public String getVie() {
		return (this.vie_actuelle + "/" + this.vie_maximum);
	}


	public short getForce() {
		return this.force;
	}

	public void setForce(short force) {
		this.force = force;
	}


	public boolean estMort() {
		if (this.vie_actuelle <= 0)
			return true;
		else return false;
	}

	public void attaque(Acteur act) {
		System.out.println(this.nom + " attaque " + act.nom);
		short coup = (short) (Math.random() * (this.force*0.5 + 1) + (this.force*0.5));
		System.out.println(this.nom + " inflige " + coup + " dégâts à " + act.nom);
		act.setVieActuelle((short)(act.getVieActuelle() - coup));
	}

	public String toString() {
		return ("\t**** Caractéristiques de " + this.nom + " ****\n" +
				"\n\tReprésentation dans le labyrinthe : " + this.representation +
				"\n\tVie : " + this.getVie() +
				"\n\tForce : " + this.force);
	}

}
