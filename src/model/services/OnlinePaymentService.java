package model.services;

public interface OnlinePaymentService { //Serviço interface que previne dados com elos fortes, no caso para paypal service
	
	double paymentFee(double amount);
	double interest(double amount, int months);
}
//Se a minha classe no caso for OnlinePaymentService a mesma é obrigada a implementar esses 2 metodos