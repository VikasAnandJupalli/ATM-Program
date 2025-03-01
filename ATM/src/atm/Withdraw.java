package atm;

public class Withdraw {
	double balance;
	double withdrawn_amount;	
	Withdraw(double balance,double withdrawn_amount){
	this.balance = balance;
	this.withdrawn_amount = withdrawn_amount;
}
public double withdraw() {
	this.balance-=this.withdrawn_amount;
	return this.balance;
}
}

