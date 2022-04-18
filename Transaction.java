package busReservationSystem4;

import java.util.List;
import java.util.Scanner;

class Transaction{
	Discount discountType;
	PaymentGateway billPayment;
	Transaction(Discount discount){
		this.discountType=discount;
	}
	public Transaction(PaymentGateway paymentType) {
		this.billPayment=paymentType;
		
	}
	int  wallet(int numberOfPassenger) {
		int points=numberOfPassenger*5;
		return points;
	
	}
	float[] discount(int busNo,int noOfPassenger, int walletPoint) {
		float finalAmount=0;
		int usedpoints=0;
		if(busNo==123) {
			int amount=500;
			System.out.println("rupees per ticket "+amount);
			finalAmount=discountType.discountType(amount);
		}
		else if(busNo==124) {			
			int amount=250;
			System.out.println("rupees per ticket "+amount);
			finalAmount=discountType.discountType(amount);
		}
		else if(busNo==125) {			
			int amount=300;
			System.out.println("rupees per ticket "+amount);
			finalAmount=discountType.discountType(amount);
		}
		System.out.println("press 1 to use wallet points ||press 2 to continue");
		Scanner sc=new Scanner(System.in);
		int walletOption=sc.nextInt();
		if(walletOption==1) {
			finalAmount-=walletPoint;
			usedpoints=walletPoint;
		}
		else if(walletOption==2) {
			finalAmount=finalAmount;
			usedpoints=0;
		}
		float []finalAmountAndWalletPoints= {finalAmount*noOfPassenger,(float)usedpoints};
		return finalAmountAndWalletPoints;
	}

	List<String[]> ticketCancellation(List<String[]> busAndPassengerDetails) {
		Scanner sc=new Scanner(System.in);
		int numberOfTicket=0;
		float amount=0;
		System.out.println("Enter bus number");
		String busNo=sc.nextLine();
		System.out.println("Enter name");
		String date =sc.nextLine();
		for(String s[]:busAndPassengerDetails) {
			if(busNo.equals(s[3])&& date.equals(s[0])) {
				busAndPassengerDetails.remove(s);
				numberOfTicket+=1;
				if(busNo.equals("123")) {
					amount+=500;
				}
				else if(busNo.equals(124)) {
					amount+=250;
				}
				else if(busNo.equals(125)) {
					amount+=300;
				}
			}
		}
		refund(amount);
		return busAndPassengerDetails;
		
	}
	void refund(float amount) {
		System.out.println("Rs."+amount+" is transfered to your account");
	}
	float []billPayment(float amount,int noOfPassenger) {
		
	    float netAmount=billPayment.payableMethod(amount);
	    int walletpoints=wallet(noOfPassenger);
	    float[]amountAndWallet= {walletpoints,netAmount};
		return amountAndWallet;
		
	}
	void showTicket(float netPayment, List<String[]> busAndPassengerDetails) {
		System.out.println("Passenger Details");
		for(String[]s:busAndPassengerDetails) {
			for(int i=0;i<4;i++) {
				System.out.print(s[i]+" ");
			}
			System.out.println();
		}
		System.out.println("your bill amount"+netPayment);
		
	}

}
interface PaymentGateway{
	float payableMethod(float amount);
}
class Upi implements PaymentGateway{

	public float payableMethod(float amount) {
		System.out.println("Enter password");
		Scanner sc=new Scanner(System.in);
		int pin=sc.nextInt();
		float netAmount=amount;
		return netAmount;
		
	}
}
class NetBanking implements PaymentGateway{
	public float payableMethod(float amount) {
		System.out.println("Enter password");
		Scanner sc=new Scanner(System.in);
		String  pass=sc.nextLine();
		float netAmount = amount;
		if (amount>=500) {
			netAmount+=amount*0.01f;
		}
		return netAmount;
	}
}
class CardTransaction implements PaymentGateway{
	public float payableMethod(float amount) {
		System.out.println("enter card number");
		Scanner sc=new Scanner(System.in);
		long cardNo=sc.nextLong();
		System.out.println("Enter cvv number");
		int cvv=sc.nextInt();
		float netAmount=amount;
		if(amount>1000) {
			netAmount+=amount*0.05f;
		}
		return netAmount;
		
	}
}
interface Discount{
	float discountType(int amount);

}
class PongalDiscount implements Discount{

	@Override
	public float discountType(int amount) {
		System.out.println("bill amount "+amount+'\n'+"discount amount "+amount*0.05);
		return amount-(amount*0.05f);
		
	}
	
}
class GreatOffer implements Discount{

	@Override
	public float discountType(int amount) {
		System.out.println("bill amount "+amount+'\n'+"discount amount "+amount*0.05);
		return(amount-amount*0.1f);
	}
	
}
class RepubilcDayOffer implements Discount{

	@Override
	public float discountType(int amount) {
		System.out.println("bill amount "+amount+'\n'+"discount amount "+amount*0.05);
		return (amount-amount*0.01f);
	}
	
}
class NoDiscount implements Discount{

	@Override
	public float discountType(int amount) {
		System.out.println("Sorry no discount available");

		return amount;
	}
	
}
