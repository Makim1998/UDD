package ftn.udd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.udd.DTO.SearchRequestDTO;
import ftn.udd.DTO.SearchResultDTO;
import ftn.udd.service.SearchService;

@RestController
@RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("permitAll()")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping(value = "")
	public ResponseEntity<List<SearchResultDTO>> search(){
		System.out.println("provera da li uopste radi tj da li je povezan");
		SearchRequestDTO dto = new SearchRequestDTO();
		dto.setField("ime");
		dto.setSearchTerm("My Category");
		List<SearchResultDTO> result = searchService.search(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
