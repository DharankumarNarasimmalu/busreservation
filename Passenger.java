package busReservationSystem4;

import java.util.Scanner;

public class Passenger {
	private String name;
	private String  age;
	private String address;
	private String phno;
	private String id;
	private String password;
	Reservation booking;
	UserVerification verify;
	Passenger(UserVerification verify){
		System.out.println("wellcome to ABC Travellers");
		this.verify=verify;
	}
	public Passenger(String[] customerInfo,Reservation booking) {
		this.name=customerInfo[0];
		this.age=customerInfo[1];
		this.address=customerInfo[2];
		this.phno=customerInfo[3];
		this.password=customerInfo[4];
		this.booking=booking;
		this.id=customerInfo[5];

	}
	String[] changeProfile() {
		Scanner sc=new Scanner(System.in);
		boolean end=true;
		while(end) {
		System.out.println("press 1 for change name||press 2 for change age||press 3 for change address||press 4 for change phonenumber||press 5 for change password||press 6 for save profile");
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		case(1):
			this.name=sc.nextLine();
		    break;
		case(2):
			this.age=sc.nextLine();
		    break;
		case(3):
			this.address=sc.nextLine();
		    break;
		case(4):
			this.phno=sc.nextLine();
		    break;
		case(5):
			this.password=sc.nextLine();
		    break;
		case(6):
			System.out.println("Saving.........");
		    end=false;
		    break;
		default:
			System.out.println("invalid number");
		}
		}
		String changedUserProfile[]= {name,age,address,phno,password,id};
		return changedUserProfile;
		
		
	}
	
	String customerComplaint() {
		System.out.println("Type your complaint hear");
		Scanner sc=new Scanner(System.in);
		String complaint=sc.nextLine();
		return complaint;
	}
	
	String customerFeedback() {
		System.out.println("Type your feedback here");
		Scanner sc=new Scanner(System.in);
		String feedback=sc.nextLine();
		return feedback;
	}
	
	public String[]  signup(int noOfPassenger) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name");
		String name=sc.nextLine();
		System.out.println("Enter age");
		String age=sc.nextLine();
		System.out.println("Enter address");
		String address=sc.nextLine();
		System.out.println("Enter phone number");
		String phno=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		String idNo=Integer.toString(noOfPassenger+1);
		String userDetails[]= {name,age,address,phno,password,idNo};
		boolean verification=verify.phnoVerifing(userDetails);
		if(!verification) {
			signup(noOfPassenger);
		}
		else {
			System.out.println("Your phone number is verified");
		}
		System.out.println("Your account was successfully created");
		return userDetails;	
	}
	public void helpline() {
		System.out.println("dialing 9876543201........");
	}
	
}
