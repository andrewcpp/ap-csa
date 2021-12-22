import java.math.BigInteger;

public class FastExponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger x = new BigInteger("2");
		System.out.println(fastExpt(x, 100));
	}
	
	public static BigInteger fastExpt(BigInteger b, int n) {
		BigInteger product = new BigInteger("1");
		if (n == 0)
			return new BigInteger("1");
		while (n > 0) {
			if (n % 2 == 0) {
				b = b.multiply(b);
				n /= 2;
			} else {
				n -= 1;
				product = product.multiply(b);
			}
		}
		return product;
	}

}
