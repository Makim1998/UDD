package ftn.udd.DTO;

public class RequestDTO {
	private String ime;
	private String prezime;
	private String stepen;
	
	public RequestDTO() {
		super();
	}

	public RequestDTO(String ime, String prezime, String stepen) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.stepen = stepen;
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

}
