package ftn.udd.mapper;

import org.springframework.stereotype.Component;

import ftn.udd.DTO.SearchResultDTO;
import ftn.udd.lucene.model.IndexUnit;

@Component
public class CvMapper {
	
	public SearchResultDTO map(IndexUnit i) {
		SearchResultDTO res = new SearchResultDTO();
		res.setIme(i.getIme());
		res.setPrezime(i.getPrezime());
		res.setStepen(i.getStepen());
		res.setDatum(i.getDatum());
		res.setSazetak(i.getText());
		return res;
	}
	
}
