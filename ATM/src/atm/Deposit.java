package atm;

public class Deposit {
	double balance;
	double deposited_amount;	
Deposit(double balance,double deposited_amount){
	this.balance = balance;
	this.deposited_amount = deposited_amount;
}
public Double deposit() {
	this.balance+=this.deposited_amount;
	return this.balance;
}
}
