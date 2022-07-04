package ftn.udd.lucene.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = IndexUnit.INDEX_NAME)
@Setting(settingPath = "static/es-settings.json")
public class IndexUnit {

	public static final String INDEX_NAME = "job_apps";
	public static final String TYPE_NAME = "cv";
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	@Field(type = FieldType.Text, store = true)
	private String ime;
	@Field(type = FieldType.Text, store = true)
	private String prezime;
	@Field(type = FieldType.Text, store = true)
	private String stepen;
	@Field(type = FieldType.Date, store = true)
	private Date datum;
	@Field(type = FieldType.Text, store = true)
	private String text;
	@Id
	@Field(type = FieldType.Text,  store = true)
	private String filename;
	@Field(type = FieldType.Text, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	@Field(type = FieldType.Double, store = true)
	private double latitude;
	@Field(type = FieldType.Double, store = true)
	private double longitude;
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public static String getIndexName() {
		return INDEX_NAME;
	}
	public static String getTypeName() {
		return TYPE_NAME;
	}
	public static String getDatePattern() {
		return DATE_PATTERN;
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
