public class Magicien extends Heros {

//**********		CONSTRUCTEUR		**********	
	
	public Magicien(CaseActeur c) {
		super(c);
		this.representation = '§';
		this.vie_maximum = 7;
		this.vie_actuelle = this.vie_maximum;
		this.force = 4;
		this.experience = 0;	
	}
}
