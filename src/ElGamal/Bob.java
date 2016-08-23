package ElGamal;

import java.util.Random;
import java.util.Scanner;

public class Bob {
	public static void main(String[] args)
	{
	final int p=2147473697;
	final int g=9876543;
	Random ran=new Random();
	Scanner scan=new Scanner(System.in);
	int pow=10000+ran.nextInt(2147463696);
	int B=modulo(g,pow,p);
	System.out.println(B);
	System.out.println("paste it in alice");
	int A=scan.nextInt();
	int s=modulo(A,pow,p);
	System.out.println(s);
	System.out.println("enter your Message");
	String ln;
	String ch=scan.nextLine();
	ln=scan.nextLine();
	int sLength=ln.length();
	System.out.println("the encrypted message that can be used is ");
	for(int i=0;i<sLength;i++)
	{ 
	long o=(s*((long)(ln.charAt(i))%p))%p;
	System.out.println(o);
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
	        b/= 2;
	    }
	    return (int) x%c;
	}
}
