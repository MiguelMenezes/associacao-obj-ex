package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {

		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public void adicionarContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}

	public Double totalValor(Integer ano, Integer mes) {

		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance();

		// Percorre a lista de contratos para achar os contratos do mes e ano passados
		// como parametro do método:
		for (HoraContrato c : contratos) {
			// pega a data do contrato e seta ela como data do calendario:
			calendario.setTime(c.getData());
			int c_ano = calendario.get(Calendar.YEAR);
			int c_mes = 1 + calendario.get(Calendar.MONTH);

			if (c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}

		return soma;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
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

	public List<HoraContrato> getContratos() {
		return contratos;
	}

}
