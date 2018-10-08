import java.util.Scanner;

public class A1045516_Problem_1
{

	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("請使用者輸入2個整數 : ");
		int num1=in.nextInt(),num2=in.nextInt(),answer=10;
		if(num1+num2==answer) System.out.println("正確");
		else System.out.println("錯誤");
		
		in.close();

	}

}
