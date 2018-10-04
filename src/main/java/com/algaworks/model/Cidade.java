package com.algaworks.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity  
@Table(name="cidade")
public class Cidade implements Serializable{ //posso recuperar um determinado estado dessa entidade
	
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long codigo;
	

	@Size(max = 20, message = "O tamanho do nome não pode ser maior que {max} caracteres")
	@NotBlank(message="Nome é obrigatório")
	private String nome;

/*	@OneToMany(mappedBy = "estado") // um estilo pode ter uma lista de cerveja
	private List<Cidades> cervejas; //
*/	
	public Long getCodigo() { // vou colocar equal e hashcode em cima de codigo 
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}

	@NotNull(message="Estilo é obrigatório")
	@ManyToOne (fetch=FetchType.LAZY)//1 estilo pra n cervejas , lazy não vai mais inicializar o estado na consulta do hibernate     
	@JoinColumn(name="codigo_estado")// como sera o relacionamento com a coluna estilo
	@JsonIgnore // neste caso ao carregar os dados de cidade não carrego os dados de estado!!
	private Estado estado; //uma classe

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
}
