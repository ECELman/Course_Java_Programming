import java.util.Scanner;

public class A1045516_Problem_2
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt(), sum = 0;
		while(input!=-1)
		{
			if(input<0) System.out.println("The input "+ input + " will not be added! Please input the positive integer!");
			else sum += input;
			input = in.nextInt();
		}
		
		System.out.println("The total sum is "+ sum);
	}

}
