package entities;

import java.util.Date;

public class ContratoHora {
    
    private Date Data;
    private Double valorPorHora;
    private Integer hora;

    public ContratoHora() {
    }

    public ContratoHora(Date data, Double valorPorHora, Integer hora) {
	Data = data;
	this.valorPorHora = valorPorHora;
	this.hora = hora;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }
   
    public Double valorTotal() {
	return valorPorHora * hora; 
    }
    
}
