package com.desafio.domain.enuns;

public enum EstadoUtensilio {

	NOVO("Novo",1),
	USADO("Usado",2);
	
	private String estado;
	private Integer cod;
	
	private EstadoUtensilio(String estado, Integer cod) {
		this.estado = estado;
		this.cod = cod;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public static EstadoUtensilio fromEstado(Integer cod) {
		for (EstadoUtensilio x : EstadoUtensilio.values()) {
			if(x.getCod() == cod) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Estado não encontrado. Cod: "+cod);
	}

	
	
}
