public class CaseActeur extends CaseOccupee {

//**********		ATTRIBUTS		**********	

	private Acteur acteur;
	
	
//**********		CONSTRUCTEUR		**********	
	
	public CaseActeur(short i, short j) {
		super(i, j);
	}

	
//**********		METHODES		**********
	
	public void afficheCase() {
		System.out.print(acteur.getRepresentation());
	}
	
	public void setActeur(Acteur act) {
		acteur = act;
	}
	
	public Acteur getActeur() {
		return acteur;
	}

}
