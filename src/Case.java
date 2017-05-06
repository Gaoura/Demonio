public abstract class Case {

//**********		ATTRIBUTS		**********	

	private short x;
	private short y;


//**********		CONSTRUCTEUR		**********
	
	public Case(short i, short j) {
		this.x = i;
		this.y = j;
	}
	
	
//**********		METHODES		**********

	public abstract void afficheCase();
	
	
	public void setAbscisse(short i) {
		this.x = i;
	}
	
	public short getAbscisse() {
		return this.x;
	}

	
	public void setOrdonnee(short i) {
		this.y = i;
	}
	
	public short getOrdonnee() {
		return this.y;
	}
	
}
