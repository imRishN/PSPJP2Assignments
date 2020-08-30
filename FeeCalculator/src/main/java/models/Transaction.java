package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private String extTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDateString;
	private Date transactionDate;
	private String marketValue;
	private String priorityFlag;
	private int transactionFees = 0;
	
	public Transaction(String extTransactionId, String clientId, String securityId,
			String transactionType, String transactionDateString, String marketValue,
			String priorityFlag) throws Exception {
		super();
		this.extTransactionId = extTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDateString = transactionDateString;
		this.transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transactionDateString);
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
	}
	
	public String getExtTransactionId() {
		return extTransactionId;
	}
	public void setExtTransactionId(String extTransactionId) {
		this.extTransactionId = extTransactionId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDateString() {
		return transactionDateString;
	}
	public void setTransactionDateString(String transactionDateString) {
		this.transactionDateString = transactionDateString;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	
	public int getTransactionFees() {
		return transactionFees;
	}

	public void setTransactionFees(int transactionFees) {
		this.transactionFees = transactionFees;
	}

	@Override
	public String toString() {
		return "Transaction [extTransactionId=" + extTransactionId + ", clientId=" + clientId + ", securityId="
				+ securityId + ", transactionType=" + transactionType + ", transactionDateString="
				+ transactionDateString + ", transactionDate=" + transactionDate + ", marketValue=" + marketValue
				+ ", priorityFlag=" + priorityFlag + ", transactionFees=" + transactionFees + "]";
	}
	

}
