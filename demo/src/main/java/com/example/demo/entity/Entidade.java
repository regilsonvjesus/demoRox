package com.example.demo.entity;

import java.time.LocalDateTime;

public abstract class Entidade {
	
	protected String rowGuid;
	protected String dataAlteracao = LocalDateTime.now().toString();
	
	public String getRowGuid() {
		return rowGuid;
	}
	public void setRowGuid(String rowGuid) {
		this.rowGuid = rowGuid;
	}
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
