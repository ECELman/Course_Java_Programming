import java.util.Scanner;

public class A1045516_Problem_3
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt(),max = 0;
		while(input!=-1)
		{
			if(input<0) System.out.println("The input " + input + " will not be added to compare. Please input positive integer!");
			if(input > max) max = input;
			input = in.nextInt();
		}
		
		System.out.println("The maximum value is " + max);
	}

}
