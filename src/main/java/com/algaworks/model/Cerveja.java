package com.algaworks.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity  
@Table(name="cerveja")   //é uma tabela no banco
public class Cerveja {
	
	@Id //é o identificador
	@GeneratedValue(strategy= GenerationType.IDENTITY) //usa auto-incremento
	private Long codigo; //identificador da tabela
	
//	@NotNull //aqui estou dizendo que sku não pode ser nulo tem que ser anotação do javax.validation.constraints
	@NotBlank(message="SKU é obrigatório") //para não aceitar valor nulo 
	private String sku;
	
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	
	@Size(min=1, max=50, message="Descricão deve ter no maximo 50 caracteres")
	private String descricao;
		
	private BigDecimal valor;
	
	@Column(name="teor_alcoolico") //nome da coluna no BD
	private BigDecimal teorAlcoolico;
	
	private BigDecimal comissao;
	
	@Column(name="quantidade_estoque") //nome da coluna no BD
	private Integer quantidadeEstoque;
	
	
	@Enumerated (EnumType.STRING) //forma como ira salvar no BD, neste caso ira salvar com as palavras nacional e internacional
	private Origem origem; //relacionamento com a tabela origem, que no caso é um enum
	
	
	@Enumerated (EnumType.STRING)
	private Sabor sabor; //enum sabor
	
	
	@ManyToOne //1 estilo pra n cervejas
	@JoinColumn(name="codigo_estilo")// como sera o relacionamento com a coluna estilo
	private Estilo estilo; //uma classe
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}
	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Origem getOrigem() {
		return origem;
	}
	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	public Sabor getSabor() {
		return sabor;
	}
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	
		
	}


