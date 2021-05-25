package com.estudandoemcasa.curso.recursos.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant horaEmomento;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public ErroPadrao(Instant horaEmomento, Integer status, String erro, String mensagem, String caminho) {
		super();
		this.horaEmomento = horaEmomento;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}

	public Instant getHoraEmomento() {
		return horaEmomento;
	}

	public void setHoraEmomento(Instant horaEmomento) {
		this.horaEmomento = horaEmomento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
}
