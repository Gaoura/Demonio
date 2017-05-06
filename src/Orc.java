public class Orc extends Monstre {

//**********		CONSTRUCTEUR		**********

	public Orc(CaseActeur c) {
		super(c);
		this.nom = "Orc";
		this.representation = 'ø';
		this.vie_maximum = (short)(Math.random() * 7 + 4);
		this.vie_actuelle = this.vie_maximum;
		this.force = 0;
		this.experience_donnee = (short)(Math.random() * 3 + 1);
		this.or_donnee = (short)(Math.random() * 5 + 1);
	}

}
