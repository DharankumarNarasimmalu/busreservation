package busReservationSystem4;
import java.util.List;
import java.util.Scanner;

class User{
	UserVerification verify;
	public User(UserVerification verify) {
		this.verify=verify;
	}

	int login(List<String[]> login) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter UserName");
		String username=sc.nextLine();
		System.out.println("Enter Password");
		String password=sc.nextLine();
//		boolean check=false;
		int indexOfPassenger=-1;
		for(String []s:login) {
		if(s[0].equals(username) && s[4].equals(password)) {
//			check= true;
			indexOfPassenger=login.indexOf(s); 
		    }
	    }
		return indexOfPassenger;	
	}
	
	void logout() {
		System.out.println("Thanking of choosing out service");
		System.out.println("Press 1 for remember password||Press 2 for exit");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
			case(1):
				System.out.println("remember password");
			    break;
			case(2):
				System.out.println("Does not remember password");
			    break;
		}
	}
	String[] forgetPassword(List<String[]> customerlogin) {
		System.out.println("Enter user name");
		Scanner sc=new Scanner(System.in);
		String username=sc.nextLine();
		String[]currUser = null;
		String newPassword=null;
		int flag=0;
		boolean verification = false;
		for(String[]s:customerlogin) {
			if(username.equals(s[0])) {
				currUser=s;
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("Invalid user name");
			forgetPassword(customerlogin);
		}
		else {
		verification=verify.phnoVerifing(currUser);
		}
		if(verification) {
			System.out.println("Enter new password");
			newPassword=sc.nextLine();
			currUser[4]=newPassword;
		}
		else {
			System.out.println("Your phone number is wrong");
			forgetPassword(customerlogin);
		}
		return currUser;
	}	
}
class UserVerification{
	boolean phnoVerifing(String[] currUser) {
		System.out.println("Enter phone number");
		Scanner sc=new Scanner(System.in);
		String phoneNo=sc.nextLine();
		if(phoneNo.equals(currUser[3])){
			return true;
		}
		else {
		return false;
		}
	}
}
