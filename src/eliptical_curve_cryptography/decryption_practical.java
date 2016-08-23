package eliptical_curve_cryptography;
import java.math.BigInteger;
import java.util.Scanner;
public class decryption_practical {
	public static long a=2,m=121993;
	public static void main(String args[])
	{  long c1[]=new long[2];//c1=k*p chipser text
	   long c2[]=new long[2];
	   long d_c1[]=new long[2];
	   long dm[]=new long[2];
	   long code_in[]=new long[400];
	   int b=0;
	   String str="";
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the encryted message from alice");
		do
		{
			code_in[b]=scan.nextLong();
			b++;
		}while(code_in[b-1]!=0);
		for(int l=0;l<b-1;l+=4)
		{
		c1[0]=code_in[l];
		c1[1]=code_in[l+1];
		c2[0]=code_in[l+2];
		c2[1]=code_in[l+3];
		d_c1=multiplication(c1[0],c1[1],2348);
		dm=addition(c2[0],d_c1[0],c2[1],-d_c1[1]);
		str+=(char)dm[0];
		str+=(char)dm[1];
		//System.out.println("x coordinate of message = "+dm[0]);
		//System.out.println("y coordinate of message = "+dm[1]);
		}
		System.out.println("your message is");
		System.out.println(str);
	}
	public static long[] addition(long X ,long x_,long Y,long y_)
	{   long X_,Y_;
	   long ans[]=new long[2];
		try{
			long j=solve(m,(X-x_));	
			if(j<0)
			{
				j=m+j;
			}
				long s=((Y-y_)*j)%m;
				 X_=(s*s-(X+x_))%m;
				if(X_<0)
					X_=m+X_;
				 Y_=(s*(X-X_)-Y)%m;
				if(Y_<0)
					Y_=m+Y_;
				}
				catch(Exception e)
			      {
				X_=0;Y_=0;
			      }
		ans[0]=X_;ans[1]=Y_;
		return ans;
	}
	public static long[] multiplication(long x,long y,int k)
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
			{long j=solve(m,2*y);
			
			if(j<0)
			{
				j=m+j;
			}
			long s=((3*x*x+a)*j)%m;
			 X=(s*s-2*x)%m;
			 Y=(s*(x-X)-y)%m;//7,11 13
			if(Y<0)
				Y=m+Y;
			}
			else
			{
				try{
			long j=solve(m,(X-x_));	
			if(j<0)
			{
				j=m+j;
			}
				long s=((Y-y_)*j)%m;
				long X_=(s*s-(X+x_))%m;
				if(X_<0)
					X_=m+X_;
				long Y_=(s*(X-X_)-Y)%m;
				if(Y_<0)
					Y_=m+Y_;
				
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
