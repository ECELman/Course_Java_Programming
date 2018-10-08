import java.util.Scanner;
import java.util.Random;

public class A1045516_Problem_4
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Random rnd = new Random();
		
		int answer[] = new int[4];
		for(int i=3;i>=0;i--) answer[i] = rnd.nextInt(10);
		
		int A = 0,B = 0;
		
		while(true)
		{
			int user_answer1 = in.nextInt();
			int temp_answer = user_answer1;
			int user_answer2[] = new int[4];
			int temp_answer2[] = new int[4];
			int check[] = new int[4];
			
			for(int i=3;i>=0;i--)
			{
				user_answer2[i] = temp_answer%10;
				temp_answer /= 10;
			}
			
			for(int i=0;i<4;i++) 
			{
				temp_answer2[i] = answer[i];
				if(temp_answer2[i] == user_answer2[i])
				{
					check[i]=1;
					A++;
				}
			}
			
			int ckeck_repeat=0;
			for(int i=0;i<4;i++)
			{
				if(check[i]==1) continue;
				for(int j=0;j<4;j++)
				{
					if(check[j]==1) continue;
					if(user_answer2[i]==temp_answer2[j] && check[j]!=2 && ckeck_repeat==0)
					{
						B++;
						ckeck_repeat=1;
						check[j]=2;
						break;
					}
				}
				ckeck_repeat=0;
			}
			
			if(A==4 && B==0)
			{
				System.out.print("Your guess ");
				for(int i=0;i<4;i++) System.out.print(user_answer2[i]);
				System.out.println(" is right!");
				break;
			}
			else
			{
				for(int i=0;i<4;i++) System.out.print(user_answer2[i]);
				System.out.println(" " + A + "A" + B + "B");
			}
			A = 0;
			B = 0;
		}
	}

}
