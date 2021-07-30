package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendas")
public class Venda extends Entidade {
	
	@Id
	private String id;
	private String revisionNumber;	
	private String orderDate;	
	private String dueDate;	
	private String shipDate;	
	private String status;	
	private String onlineOrderFlag;	
	private String salesOrderNumber;	
	private String purchaseOrderNumber;	
	private String accountNumber;
	private String clienteId;
	private String salesPersonID;	
	private String territoryID;	
	private String billToAddressID;	
	private String shipToAddressID;	
	private String shipMethodID;	
	private String creditCardID;	
	private String creditCardApprovalCode;
	private String currencyRateID;
	private String subTotal;	
	private String taxAmt;	
	private String freight;	
	private String totalDue;	
	private String comment;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOnlineOrderFlag() {
		return onlineOrderFlag;
	}
	public void setOnlineOrderFlag(String onlineOrderFlag) {
		this.onlineOrderFlag = onlineOrderFlag;
	}
	public String getSalesOrderNumber() {
		return salesOrderNumber;
	}
	public void setSalesOrderNumber(String salesOrderNumber) {
		this.salesOrderNumber = salesOrderNumber;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public String getSalesPersonID() {
		return salesPersonID;
	}
	public void setSalesPersonID(String salesPersonID) {
		this.salesPersonID = salesPersonID;
	}
	public String getTerritoryID() {
		return territoryID;
	}
	public void setTerritoryID(String territoryID) {
		this.territoryID = territoryID;
	}
	public String getBillToAddressID() {
		return billToAddressID;
	}
	public void setBillToAddressID(String billToAddressID) {
		this.billToAddressID = billToAddressID;
	}
	public String getShipToAddressID() {
		return shipToAddressID;
	}
	public void setShipToAddressID(String shipToAddressID) {
		this.shipToAddressID = shipToAddressID;
	}
	public String getShipMethodID() {
		return shipMethodID;
	}
	public void setShipMethodID(String shipMethodID) {
		this.shipMethodID = shipMethodID;
	}
	public String getCreditCardID() {
		return creditCardID;
	}
	public void setCreditCardID(String creditCardID) {
		this.creditCardID = creditCardID;
	}
	public String getCreditCardApprovalCode() {
		return creditCardApprovalCode;
	}
	public void setCreditCardApprovalCode(String creditCardApprovalCode) {
		this.creditCardApprovalCode = creditCardApprovalCode;
	}
	public String getCurrencyRateID() {
		return currencyRateID;
	}
	public void setCurrencyRateID(String currencyRateID) {
		this.currencyRateID = currencyRateID;
	}
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(String totalDue) {
		this.totalDue = totalDue;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
