import java.util.Scanner;

public class A1045516_Problem_5
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		char pattern[] = new char[5];
		
		for(int i=0;i<5;i++)
		{
			String temp=in.next();
			if(i==0)
			{
				if(temp.charAt(0)=='R' || temp.charAt(0)=='G' || temp.charAt(0)=='B')
					pattern[i] = temp.charAt(0);
				else
				{
					System.out.println("Invalid. Please input again!");
					while(true)
					{
						temp = in.next();
						if(temp.charAt(0)=='R' || temp.charAt(0)=='G' || temp.charAt(0)=='B')
						{
							pattern[i] = temp.charAt(0);
							break;
						}
						else System.out.println("Invalid. Please input again!");
					}
				}
			}
			else
			{
				if(temp.charAt(0)!=pattern[i-1] && (temp.charAt(0)=='R' || temp.charAt(0)=='G' || temp.charAt(0)=='B'))
					pattern[i] = temp.charAt(0);
				else
				{
					if(temp.charAt(0)==pattern[i-1] || temp.charAt(0)!='R' || temp.charAt(0)!='G' || temp.charAt(0)!='B')
					{
						System.out.println("Invalid. Please input again!");
						while(true)
						{
							temp=in.next();
							if(temp.charAt(0)!=pattern[i-1] && (temp.charAt(0)=='R' || temp.charAt(0)=='G' || temp.charAt(0)=='B'))
							{
								pattern[i] = temp.charAt(0);
								break;
							}
							else if(temp.charAt(0)==pattern[i-1] || temp.charAt(0)!='R' || temp.charAt(0)!='G' || temp.charAt(0)!='B')
								System.out.println("Invalid. Please input again!");
						}
					}
				}
			}
		}
		
		System.out.print("The final stripe pattern is ");
		for(int i=0;i<5;i++) System.out.print(pattern[i]);
		System.out.println();
	}

}
