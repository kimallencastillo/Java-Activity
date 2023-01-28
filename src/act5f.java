import java.util.*;

public class act5f {
	// declaration
	final static Scanner in = new Scanner(System.in);
	private static final String COLUMN_FORMAT = "%15s";
	static int[] empNo = { 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008};
	static String[] empName = { "Duterte, Rodrigo", "Escudero, Francis", "Drilon, Franklin", "Trillanes, Sonny", 
			"Pacquiao, Manny", "Dela Rosa, Bato", "Poe, Grace", "Lacson, Ping"};
	static float[] rate = { 300,200,300,400,400,100,300,200};
	// Hours Worked
	static int[] mon = {8,7,8,8,8,8,8,5};
	static int[] tues = {8,5,8,8,8,8,8,5};
	static int[] wed = {6,8,8,8,8,8,8,5};
	static int[] thurs = {8,8,8,8,8,8,8,5};
	static int[] fri = {5,8,6,8,8,8,8,8};
	static int[] sat = {3,4,1,0,5,3,5,5};
	static int[] sun = {3,4,5,0,2,0,0,8};
	
	
	static float otPay[] = new float[8];
	static float regPay[] = new float[8];
	static float gross[] = new float[8];
	static float tax[] = new float[8];
	static float netPay[] = new float[8];
	static float regHrs[] = new float[8];
	static float otHrs[] = new float[8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;
		char ans;
		
		//get prtEmp & prtEmpNo
		//  prtEmployees prtEmps = new prtEmployees();
		do {
		System.out.println("\t----Main Option----\n");
		System.out.println("\t[1] - Display All Employees");
		System.out.println("\t[2] - Display Employees Hours Worked Per Day");
		System.out.println("\t[3] - Display Total Regular Hours Worked");
		System.out.println("\t[4] - Display Total Overtime Hours Worked");
		System.out.println("\t[5] - Display Payroll Report");
		System.out.println("\t[6] - About Me");
		System.out.println("\t[7] - End");
		System.out.print("\nChoice an option: ");
		menu = in.nextInt();
		
		switch(menu) {
		case 1:
			prtEmployees();
			break;
		case 2:
			prtHours();
			
			break;
		case 3:
			prtTotalRegHrs();
			break;
		case 4:
			prtOTHrs();
			break;
		case 5:
			prtPayroll();
			break;
		case 6:
			abtMe();
			break;
		case 7:
			System.exit(0);
			break;
		}
		System.out.print("\nType R to return: ");
		ans = in.next().charAt(0);
		}while(ans == 'r' || ans == 'R');
		
	}
	
	//prtEmp
	static void prtEmployees() {
		System.out.println("Employee Number.  \tEmployee Name   ");
		for(int ctr = 0; ctr <= 7; ctr++){
            System.out.println("    "+empNo[ctr]+ "\t\t" + empName[ctr]);
        }
		

	}
	
	//prt Hours Per Day
	static void prtHours() {
		System.out.println("\nEmployees Hours Worked Per Day\n\n");
		String[] title = {"Employee Names", "Monday", "Tuesday", "Wednesday", "Thursday", 
				"Friday", "Saturday", "Sunday"};
		for(String titles : title) {
			System.out.printf(COLUMN_FORMAT, titles);
		}
		System.out.println();
		//System.out.println("\tEmployee Name." + "\tMonday Tuesday Wednesday Thursday Friday Saturday Sunday");
		for(int ctr = 0; ctr < 8; ctr++){
            //System.out.println("\t"+empName[ctr]+"   "+mon[ctr]+"   "+tues[ctr]);
			System.out.printf("%-20s %s%s%s%s%s%s%s%s%s\n", empName[ctr] , "\t  " , mon[ctr],"\t\t  " , tues[ctr], "\t\t" + wed[ctr], "\t\t" + thurs[ctr], "\t\t" + fri[ctr] , "\t\t" + sat[ctr] , "\t\t" + sun[ctr]  );
			//System.out.printf("\t" + tues[ctr] + "\t" + wed[ctr] + "\t" + thurs[ctr] + "\t" + fri[ctr] + "\t" + sat[ctr] + "\t" + sun[ctr]);
        }
	}
	
