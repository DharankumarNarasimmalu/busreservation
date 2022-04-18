package busReservationSystem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BusAdmin {
	Bus bus;
	static Map<String,String>customerComplaint=new HashMap<>();
	static Map<String,String>customerFeedback=new HashMap<>();
	static List<String[]>passengerDetails=new ArrayList<>();
	public BusAdmin(Bus bus) {
		this.bus=bus;
	}
	public BusAdmin(Map<String, String> passengerComplaint, Map<String, String> passengerFeedback, List<String[]> busAndPassengerDetails) {
		this.customerComplaint.putAll(passengerComplaint);
		this.customerFeedback.putAll(passengerFeedback);
		this.passengerDetails.addAll(busAndPassengerDetails);
	}
	public String[] setAndShowBus() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 to set details enter 2 to show details");
		int adminOption=sc.nextInt();
		String [] busDetail=null;
		if(adminOption==1) {
		busDetail=bus.setBus();}
		else if(adminOption==2) {
		bus.showBus();}
		return busDetail;
	}
	void gettingPassengerComplaint() {
		System.out.println("passenger complaint is working");
		for(Map.Entry e:customerComplaint.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	void gettingPassengerFeedback() {
		System.out.println("Passenger feedback is working");
		for(Map.Entry e:customerFeedback.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	void gettingPassengerInfo() {
		System.out.println("Passenger info is working");
		for(String[]s:passengerDetails) {
			int len=s.length;
			for(int i=0;i<len;i++) {
				System.out.print(s[i]+" ");
			}
			System.out.println();
		}
	}
	
}

