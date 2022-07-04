package ftn.udd.DTO;

public class SearchItemDTO {
	private String operand;
	private String field;
	private String value;
	
	public SearchItemDTO() {
		super();
	}

	public SearchItemDTO(String operand, String field, String value) {
		super();
		this.operand = operand;
		this.field = field;
		this.value = value;
	}

	public String getOperand() {
		return operand;
	}

	public void setOperand(String operand) {
		this.operand = operand;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
