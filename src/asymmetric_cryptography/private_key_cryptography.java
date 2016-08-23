package asymmetric_cryptography;
import java.util.Scanner;
public class private_key_cryptography {
public static void main(String[] args)
{ int i=0;
 Scanner scan=new Scanner(System.in);
 int ch[]=new int[1000];
 final int d=380249;//private key 
	final int n=569477;//multiplication of two prime numbers 613 and 929
	int code[]=new int[1000];
	do{
		code[i]=scan.nextInt();
	   System.out.print((char)modulo(code[i],d,n));
	   i++;
	}while(code[i-1]!=0);
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

