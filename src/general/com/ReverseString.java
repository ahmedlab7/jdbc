package general.com;
import java.util.Scanner;

public class ReverseString
{
	public static void main(String[] args)
	{
		/*System.out.println("Enter string to reverse:");
		
		Scanner read = new Scanner(System.in);*/
		String str =        "54321"; // read.nextLine();
		String reverse = "";
		
		
		for(int i = str.length() - 1; i >=0; i--)
		{
			System.out.println(reverse);
			reverse = reverse + str.charAt(i);
		}
		
		System.out.println("Reversed string is:");
		System.out.println(reverse);
	}
}