	// RegHrs
	static void prtTotalRegHrs() {
		System.out.println("\nTotal Regular Hours Worked\n\n");
		String[] title = {"Employee Number", "Employee Names", "  Total Hours Worked from Monday to Friday"};
		for(String titles : title) {
			System.out.printf(COLUMN_FORMAT, titles);
		}
		
	
		int sum;
		int newSum[] = new int[8];
		for(int ctr = 0; ctr < 8; ctr++){
			 sum = mon[ctr] + tues[ctr] + wed[ctr]+ thurs[ctr] + fri[ctr];
			 newSum[ctr] += sum;
		
		
		}
		System.out.println();
		for(int ctr = 0; ctr < 8; ctr++){
            System.out.printf("%-20s %s%s%s\n", empNo[ctr] , empName[ctr] , "\t\t",  newSum[ctr]);
            
        }
	}
	
	static void prtOTHrs() {
		System.out.println("\nTotal Overtime Hours Worked\n\n");
		String[] title = {"Employee Number", "\tEmployee Names", "\ttotal hours  worked from Saturday to Sunday"};
		for(String titles : title) {
			System.out.printf(COLUMN_FORMAT, titles);
		}
		
		
		int sum;
		int otHrs[] = new int[8];
		for(int ctr = 0; ctr < 8; ctr++){
			 sum = sat[ctr] + sun[ctr];
			 otHrs[ctr] += sum;
			
				
		}
		System.out.println();
		for(int ctr = 0; ctr < 8; ctr++){
            System.out.printf("%-20s %s%s%s\n", empNo[ctr] , empName[ctr] , "\t\t",  otHrs[ctr]);
            
        }
	}
	
	// Payroll
	static void prtPayroll() {
		System.out.println("\nTotal Payroll Report\n\n");
		String[] title = {"Employee Names", "Regular Pay", "OverTime Pay", "Grosspay", "Tax", "Netpay"};
		for(String titles : title) {
			System.out.printf(COLUMN_FORMAT, titles);
		}
		
	
		int sumRegHr, sumOtHr;
		float newRegPay;
		
		for(int ctr = 0; ctr < 8; ctr++){
			// Reg Hrs
			sumRegHr = mon[ctr] + tues[ctr] + wed[ctr]+ thurs[ctr] + fri[ctr];
			regHrs[ctr] += sumRegHr;
			//System.out.println(sumRegHr);
			//OT Hrs
			sumOtHr = sat[ctr] + sun[ctr];
			otHrs[ctr] += sumOtHr;
			
			//Reg Pay
			regPay[ctr] = regHrs[ctr] * rate[ctr];
			// += newRegPay;
			//Ot Pay
			otPay[ctr] += (float) (otHrs[ctr] * rate[ctr] * 1.25);
			
			//gross
			gross[ctr] += regPay[ctr] + otPay[ctr];
			
			//tax tax = .10f * grossWage
			tax[ctr] = .10f * gross[ctr];
			
			//netPay
			netPay[ctr] = gross[ctr] - tax[ctr];
		}
	
		System.out.println();
		for(int ctr = 0; ctr < 8; ctr++){

            System.out.printf("%-20s %s%s%s%s%s%s%s%s%s%s\n", empName[ctr] , "\t",  regPay[ctr] , "\t\t",  otPay[ctr] , "\t\t",  gross[ctr] , "\t\t",  tax[ctr] , "\t\t",  netPay[ctr]);
            
        }
	}
	
	static void abtMe() {
		// about me
		//to Display About ME

		  //to Display About ME
		       System.out.println("\t\t\t\t\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");		
			   System.out.println("\n\t\t\t\t\t      Application of Modular Programming and Arrays          ");		
			   System.out.println("\t\t\t\t\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");								
			   System.out.println("\t\t\t\t\t        COMPUTERIZED PAYROLL PROCESSING AND REPORTING          ");
			   System.out.println("\t\t\t\t\t                         PROGRAM                               ");
			   System.out.println("\t\t\t\t\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");	
			   System.out.println("\t\t\t\t\t━━━━━━━━━     Developed By: JJeramae        ━━━━━━━━━━━━");	
			   System.out.println("\t\t\t\t\t                     17-adjakdja                           ━━━");	
			   System.out.println("\t\t\t\t\t           	abahsahsha@gmail.com                      ");
			   System.out.println("\t\t\t\t\t                  CCS                             ");
			   System.out.println("\t\t\t\t\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");	
			   System.out.println("\t\t\t\t\t━━━━━━━━━━━   Subject Enrolled: asadhakjda  ━━━━━━━━━━━━━━");	
			  
			 
	}
	

}
