package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;//fraco acoplamento
	
	public ContractService(OnlinePaymentService onlinePaymentService) {  //construtor
		this.onlinePaymentService = onlinePaymentService;
	}
	
	//operacao process contract
	
	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValue() / months; //pega o total e divide pelas parcelas 
		for(int i = 1; i<=months;i++) {  // for para realizar um contador pra quantidade de meses e processar as parcelas
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i); //juros com base nessa basicQuota passado i meses
			double fullQuota = updatedQuota * onlinePaymentService.paymentFee(updatedQuota);//Taxa de pagamento com base a quota atualizada
		
			Date dueDate = addMonths(contract.getDate(), i); //retorna a data de vencimento da parcela
			//adicionar ao contrato essa instancia
			//acessar a lista
			contract.getInstallments().add(new Installment(dueDate, fullQuota)); //Gravará a data de vencimento e o valor final
		}
	}
	
	private Date addMonths(Date date, int N) { //instanciar o calendario. Acrecentar meses a uma data
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
}
