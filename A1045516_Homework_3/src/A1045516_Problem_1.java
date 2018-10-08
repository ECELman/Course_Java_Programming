public class A1045516_Problem_1
{
	public static void main(String[] args)
	{	
		int sequence[] = new int[10];
		System.out.println("The sequence before sorting : \n");
		for(int i=0;i<10;i++)
		{
			sequence[i] = (int)(Math.random()*100)+1;
			System.out.print(sequence[i] + " ");
		}
		System.out.println("\n");
		
		bubble_sort(sequence,10);
		
		System.out.println("The sequence after sorting : \n");
		for(int i=0;i<10;i++) System.out.print(sequence[i] + " ");
		System.out.println();
	}
	
	public static void bubble_sort(int sequence_temp[], int size)
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size-1;j++)
			{
				if(sequence_temp[j]<sequence_temp[j+1])
				{
					int temp = sequence_temp[j];
					sequence_temp[j] = sequence_temp[j+1];
					sequence_temp[j+1] = temp;
				}
			}
		}
	}
}
