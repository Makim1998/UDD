package ftn.udd.DTO;

import java.util.Date;

public class SearchResultDTO {
	private Date datum;
	private String ime;
	private String prezime;
	private String stepen;
	private String sazetak;
	
	public SearchResultDTO() {
		super();
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getStepen() {
		return stepen;
	}

	public void setStepen(String stepen) {
		this.stepen = stepen;
	}

	public String getSazetak() {
		return sazetak;
	}

	public void setSazetak(String sazetak) {
		this.sazetak = sazetak;
	}
		
}
