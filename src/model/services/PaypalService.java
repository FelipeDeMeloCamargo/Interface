package model.services;

public class PaypalService implements OnlinePaymentService{

	private static final double PAYMENT_FEE = 0.02;//taxa de pagamento
	private static final double MONTHLY_INTEREST = 0.01; //juros
	//Como os valores são fixos, não precisa declarar variaveis
	
	@Override
	public double paymentFee(double amount) { //qual que é a taxa de pagamento com base uma quantia
		return amount * PAYMENT_FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * months * MONTHLY_INTEREST; 
	}
	
	
	
}
