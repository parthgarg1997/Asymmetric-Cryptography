package Diffie_Hellman_key_exchange;
import java.util.Random;
import java.util.Scanner;

public class bob {
	public static void main(String[] args)
	{
	final int p=2147473697;//99761;
	final int g=9876543;//195;
	Random ran=new Random();
	Scanner scan=new Scanner(System.in);
	//System.out.println("choose the key");
	int pow=10000+ran.nextInt(150000);
	int B=modulo(g,pow,p);
	System.out.println(B);
	System.out.println("paste it in alice");
	int A=scan.nextInt();
	int s=modulo(A,pow,p);
	System.out.println("the private key that can be used is "+s);
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
