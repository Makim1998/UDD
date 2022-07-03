package ftn.udd.DTO;

public class SearchRequestDTO {
	private String searchTerm;
	private String field;
	
	public SearchRequestDTO() {
		super();
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}	
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
