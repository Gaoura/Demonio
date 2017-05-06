
public class Labyrinthe {
	
//**********		ATTRIBUTS		**********
	
	private Case labyrinthe[][];
	private short dim_x;
	private short dim_y;
	
	
//**********		CONSTRUCTEUR		**********	

	public Labyrinthe(short dx, short dy) {
		this.dim_x = dx;
		this.dim_y = dy;
		this.labyrinthe = new Case[dim_x][dim_y];
		
		for (short i = 0; i < this.dim_x; i++) {
			for (short j = 0; j < this.dim_y; j++) {
				if(i == 0 || 
				   j == 0 || 
				   i == (this.dim_x - 1) || 
				   j == (this.dim_y - 1))
					this.labyrinthe[i][j] = new Mur(i, j);
				else 
					this.labyrinthe[i][j] = new CaseLibre(i, j);
			}
		}
	}

	
//**********		METHODES		**********
	
	public void afficheLabyrinthe() {
		for(int i = 0; i < this.dim_x; i++) {
			for(int j = 0; j < this.dim_y; j++) {
				this.labyrinthe[i][j].afficheCase();
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
	public void placeMursAleatoires(int nb) {
		short x, y;
		
		if (nb >= (this.dim_x * this.dim_y))
			nb /= 3;
		for(int i = 0; i < nb; i++) {
			do {
				x = (short) (Math.random()*this.dim_x);
				y = (short) (Math.random()*this.dim_y);
			} while(this.labyrinthe[x][y] instanceof CaseOccupee);
			
			this.labyrinthe[x][y] = new Mur(x, y);
		}
	}
	
	public Case[][] getLabyrinthe() {
		return this.labyrinthe;
	}
	
	public Case getCaseLabyrinthe(short i, short j) {
		return this.labyrinthe[i][j];
	}
	
	public void setCaseLabyrinthe(short i, short j, Case c) {
		this.labyrinthe[i][j] = c;
	}
	
	public boolean estCaseLibre(int i, int j) {
		if(this.labyrinthe[i][j] instanceof CaseLibre)
			return true;
		else 
			return false;
	}
	
}
