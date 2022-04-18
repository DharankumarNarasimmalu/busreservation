package busReservationSystem4;
import java.util.*;

public class BusReservation {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		
		List<String[]>customerLogin=new ArrayList<>();
		String user1[]= {"Dharan","20","149,K........cuddalore","9876543201","1234","1","0"};
		String user2[]= {"Kumar","19","148,K........chennai","1023456789","4321","2","0"};
		String user3[]= {"Karthic","21","150,K........coimbatore","9876543201","2589","3","0"};
		customerLogin.add(user1);
		customerLogin.add(user2);
		customerLogin.add(user3);

		Map<Integer,String[]>busAvailability=new HashMap<>();
		String bus1[]= {"123","50","Cuddalore","Chennai","25/04/2022","AC"};
		String bus2[]= {"124","19","Chennai","Banglore","26/04/2022","NONAC"};
		String bus3[]= {"125","21","Coimbatore","Tiruchi","26/04/2022","AC"};
		busAvailability.put(123, bus1);
		busAvailability.put(124, bus2);
		busAvailability.put(125, bus3);
		
		Map<String,String>passengerComplaint=new HashMap<>();
		Map<String,String>passengerFeedback=new HashMap<>();
		List<String[]>busAndPassengerDetails = new ArrayList<>();
		
		UserVerification verify=new UserVerification();
		
		int walletPoints=0;
		
//		BusAdmin busAdmin=new BusAdmin(passengerComplaint,passengerFeedback,busAndPassengerDetails);
		
		User user=new User(verify);
		
		Discount discount=new NoDiscount();
		
		Passenger customer;
		
		Reservation booking =new Reservation();
		
