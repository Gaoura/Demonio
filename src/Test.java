import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short i = 1, j = 2;
		CaseActeur caze = new CaseActeur(i, j);
		Amazone act = new Amazone(caze);
		act.setBourse((short) 10);
		System.out.println(act);
		sc.close();
	}

}
