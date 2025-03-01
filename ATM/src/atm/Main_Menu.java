package atm;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main_Menu {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	check_pin checkpin = new check_pin(7788);
	Thread thread = new Thread(new Myrunnable());
	int pin = checkpin.pin;
	int inputpin;
	int attempts = 3;
	thread.setDaemon(true);
	thread.start();
	try {
	do{
System.out.println("Enter your PIN: ");
inputpin = scan.nextInt();
	if(pin != inputpin) {
	attempts--;
	if(attempts==0){
		System.out.println("You have entered Wrong PIN!\nYou have ran out of all attempts!");
		break;}
		else if(attempts>0)
		{
			System.out.println("You have entered Wrong PIN!\nYou have "+attempts+" attempt(s) left!");
		}
		}
else {
	Check_Balance checkbalance = new Check_Balance(25000);
	double balance = checkbalance.balance();
	System.out.println("Welcome!\nSelect a Transaction:\n1 - Deposit Amount\n2 - Withdraw Amount\n3 - Check Balance\n4 - Cancel Transaction");
	int selection = scan.nextInt();
	while(selection != 4) {
	if(selection==1) {
		System.out.println("Enter the amount to be deposited: ");
		double deposited = scan.nextDouble();
		if(deposited>0) {
	Deposit deposit = new Deposit(balance,deposited);
	balance = deposit.deposit();
	System.out.println("Transaction Successful!\nTotal Available Amount: "+balance);
	break;}
		else{
			System.out.println("Amount should be greater than 0!\nTransaction failed!");
			break;
		}}
	else if(selection==2) {
		System.out.println("Enter the amount to be withdrawn: ");
		double withdrawn = scan.nextDouble();
		if(withdrawn<=balance && withdrawn>0) {
	Withdraw withdraw = new Withdraw(balance,withdrawn);
	balance = withdraw.withdraw();
	System.out.println("Transaction Successful!\nTotal Available Amount: "+balance);
	break;}
		else if(withdrawn>balance){
			System.out.println("Insufficient Funds!\nTransaction failed!");
			break;}
		else{
			System.out.println("Amount should be greater than 0!\nTransaction failed!");
			break;
		}
		}
	
	else if(selection == 3) {
		System.out.println("Available Amount: "+balance);
		break;
	}
	else {
		System.out.println("Incorrect Input!");
		break;
	}
	}
	System.out.println("Thank you!");
	}
}while(pin != inputpin);
	scan.close();}
	catch(InputMismatchException e) {
		System.out.println("Please enter digits ranging from 0 - 9.");
	}
	catch(Exception f) {
		System.out.println("Something went wrong!");
	}
}}