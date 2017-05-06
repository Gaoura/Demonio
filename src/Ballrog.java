public class Ballrog extends Monstre {

//**********		CONSTRUCTEUR		**********

	public Ballrog(CaseActeur c) {
		super(c);
		this.nom = "Ballrog";
		this.representation = '¤';
		this.vie_maximum = 100;
		this.vie_actuelle = this.vie_maximum;
		this.force = 15;
		this.experience_donnee = (short)(Math.random() * 5 + 1);
		this.or_donnee = (short)(Math.random() * 51 + 150);
	}

}
