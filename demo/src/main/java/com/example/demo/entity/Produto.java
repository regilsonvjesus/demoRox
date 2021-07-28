package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public class Produto extends Entidade {
	
	@Id
	private String id;
	private String nome;
	private String numero;
	private String flag;
	private String FinishedGoodsFlag;
	private String cor;
	private String safetyStockLevel;	
	private String reorderPoint;	
	private String standardCost;
	private String listPrice;
	private String size;
	private String sizeUnitMeasureCode;
	private String weightUnitMeasureCode;
	private String weight;
	private String daysToManufacture;
	private String productLine;
	private String classe;
	private String style;
	private String productSubcategoryID;
	private String productModelID;
	private String sellStartDate;
	private String sellEndDate;
	private String discontinuedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFinishedGoodsFlag() {
		return FinishedGoodsFlag;
	}
	public void setFinishedGoodsFlag(String finishedGoodsFlag) {
		FinishedGoodsFlag = finishedGoodsFlag;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSafetyStockLevel() {
		return safetyStockLevel;
	}
	public void setSafetyStockLevel(String safetyStockLevel) {
		this.safetyStockLevel = safetyStockLevel;
	}
	public String getReorderPoint() {
		return reorderPoint;
	}
	public void setReorderPoint(String reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	public String getStandardCost() {
		return standardCost;
	}
	public void setStandardCost(String standardCost) {
		this.standardCost = standardCost;
	}
	public String getListPrice() {
		return listPrice;
	}
	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSizeUnitMeasureCode() {
		return sizeUnitMeasureCode;
	}
	public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) {
		this.sizeUnitMeasureCode = sizeUnitMeasureCode;
	}
	public String getWeightUnitMeasureCode() {
		return weightUnitMeasureCode;
	}
	public void setWeightUnitMeasureCode(String weightUnitMeasureCode) {
		this.weightUnitMeasureCode = weightUnitMeasureCode;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDaysToManufacture() {
		return daysToManufacture;
	}
	public void setDaysToManufacture(String daysToManufacture) {
		this.daysToManufacture = daysToManufacture;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getProductSubcategoryID() {
		return productSubcategoryID;
	}
	public void setProductSubcategoryID(String productSubcategoryID) {
		this.productSubcategoryID = productSubcategoryID;
	}
	public String getProductModelID() {
		return productModelID;
	}
	public void setProductModelID(String productModelID) {
		this.productModelID = productModelID;
	}
	public String getSellStartDate() {
		return sellStartDate;
	}
	public void setSellStartDate(String sellStartDate) {
		this.sellStartDate = sellStartDate;
	}
	public String getSellEndDate() {
		return sellEndDate;
	}
	public void setSellEndDate(String sellEndDate) {
		this.sellEndDate = sellEndDate;
	}
	public String getDiscontinuedDate() {
		return discontinuedDate;
	}
	public void setDiscontinuedDate(String discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}
	
}
