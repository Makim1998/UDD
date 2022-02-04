package ftn.udd.lucene.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = IndexUnit.INDEX_NAME)
@Setting(settingPath = "static/es-settings.json")
public class IndexUnit {

	public static final String INDEX_NAME = "digitallibrary";
	public static final String TYPE_NAME = "book";
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	@Field(type = FieldType.Text, store = true)
	private String ime;
	@Field(type = FieldType.Text, store = true)
	private String prezime;
	@Field(type = FieldType.Text, store = true)
	private String stepen;
	@Field(type = FieldType.Text, store = true)
	private String text;
	@Id
	@Field(type = FieldType.Text,  store = true)
	private String filename;
	@Field(type = FieldType.Text, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	
	
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiledate() {
		return filedate;
	}
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}
	
}
