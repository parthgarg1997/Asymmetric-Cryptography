package ElGamal;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Alice {
	public static void main(String[] args)
	{

	final int p=2147473697;//99761;////761;
	final int g=9876543;//;//195;//6;
	int i=0;
	String str="";
	Random ran=new Random();
	Scanner scan=new Scanner(System.in);
	int pow=10000+ran.nextInt(2147463696);
	int A=modulo(g,pow,p);
	System.out.println(A);
	System.out.println("paste it in bob");
	int B=scan.nextInt();
	int s=modulo(B,pow,p);
	System.out.println(s);
	System.out.println("enter your code");
	int code[]=new int[1000];
	
	do{
		code[i]=scan.nextInt();
		if(code[i]==0)
		{
			break;
		}
	long f=solve(p,s);
	str=str+(char)((f*((long)(code[i])%p))%p);
	//System.out.print((char)((f*((long)(code[i])%p))%p));
	i++;
	}while(i<1000);
	System.out.println(str);
	System.out.println("is the decrypted message");
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
	public static long solve(long x,long y) {
	    BigInteger bi1, bi2, bi3;
	    bi1 = new BigInteger(Long.toString(y));
	    bi2 = new BigInteger(Long.toString(x));
	bi3 = bi1.modInverse(bi2);
	return (bi3.longValue());
	}
}