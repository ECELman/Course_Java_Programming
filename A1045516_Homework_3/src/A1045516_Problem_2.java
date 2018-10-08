import java.util.Scanner;

public class A1045516_Problem_2 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int num;
		
		int total = 0;
		int grade[] = new int[5];
		System.out.print("Enter (-1 to exit): ");
		while((num = in.nextInt())!=-1)
		{			
			while((num<0 || num>100) && num!=-1)
			{
				System.out.println("The number " + num + " is invalid. Please enter again!");
				System.out.print("Enter (-1 to exit): ");
				num = in.nextInt();
			}
			if(num==-1) break;
			
			total++;
			if(num<=100 && num>=90) grade[0]++;
			if(num<=89 && num>=80) grade[1]++;
			if(num<=79 && num>=70) grade[2]++;
			if(num<=69 && num>=60) grade[3]++;
			if(num<=59 && num>=0) grade[4]++;
			
			System.out.print("Enter (-1 to exit): ");
		}
		
		System.out.println("End of Input...\nTotal: " + total);
		
		System.out.print(" 90 ~ 100: "); print_star(grade[0]);
		System.out.print(" 80 ~  89: "); print_star(grade[1]);
		System.out.print(" 70 ~  79: "); print_star(grade[2]);
		System.out.print(" 60 ~  69: "); print_star(grade[3]);
		System.out.print("  0 ~  59: "); print_star(grade[4]);
	}
	
	public static void print_star(int time)
	{
		for(int i=0;i<time;i++) System.out.print("*");
		System.out.println();
	}
}
