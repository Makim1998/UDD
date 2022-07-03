package ftn.udd.DTO;

public class SearchResultDTO {
	
	private String ime;
	private String prezime;
	private String highlight;
	
	public SearchResultDTO() {
		super();
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

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
		
}
