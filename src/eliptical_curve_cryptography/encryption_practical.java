package eliptical_curve_cryptography;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Random;
public class encryption_practical {
	public static long a=2;
	public static int m=121993;
	public static long g1=47694,g2=1;
	public static void main(String args[])
	{  
		long c1[]=new long[2];//c1=k*p chipser text
	   long c2[]=new long[2];
	   long k_q[]=new long[2];
	   long q[]={73704,39070};
	   Random ram=new Random();
	   Scanner scan=new Scanner(System.in);
	   String str;
	   System.out.println("enter your message");
        str=scan.nextLine();
        int str_ln=str.length();
        if(str_ln%2==1)
        {
        	str=str+'.';
        	str_ln=str.length();
        }
        for(int b=0;b<str_ln;b+=2)
        {
	       int k=5000+ram.nextInt(5000);
		//System.out.println("enter the x coordinate of message");
		//String line=scan.nextLine();
		int Mx=(int)str.charAt(b);
		//System.out.println("enter the y coordinate of message");
		int My=(int)str.charAt(b+1);
		c1=multiplication(g1,g2,k,m);
		k_q=multiplication(q[0],q[1],k,m);
		c2=addition(Mx,k_q[0],My,k_q[1],m);
		//System.out.println("enter this message to bob");
		System.out.println(c1[0]+" "+c1[1]);
		System.out.println(c2[0]+" "+c2[1]);
        }
        System.out.println(0);
	}
	public static long[] addition(long X ,long x_,long Y,long y_,long q)
	{   long X_,Y_;
	   long ans[]=new long[2];
		try{
			long j=solve(q,(X-x_));	
			/*if(j<0)
			{
				j=q+j;
			}*/
				long s=((Y-y_)*j)%q;
				 X_=(s*s-(X+x_))%m;
				//if(X_<0)
					//X_=q+X_;
				 Y_=(s*(X-X_)-Y)%m;
				//if(Y_<0)
					//Y_=q+Y_;
				}
				catch(Exception e)
			      {
				X_=0;Y_=0;
			      }
		ans[0]=X_;ans[1]=Y_;
		return ans;
	}
	public static long[] multiplication(long x,long y,int k,long q)
	{  long ans[]=new long[2];
		int i;//10,6
		//long a=2;
		long x_=x,y_=y;
	     long X=0,Y=0;
		int breakpoint=234234243;
		long points[][]=new long[k][2];
		points[0][0]=x_;
		points[0][1]=y_;
		for(i=2;i<=k;i++)
		{ 
			if(i==2)
			{long j=solve(q,2*y);
			
			/*if(j<0)
			{
				j=q+j;
			}*/
			long s=((3*x*x+a)*j)%q;
			 X=(s*s-2*x)%q;
			 Y=(s*(x-X)-y)%q;//7,11 13
			//if(Y<0)
				//Y=q+Y;
			}
			else
			{
				try{
			long j=solve(q,(X-x_));	
			/*if(j<0)
			{
				j=q+j;
			}*/
				long s=((Y-y_)*j)%q;
				long X_=(s*s-(X+x_))%m;
				//if(X_<0)
					//X_=q+X_;
				long Y_=(s*(X-X_)-Y)%m;
				//if(Y_<0)
					//Y_=q+Y_;
				
				x=X;y=Y;
				X=X_;Y=Y_;
				}
				catch(Exception e)
			      {
					breakpoint=i;
				break;
			      }
				}
				points[i-1][0]=X;
				points[i-1][1]=Y;
			}
		
		if(k>breakpoint)
			k=k%breakpoint;
		ans[0]=points[k-1][0];
		ans[1]=points[k-1][1];
		return ans;
	}

	public static long solve(long x,long y) {
	    BigInteger bi1, bi2, bi3;
	    bi1 = new BigInteger(Long.toString(y));
	    bi2 = new BigInteger(Long.toString(x));
	bi3 = bi1.modInverse(bi2);
	return (bi3.longValue());
	}
}
