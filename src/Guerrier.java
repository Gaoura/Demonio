public class Guerrier extends Heros {
	
//**********		CONSTRUCTEUR		**********
	
	public Guerrier(CaseActeur c) {
		super(c);
		this.representation = '£';
		this.vie_maximum = 11;
		this.vie_actuelle = this.vie_maximum;
		this.force = 10;
	}

	public void attaque(Acteur act) {
		System.out.println(this.nom + " attaque " + act.nom);
		short coup = (short) (Math.random() * (force*0.5 + 1) + (force*0.5));
		System.out.println(this.nom + " inflige " + coup + " dégâts à " + act.nom);
		act.setVieActuelle((short)(act.getVieActuelle() - coup));
	}
	
}
