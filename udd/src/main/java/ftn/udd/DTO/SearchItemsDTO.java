package ftn.udd.DTO;

import java.util.List;

public class SearchItemsDTO {
	private List<SearchItemDTO> items;
	
	public SearchItemsDTO() {
		super();
	}

	public SearchItemsDTO(List<SearchItemDTO> items) {
		super();
		this.items = items;
	}

	public List<SearchItemDTO> getItems() {
		return items;
	}

	public void setItems(List<SearchItemDTO> items) {
		this.items = items;
	}
	
}
