package busReservationSystem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Reservation{
	
	List<String[]> gettingPassengerInfo(String[] choosedBus) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of seats required");
		int noOfSeats=sc.nextInt();
		sc.nextLine();

		boolean check=checkingAvailability(noOfSeats,choosedBus);
		List<String[]>passengerDetails=new ArrayList<>();
		if(check) {
			for(int i=0;i<noOfSeats;i++) {
				System.out.println("Enter passenger name");
				String name=sc.nextLine();
				System.out.println("Enter gender");
				String gender=sc.nextLine();
				System.out.println("Enter age");
				String age=sc.nextLine();
//				System.out.println("Enter preffered seat number");
//				String seat=sc.nextLine();
				String passenger[]= {name,gender,age,choosedBus[0]};
				passengerDetails.add(passenger);
				}
		}
		else {
			gettingPassengerInfo(choosedBus);
		}
		return passengerDetails;
	}
	
	boolean checkingAvailability(int noOfSeats2, String[] choosedBus) {
		int noOfSeats=Integer.parseInt(choosedBus[1]);
		if(noOfSeats2<=noOfSeats) {
			return true;
	
		}
		else {
			System.out.println("Sorry Seat is not available");
			return false;

		}
	}
	
	List<String[]> searchBus(Map<Integer, String[]> busAvailability){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter from location");
		String from=sc.nextLine();
		System.out.println("Enter to location");
		String to=sc.nextLine();
		System.out.println("Enter Date in formate of dd/mm/yyyy");
		String date=sc.nextLine();
		List<String[]>resultentbus=new ArrayList<>();
		int flag=0;
		for(Map.Entry e:busAvailability.entrySet()) {
			String []arr=(String[]) e.getValue();
			if(arr[2].equals(from) && arr[3].equals(to) && arr[4].equals(date)) {
			flag=1;
			System.out.println("Press "+e.getKey()+"for booking");
			for(int i=0;i<6;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
			}
		if(flag==0) {
			System.out.println("Sorry! no bus available");
			searchBus(busAvailability);
		}
		boolean busNumber=true;
		int choosedbus=0;
		while(busNumber) {
		choosedbus=sc.nextInt();
		Set<Integer> s= busAvailability.keySet();
		boolean avalability=false;
		for(Map.Entry e:busAvailability.entrySet()) {
			if((Integer)e.getKey()==choosedbus) {
				avalability=true;
			}
		}
		if(avalability) {
			busNumber=false;
		}
		else {
			System.out.println("Invalid number");
		}
	}

		List<String[]> choosedBusDetails=gettingPassengerInfo(busAvailability.get(choosedbus));
//		int passengerAndBus[]= {choosedbus,noOfPassenger};
		return choosedBusDetails;

	}
}


