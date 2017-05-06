public class Chikungunya extends Monstre {

//**********		CONSTRUCTEUR		**********
	
	public Chikungunya(CaseActeur c) {
		super(c);
		this.nom = "Chikungunya";
		this.representation = '%';
		this.vie_maximum = (short)(Math.random() * 5 + 4);
		this.vie_actuelle = this.vie_maximum;
		this.force = 4;
		this.experience_donnee = (short)(Math.random() * 5 + 1);
		this.or_donnee = (short)(Math.random() * 10 + 1);
	}

}
