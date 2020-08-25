package model.services;

public interface OnlinePaymentService { //Servi�o interface que previne dados com elos fortes, no caso para paypal service
	
	double paymentFee(double amount);
	double interest(double amount, int months);
}
//Se a minha classe no caso for OnlinePaymentService a mesma � obrigada a implementar esses 2 metodos