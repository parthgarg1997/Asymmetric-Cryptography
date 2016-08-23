package asymmetric_cryptography;
import java.util.Scanner;
public class rsa_public_key {

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		String line=scan.nextLine();
		int sLength=line.length();
		final int e=233;
		final int n=569477;
		long code[]=new long[sLength];
		int i;
		for(i=0;i<sLength;i++)
		{ 
			code[i]=modulo((int)line.charAt(i),e,n);//to find m^e%n
			System.out.println(code[i]);
		}
		System.out.println(0);
		
	}
	static int modulo(int a,int b,int c) {
	    long x=1;
	    long y=a;
	    while(b > 0){
	        if(b%2 == 1){
	            x=(x*y)%c;
	        }
	        
	        y = (y*y)%c; // squaring the base
	        b /= 2;
	    }
	    return (int) x%c;
	}
}
