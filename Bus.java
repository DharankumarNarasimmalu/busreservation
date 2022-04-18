package busReservationSystem4;

import java.util.Scanner;

public interface Bus{
	void seatAllocation(int noOfSeats);
    String[] setBus();
    void showBus();
	void location();
}
class Bus1 implements Bus{
	static String driverName;
	static String from;
	static String to;
	static String ac;
	static String date;
	static int seatallocation[][]= {{1,2,3,4},{5,6,7,8,},{9,10,11,12},{13,14,15,16}};

	
	@Override
	public void location() {
		System.out.println("location of bus1 is ..........");
		
		
	}

	@Override
	public void seatAllocation(int noOfSeats) {
		System.out.println("Enter your preffered seat number");
		Scanner sc=new Scanner(System.in);
		int prefferedSeats[]=new int[noOfSeats];
		int k=0;

		for(int s=0;s<noOfSeats;) {
			if(k>noOfSeats) {
				break;
			}
			for(int h=0;h<4;h++) {
				for(int l=0;l<4;l++) {
					System.out.print(seatallocation[h][l]+" ");
				}
				System.out.println();
			}
			int flag=0;
			int seat=sc.nextInt();
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(seatallocation[i][j]==seat) {
						prefferedSeats[k]=seat;
						k++;
						s++;
						seatallocation[i][j]=0;
						flag=1;
						
					}
				}
			}
			if(flag==0) {
				System.out.println("Sorry your preffered seat is already full");
			}
			
		}
		
	}

	@Override
	public String[] setBus() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter driver name");
		this.driverName=sc.nextLine();
		System.out.println("Enter from location");
		this.from=sc.nextLine();
		System.out.println("Enter to address");
		this.to=sc.nextLine();
		System.out.println("Enter ac or not");
		this.ac=sc.nextLine();
		System.out.println("Enter date");
		this.date=sc.nextLine();
		String details[]= {driverName,date,from,to,ac};
		return details;
	}

	@Override
	public void showBus() {
		System.out.println("DriverName "+ driverName);
		System.out.println("from location "+from);
		System.out.println("to location "+to);
		System.out.println("ac or not"+ac);
		
	}
		
}
class Bus2 implements Bus{
	static String driverName;
	static String from;
	static String to;
	static String ac;
	static String date;
	static int seatallocation[][]= {{1,2,3,4},{5,6,7,8,},{9,10,11,12},{13,14,15,16}};

	@Override
	public void location() {
		System.out.println("location of bus2 is..........");
		
	}

	@Override
	public void seatAllocation(int noOfSeats) {
		System.out.println("Enter your preffered seat number");
		Scanner sc=new Scanner(System.in);
		int prefferedSeats[]=new int[noOfSeats];
		int k=0;

		for(int s=0;s<noOfSeats;s++) {
			for(int h=0;h<4;h++) {
				for(int l=0;l<4;l++) {
					System.out.print(seatallocation[h][l]+" ");
				}
				System.out.println();
			}
			int flag=0;
			int seat=sc.nextInt();
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(seatallocation[i][j]==seat) {
						prefferedSeats[k]=seat;
						k++;
						seatallocation[i][j]=0;
						flag=1;
						
					}
				}
			}
			if(flag==0) {
				System.out.println("Sorry your preffered seat is already full");
			}
			
		}
		
	}

	@Override
	public String[] setBus() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter driver name");
		this.driverName=sc.nextLine();
		System.out.println("Enter from location");
		this.from=sc.nextLine();
		System.out.println("Enter to address");
		this.to=sc.nextLine();
		System.out.println("Enter ac or not");
		this.ac=sc.nextLine();
		System.out.println("Enter date");
		this.date=sc.nextLine();
		String details[]= {driverName,date,from,to,ac};
		return details;
	}

	@Override
	public void showBus() {
		System.out.println("DriverName "+ driverName);
		System.out.println("from location "+from);
		System.out.println("to location "+to);
		System.out.println("ac or not"+ac);
		
	}

	
}
class Bus3 implements Bus{
	static String driverName;
	static String from;
	static String to;
	static String ac;
	static String date;
	static int seatallocation[][]= {{1,2,3,4},{5,6,7,8,},{9,10,11,12},{13,14,15,16}};
	
	@Override
	public void location() {
		System.out.println("location of bus3 is .............");
		
	}

	@Override
	public void seatAllocation(int noOfSeats) {
		System.out.println("Enter your preffered seat number");
		Scanner sc=new Scanner(System.in);
		int prefferedSeats[]=new int[noOfSeats];
		int k=0;

		for(int s=0;s<noOfSeats;s++) {
			for(int h=0;h<4;h++) {
				for(int l=0;l<4;l++) {
					System.out.print(seatallocation[h][l]+" ");
				}
				System.out.println();
			}
			int flag=0;
			int seat=sc.nextInt();
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(seatallocation[i][j]==seat) {
						prefferedSeats[k]=seat;
						k++;
						seatallocation[i][j]=0;
						flag=1;
						
					}
				}
			}
			if(flag==0) {
				System.out.println("Sorry your preffered seat is already full");
			}
			
		}
		
	}

	@Override
	public String[] setBus() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter driver name");
		this.driverName=sc.nextLine();
		System.out.println("Enter from location");
		this.from=sc.nextLine();
		System.out.println("Enter to address");
		this.to=sc.nextLine();
		System.out.println("Enter ac or not");
		this.ac=sc.nextLine();
		System.out.println("Enter date");
		this.date=sc.nextLine();
		String details[]= {driverName,date,from,to,ac};
		return details;
	}

	@Override
	public void showBus() {
		System.out.println("DriverName "+ driverName);
		System.out.println("from location "+from);
		System.out.println("to location "+to);
		System.out.println("ac or not"+ac);
		
	}	
}

