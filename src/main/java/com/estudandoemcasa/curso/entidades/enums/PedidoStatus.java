package com.estudandoemcasa.curso.entidades.enums;

public enum PedidoStatus {

	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigoStatus;
	
	private PedidoStatus(int codigoStatus) {
		this.codigoStatus = codigoStatus;
	}
	
	public int getCodigoStatus() {
		return codigoStatus;
	}
	
	public static PedidoStatus valueOf(int codigoStatus) {
		for (PedidoStatus status : PedidoStatus.values()) {
			if(status.getCodigoStatus() == codigoStatus) {
				return status;
			}
		}
		throw new IllegalArgumentException("Status do pedido inválido!");
	}
}
