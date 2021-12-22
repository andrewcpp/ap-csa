
public class MainRandpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Randp rp = new Randp(15);
		for (int i = 0; i < 15; i++) {
			System.out.print(rp.nextInt() + " ");
		}
	}

}
