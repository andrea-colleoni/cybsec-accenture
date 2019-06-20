package cybsec.accenture.l11SpringBoot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prodotto {
	
	@Id
	private int codiceProdotto;
	private String nome;
	private String descrizione;
	private double prezzoUnitario;
	private boolean attivo;
	private Date dataUltimoOrdine;
	
	public int getCodiceProdotto() {
		return codiceProdotto;
	}
	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	public Date getDataUltimoOrdine() {
		return dataUltimoOrdine;
	}
	public void setDataUltimoOrdine(Date dataUltimoOrdine) {
		this.dataUltimoOrdine = dataUltimoOrdine;
	}
	
	

}