		Bus bus=null;
    	while(true) {
        BusAdmin busAdmin=new BusAdmin(passengerComplaint,passengerFeedback,busAndPassengerDetails);
        passengerComplaint.clear();
        passengerFeedback.clear();
        busAndPassengerDetails.clear();
		System.out.println("Press 2 for admin||Press 1 for passenger");
		int option=sc.nextInt();

		Transaction payment=new Transaction(discount);
		int loginuser=-1;
		
		if(option==1) {
//			boolean passengerLogin=true;
//			while(passengerLogin) {
			customer=new Passenger(verify);
//			boolean logined=true;
//			while(logined) {
				System.out.println("Press 1 for login||Press 2 for signup||press 3 for forgetpassword");
			    int passengerOption=sc.nextInt();
			    if (passengerOption==1) {
			    	loginuser=user.login(customerLogin);
			        
			        if(loginuser>=0) {
			        	
				        System.out.println("Password is correct "+loginuser);
//				        logined =false;
				        Passenger details=new Passenger(customerLogin.get(loginuser) ,booking);//passenger class
				        boolean login=true;
				        int busNo = 0;
				        int noOfSeatsRequired=0;
				        
				        while(login) {
				        System.out.println("Press 1 for booking ||press 2 for complaint||press 3 for feedabck||press 4 to change profile||press 5 for ticket cancellation||press 6 for see location of bus||for help line press 7||press 8 for logout");
				        int userfunction=sc.nextInt();

				        switch(userfunction) {
				        case(1):
				        	busAndPassengerDetails=booking.searchBus(busAvailability);
				        	noOfSeatsRequired=busAndPassengerDetails.size();
				        	busNo=Integer.parseInt(busAndPassengerDetails.get(0)[3]);

				            break;
				        case(2):
				        	String complaint=details.customerComplaint();
				            passengerComplaint.put(customerLogin.get(loginuser)[0], complaint);
				            break;
				        case(3):
				        	String feedback=details.customerFeedback();
				            passengerFeedback.put(customerLogin.get(loginuser)[0], feedback);
				            break;
				        case(4):
				        	int index=0;
				        	String[]changedDetails=details.changeProfile();
				            for(String[] s:customerLogin) {
				            	if(s[5].equals(changedDetails[5])) {
				            		index=customerLogin.indexOf(s);
				            		}
				            	}
				            customerLogin.set(index, changedDetails);
				            for(String [] s:customerLogin) {
				            	for(int i=0;i<6;i++) {
				            		System.out.print(s[i]+" ");
				            	}
				            	System.out.println();
				            }
				            break;
				        case(5):
				        	busAndPassengerDetails=payment.ticketCancellation(busAndPassengerDetails);
				            break;
				        case(6):
				        	bus.location();
				            break;
				        case(7):
				        	details.helpline();
				            break;
				        case(8):
				        	login=false;				    	
				    	    user.logout();
				    	    break;
				 
				        default:
				        	System.out.println("invalid option");
				        }
//				    }
				        if(busNo!=0) {
				        	switch(busNo) {
				        	case(123):
				        		bus=new Bus1();
								bus.seatAllocation(noOfSeatsRequired);
								String []currBus=busAvailability.get(123);
								int noOfSeats=Integer.parseInt(currBus[1]);
								int noOfEmptySeat=noOfSeats - noOfSeatsRequired;
								String noOfSeatsRemaining=Integer.toString(noOfEmptySeat);
								String currbusno[]= {"123",noOfSeatsRemaining,"Cuddalore","Chennai","25/04/2022","AC"};
								busAvailability.replace(123,currbusno);
				        	    break;
				        	     
				        	case(124):
				        		bus=new Bus2();
				        	    bus.seatAllocation(noOfSeatsRequired);
				        	    String []currBus1=busAvailability.get(123);
								int noOfSeats1=Integer.parseInt(currBus1[1]);
								int noOfEmptySeat1=noOfSeats1 - noOfSeatsRequired;
								String noOfSeatsRemaining1=Integer.toString(noOfEmptySeat1);
								String currbusno1[]= {"123",noOfSeatsRemaining1,"Cuddalore","Chennai","25/04/2022","AC"};
								busAvailability.replace(124,currbusno1);
				        	    break;
				        	    
				        	case(125):
				        		bus=new Bus3();
				        	    bus.seatAllocation(noOfSeatsRequired);
				        	    String []currBus2=busAvailability.get(123);
								int noOfSeats2=Integer.parseInt(currBus2[1]);
								int noOfEmptySeat2=noOfSeats2 - noOfSeatsRequired;
								String noOfSeatsRemaining2=Integer.toString(noOfEmptySeat2);
								String currbusno2[]= {"123",noOfSeatsRemaining2,"Cuddalore","Chennai","25/04/2022","AC"};
								busAvailability.replace(125,currbusno2);
				        	    break;
				        	default:
				        		System.out.println("invalid number");
				        	}
				        	walletPoints=Integer.parseInt(customerLogin.get(loginuser)[6]);
				        	
				        	float []amountAndUsedPoints=payment.discount(busNo,busAndPassengerDetails.size(),walletPoints);
				        	PaymentGateway paymentType = null;
				        	System.out.println("Press 1 for UPI||Press 2 for NetBanking||Press 3 for CardTransaction");
				        	int paymentOption=sc.nextInt();
				        	float  netPayment=0;
				        	switch(paymentOption) {
				        	case(1):
				        		paymentType=new Upi();

				        	    break;				        	
				        	case(2):
				        		paymentType=new NetBanking();

				        	    break;
				        	case(3):
				        		paymentType=new CardTransaction();

				        	    break;
				        	default:
				        		System.out.println("Invalid option");				        	
				        	}
				        	Transaction bill=new Transaction(paymentType);
				        	float AmountAndwalletPoints[]=bill.billPayment(amountAndUsedPoints[0],noOfSeatsRequired);
				        	netPayment=AmountAndwalletPoints[1];
				        	payment.showTicket(netPayment,busAndPassengerDetails);
				        	int walletpoint=(int)AmountAndwalletPoints[0];
				        	String wallet=Integer.toString(walletpoint);
//				        	loginuser
				        	float walletAmount=Float.parseFloat(wallet);
				        	System.out.println(wallet);
				        	String []currLoginUser=customerLogin.get(loginuser);
				        	float oldPoints=Float.parseFloat(currLoginUser[6]);
				        	int oldWalletPoints=(int)oldPoints;
				        	currLoginUser[6]=Integer.toString(walletpoint+oldWalletPoints-(int)amountAndUsedPoints[1]);
				        	customerLogin.set(loginuser, currLoginUser);
//				        	for(String[]s:customerLogin) {
//				        		for(int i=0;i<7;i++) {
//				        			System.out.print(s[i]+" ");
//				        		}
//				        		System.out.println();
//				        	}
				        	busNo=0;
				        	
				        }
			        }
			    }

			        else{
				        System.out.println("Please check login details");
				    }
			    }
			    else if(passengerOption==2) {
				    customerLogin.add(customer.signup(customerLogin.size()));				  //sign up method
			    }
			    else if(passengerOption==3) {
			    	int index=0;
			    	String[] newPassword=user.forgetPassword(customerLogin);
			    	for(String[]s:customerLogin) {
			    		if(s[5].equals(newPassword[5])) {
			    			index=customerLogin.indexOf(s);		    			
							customerLogin.set(index,newPassword);
			    		}
			    	}			    	
			    }
//			    else if(passengerOption==4) {
//			    	logined=false;
//			    	user.logout();
//			    	break;
//			    }
		}   
		else if(option==2) {
			List<String[]>adminLogin=new ArrayList<>();
			String admin[]= {"Dharankumar","20","149,K........cuddalore","9876543201","1234"};
			adminLogin.add(admin);
			int adminuser=-1;
			adminuser=user.login(adminLogin);     
	        if(adminuser>=0) {
		        System.out.println("Password is correct "+adminuser);
//		          Passenger details=new Passenger(customerlogin.get(loginuser),booking);//passenger class

		    boolean adminLogout=true;
		    while(adminLogout) {
		        System.out.println("Enter 1 for discount ||Enter 2 for set Bus||Press 3 for view customer Complaint||press 4 for view customer feedback||press 5 for getting passenger info||press 6 for logout");
		    int adminOpt=sc.nextInt();
		    switch(adminOpt) {
		    case(1):
	        System.out.println("press 1 for pongal offer||press 2 for greatoffer||press 3 for Republicday Offer");
	        int discountOption=sc.nextInt();
	        switch(discountOption) {
	        case(1):
	        	discount=new PongalDiscount();
	            break;
	        case(2):
	        	discount=new GreatOffer();
	            break;
	        case(3):
	        	discount=new RepubilcDayOffer();
	            break;
	        default:
	        	System.out.println("Invalid option");
	        }
	        break;
		    case(2):
	        boolean adminOption=true;
	        while(adminOption) {
		    System.out.println("Press 1 for Bus1||Press 2 for Bus2||Press 3 for Bus3||press 4 for cancel");
	        int busInfo=sc.nextInt();
	        int busNumber = 0;
	        switch(busInfo) {
	        case(1):
	        	bus=new Bus1();
	            busNumber=123;	            
	            break;
	        case(2):
	        	bus=new Bus2();
	            busNumber=124;
	            break;
	        case(3):
	        	bus=new Bus3();
	            busNumber=125;
	            break;
	        case(4):
	        	adminOption=false;
	            break;
	        default:
	        	System.out.println("Invalid option");
	        }
	        BusAdmin userAdmin=new BusAdmin(bus);
	        if(busNumber==0) {
	        	continue;
	        }
	        else {
	        String busDetails[]=userAdmin.setAndShowBus();
//	        {"125","21","Coimbatore","Tiruchi","26/04/2022","AC"};
//	        {driverName,date,from,to,ac};
	        String[] busInformation=busAvailability.get(busNumber);
	        busInformation[4]=busDetails[1];
	        busInformation[2]=busDetails[2];
	        busInformation[3]=busDetails[3];
	        busInformation[5]=busDetails[4];
	        busAvailability.replace(busNumber, busInformation);
	            }
	        }
	        for(Map.Entry e:busAvailability.entrySet()) {
				System.out.println(e.getKey());
				String []temparr=(String[]) e.getValue();
				for(int i=0;i<6;i++) {
					System.out.print(temparr[i]+" ");
				}
				System.out.println();
			}
	        break;
		    case(3):
		    	busAdmin.gettingPassengerComplaint();
		        break;
		    case(4):
		    	busAdmin.gettingPassengerFeedback();
		        break;
		    case(5):
		    	busAdmin.gettingPassengerInfo();
		        break;
		    case(6):
		    	user.logout();
		        adminLogout=false;
		        break;
		    }
		    
	    }
		    }
	        else{
		        System.out.println("Please check login details");
		        }
	        }
	    }
	}
}