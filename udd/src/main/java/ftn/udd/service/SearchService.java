package ftn.udd.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ftn.udd.DTO.SearchRequestDTO;
import ftn.udd.DTO.SearchResultDTO;
import ftn.udd.lucene.model.IndexUnit;
import ftn.udd.lucene.search.SearchUtil;
import ftn.udd.mapper.CvMapper;

@Service
public class SearchService {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	private RestHighLevelClient client;
	
	@Autowired
	private CvMapper cvMapper;
	
	@Autowired
	public SearchService(RestHighLevelClient client) {
		this.client = client;
	}
	
	public List<SearchResultDTO> search(SearchRequestDTO dto){
		SearchRequest request = SearchUtil.buildSearchRequest(IndexUnit.INDEX_NAME, dto);
		return searchInternal(request);
		
	}
	
	private List<SearchResultDTO> searchInternal(SearchRequest request){
		if (request == null) {
			System.out.println("wtf nekad smo bili bff");
			return Collections.emptyList();
		}
		try {
			System.out.println("klijent");
			SearchResponse response = client.search(request, RequestOptions.DEFAULT);
			SearchHit[] searchHits = response.getHits().getHits();
			System.out.println("sta je misevi");
			List<SearchResultDTO> cvs = new ArrayList<>(searchHits.length);
			System.out.println("sta se desilo");
			System.out.println(searchHits.length);
			for (SearchHit hit: searchHits) {
				System.out.println(hit.getSourceAsString());
				IndexUnit i = mapper.readValue(hit.getSourceAsString(), IndexUnit.class);
				System.out.println("fatanena");
				cvs.add(cvMapper.map(i));
			}
			return cvs;
		}
		catch (Exception e) {
			System.out.println("eksception wtf nekad smo bili bff");

			return Collections.emptyList();
		}
		
	}
}
