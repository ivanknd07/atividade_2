package br.ufc.atividade_2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="user_generator")
	@SequenceGenerator(name="user_generator", sequenceName ="user_seq", allocationSize=1)
	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private int senha;
	private String telefone;
	private String endereço;
	
	@OneToMany(mappedBy ="userModel")
	private List<AnuncioModel> anuncios_imoveis;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
	
	public List<AnuncioModel> getAnuncioModel() {
		return anuncios_imoveis;
	}
	public void setAnuncioModel(List<AnuncioModel> anuncioModel) {
		this.anuncios_imoveis = anuncioModel;
	}
	
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserModel(int id, String nome, String cpf, String email, int senha, String telefone, String endereço,
			List<AnuncioModel> anuncioModel) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereço = endereço;
		this.anuncios_imoveis = anuncios_imoveis;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
				+ ", telefone=" + telefone + ", endereço=" + endereço + ", anuncios_imoveis=" + anuncios_imoveis + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
