import java.util.Random;
import java.util.Scanner;

public class A1045516_Problem_1
{

	public static void main(String[] args)
	{
		Random rnd = new Random();
		Scanner in = new Scanner(System.in);
		
		int sum1 = rnd.nextInt(10), sum2 = rnd.nextInt(10);
		while(true)
		{
			int user_answer = in.nextInt();
			if(user_answer!=(sum1+sum2)) System.out.println("Your guess is error. Please try again!");
			else
			{
				System.out.println("Bingo! Your guess is right!");
				break;
			}
		}
	}

}
