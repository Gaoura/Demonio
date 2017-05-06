public class Fisk extends Monstre {
	
//**********		CONSTRUCTEUR		**********

	public Fisk(CaseActeur c) {
		super(c);
		this.nom = "Fisk";
		this.representation = '€';
		this.vie_maximum = (short)(Math.random() * 6 + 4);
		this.vie_actuelle = this.vie_maximum;
		this.force = 1;
		this.experience_donnee = (short)(Math.random() * 5 + 1);
		this.or_donnee = (short)(Math.random() * 31 + 10);
	}

}
