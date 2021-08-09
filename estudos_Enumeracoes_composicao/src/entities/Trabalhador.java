package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelDeTrabalho;

public class Trabalhador {

    private String nome;
    private NivelDeTrabalho nivel;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, NivelDeTrabalho nivel, Double salarioBase, Departamento departamento) {
	this.nome = nome;
	this.nivel = nivel;
	this.salarioBase = salarioBase;
	this.departamento = departamento;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public NivelDeTrabalho getNivel() {
	return nivel;
    }

    public void setNivel(NivelDeTrabalho nivel) {
	this.nivel = nivel;
    }

    public Double getSalarioBase() {
	return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
	this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
	return departamento;
    }

    public void setDepartamento(Departamento departamento) {
	this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
	return contratos;
    }

    public void addContrato(ContratoHora contrato) {
	contratos.add(contrato);
    }

    public void removeContrato(ContratoHora contrato) {
	contratos.remove(contrato);
    }

    public Double rendimento(int ano, int mes) {
	Double soma = salarioBase;
	Calendar cal = Calendar.getInstance();
	for (ContratoHora c : contratos) {
	    cal.setTime(c.getData());
	    int c_Ano = cal.get(Calendar.YEAR);
	    int c_Mes = 1 + cal.get(Calendar.MONTH);
	    if (ano == c_Ano && mes == c_Mes) {
		soma += c.valorTotal();
	    }
	}
	return soma;

    }
}
