package models;

public class Summary {

	private String clientId;
	private String transactionType;
	private String transactionDate;
	private String priority;
	private int processionFees;
	
	public Summary(String clientId, String transactionType, String transactionDate, String priority,
			int processionFees) {
		super();
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.priority = priority;
		this.processionFees = processionFees;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getProcessionFees() {
		return processionFees;
	}
	public void setProcessionFees(int processionFees) {
		this.processionFees = processionFees;
	}

	@Override
	public String toString() {
		return clientId + "," + transactionType + ","
				+ transactionDate + "," + priority + "," + processionFees;
	}

}
