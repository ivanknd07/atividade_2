package br.ufc.atividade_2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AnuncioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="anuncio_generator")
	@SequenceGenerator(name="anuncio_generator", sequenceName ="anuncio_seq", allocationSize=1)	
	private int id;
	private String titulo;
	private String endereco;
	private float metros_quadr;
	private float metros_constr;
	private int qtd_quartos;
	private int qtd_banheiros;
	private int qtd_vag_gar;
	private double preco;
	private String status;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name ="user_id")
	@JsonIgnore
	private UserModel userModel;
	
	//Status (Possíveis valores: Pendente | Pronto)
	//Dono do anúncio (usuario_id)
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public float getMetros_quadr() {
		return metros_quadr;
	}
	public void setMetros_quadr(float metros_quadr) {
		this.metros_quadr = metros_quadr;
	}
	
	
	public float getMetros_constr() {
		return metros_constr;
	}
	public void setMetros_constr(float metros_constr) {
		this.metros_constr = metros_constr;
	}
	
	
	public int getQtd_quartos() {
		return qtd_quartos;
	}
	public void setQtd_quartos(int qtd_quartos) {
		this.qtd_quartos = qtd_quartos;
	}
	
	
	public int getQtd_banheiros() {
		return qtd_banheiros;
	}
	public void setQtd_banheiros(int qtd_banheiros) {
		this.qtd_banheiros = qtd_banheiros;
	}
	
	
	public int getQtd_vag_gar() {
		return qtd_vag_gar;
	}
	public void setQtd_vag_gar(int qtd_vag_gar) {
		this.qtd_vag_gar = qtd_vag_gar;
	}
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	public AnuncioModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AnuncioModel(int id, String titulo, String endereco, float metros_quadr, float metros_constr,
			int qtd_quartos, int qtd_banheiros, int qtd_vag_gar, double preco, String status, UserModel userModel) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.endereco = endereco;
		this.metros_quadr = metros_quadr;
		this.metros_constr = metros_constr;
		this.qtd_quartos = qtd_quartos;
		this.qtd_banheiros = qtd_banheiros;
		this.qtd_vag_gar = qtd_vag_gar;
		this.preco = preco;
		this.status = status;
		this.userModel = userModel;
	}
	@Override
	public String toString() {
		return "AnuncioModel [id=" + id + ", titulo=" + titulo + ", endereco=" + endereco + ", metros_quadr="
				+ metros_quadr + ", metros_constr=" + metros_constr + ", qtd_quartos=" + qtd_quartos
				+ ", qtd_banheiros=" + qtd_banheiros + ", qtd_vag_gar=" + qtd_vag_gar + ", preco=" + preco + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
