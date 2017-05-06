public class Lutin extends Monstre {

//**********		CONSTRUCTEUR		**********

	public Lutin(CaseActeur c) {
		super(c);
		this.nom = "Lutin";
		this.representation = 'L';
		this.vie_maximum = (short)(Math.random() * 5 + 1);
		this.vie_actuelle = this.vie_maximum;
		this.force = 2;
		this.experience_donnee = (short)(Math.random() * 5 + 1);
		this.or_donnee = 0;
	}

}
