import java.util.Scanner;

public class CheckPasswd {
	public static boolean check(String passwd) {
		if ( passwd.length() < 8 )
			return false;
		char [] passwdChar = passwd.toCharArray();
		int numCount = 0;
		for ( int i = 0; i < passwdChar.length; ++i ) {
			if (passwdChar[i] >= '0' && passwdChar[i] <= '9')
				numCount++;
			if ( !(passwdChar[i] >= '0' && passwdChar[i] <= '9' 
			    || passwdChar[i] >= 'a' && passwdChar[i] <= 'z'
				|| passwdChar[i] >= 'A' && passwdChar[i] <= 'Z')
			   )
			   return false;
		}
		return (numCount >= 2);
	}

	public static void main(String [] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter a password: ");
		String p = input.next();
		if (check(p)) {
			System.out.print("Valid Password\n");
		} else {
			System.out.print("Invalid Password\n");
		}
	} 
}
