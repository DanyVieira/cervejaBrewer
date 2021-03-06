package com.algaworks.model;

import java.io.Serializable;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.algaworks.validation.SKU;

@Entity  
@Table(name="cerveja")   //é uma tabela no banco
public class Cerveja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //é o identificador
	@GeneratedValue(strategy= GenerationType.IDENTITY) //usa auto-incremento
	private Long codigo; //identificador da tabela
	
	@SKU //aqui chamo a validação do SKU.java
	// com a exclamação so aplica a validação se houver dados
	@NotBlank(message="SKU é obrigatório") //para não aceitar valor nulo 
	private String sku;
	
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	
	@NotBlank(message="Descrição é obrigatório")
	@Size(min=1, max=50, message="Descricão deve ter no maximo 50 caracteres")
	private String descricao;
	
	//@NotNull(message="Valor é obrigatório")
	@DecimalMin("0.01")
	@DecimalMax(value="9999999.99", message="O valor da cerveja deve ser menor que R$9.999.999.999,99") 
	private Double valor;
	
	//@NotNull(message="Teor Alcoolico é obrigatório")
	@DecimalMax(value="100.0", message="O valor do teor alcoolico deve ser menor que 100") 
	@Column(name="teor_alcoolico") //nome da coluna no BD
	private Double teorAlcoolico;
	
	//@NotNull(message="Comissão é obrigatório")
	@DecimalMax(value="100.0", message="O comissão deve ser igual ou menor que 100") 
	private Double comissao;
	
	@NotNull(message="Estoque é obrigatório")
	@Max(value=9999, message="A quantidade de estoque deve ser menor que 9.999")
	@Column(name="quantidade_estoque") //nome da coluna no BD
	private Integer quantidadeEstoque;
	
	@NotNull(message="Origem é obrigatório")
	@Enumerated (EnumType.STRING) //forma como ira salvar no BD, neste caso ira salvar com as palavras nacional e internacional
	private Origem origem; //relacionamento com a tabela origem, que no caso é um enum
	
	@NotNull(message="Sabor é obrigatório")
	@Enumerated (EnumType.STRING)
	private Sabor sabor; //enum sabor
	
	@NotNull(message="Estilo é obrigatório")
	@ManyToOne //1 estilo pra n cervejas
	@JoinColumn(name="codigo_estilo")// como sera o relacionamento com a coluna estilo
	private Estilo estilo; //uma classe
	
	@Transient
	private String valorString;
	
	@Transient
	private String teorString;
	
	
	@Transient
	private String comissaoString;
	
	private String foto;
	
	@Column(name = "content_type")
	private String contentType;
	
	
	@PrePersist
	@PreUpdate
	private void prePersistUpdate(){  //Executa algumas tarefas antes de persistir e atualizar o dado
		sku= sku.toUpperCase(); //antes de jogar no BD ele transforma as letras em maiusculas.
	}
	
	public String getTeorString() {
		return teorString;
	}
	public void setTeorString(String teorString) {
		this.teorString = teorString;
	}
	public String getComissaoString() {
		return comissaoString;
	}
	public void setComissaoString(String comissaoString) {
		this.comissaoString = comissaoString;
	}
	public String getValorString() {
		return valorString;
	}
	public void setValorString(String valorString) {
		this.valorString = valorString;
	}
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getTeorAlcoolico() {
		return teorAlcoolico;
	}
	public void setTeorAlcoolico(Double teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
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
	
	
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
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


