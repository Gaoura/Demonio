public class Troubadour extends Heros {

//**********		CONSTRUCTEUR		**********
	
	public Troubadour(CaseActeur c) {
		super(c);
		this.representation = '&';
		this.vie_maximum = 8;
		this.vie_actuelle = this.vie_maximum;
		this.force = 4;
		this.experience = 0;		
	}

}
