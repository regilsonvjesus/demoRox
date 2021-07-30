package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itens_venda")
public class ItemVenda extends Entidade {
	
	private String vendaId;
	private String id;
	private String carrierTrackingNumber;	
	private String orderQty;	
	private String produtoId;
	private String specialOfferID;
	private String unitPrice;	
	private String unitPriceDiscount;
	private String lineTotal;
	
	public String getVendaId() {
		return vendaId;
	}
	public void setVendaId(String vendaId) {
		this.vendaId = vendaId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarrierTrackingNumber() {
		return carrierTrackingNumber;
	}
	public void setCarrierTrackingNumber(String carrierTrackingNumber) {
		this.carrierTrackingNumber = carrierTrackingNumber;
	}
	public String getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
	public String getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}
	public String getSpecialOfferID() {
		return specialOfferID;
	}
	public void setSpecialOfferID(String specialOfferID) {
		this.specialOfferID = specialOfferID;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUnitPriceDiscount() {
		return unitPriceDiscount;
	}
	public void setUnitPriceDiscount(String unitPriceDiscount) {
		this.unitPriceDiscount = unitPriceDiscount;
	}
	public String getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(String lineTotal) {
		this.lineTotal = lineTotal;
	}

}
