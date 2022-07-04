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

import ftn.udd.DTO.SearchItemsDTO;
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
	
	public List<SearchResultDTO> search(SearchItemsDTO dto){
		SearchRequest request = SearchUtil.buildBooleanSearchRequest(IndexUnit.INDEX_NAME, dto);
		return searchInternal(request);
		
	}
	
	public List<SearchResultDTO> searchBase(SearchRequestDTO dto){
		SearchRequest request = SearchUtil.buildSearchRequest(IndexUnit.INDEX_NAME, dto);
		return searchInternal(request);
		
	}
	
	private List<SearchResultDTO> searchInternal(SearchRequest request){
		if (request == null) {
			return Collections.emptyList();
		}
		try {
			SearchResponse response = client.search(request, RequestOptions.DEFAULT);
			SearchHit[] searchHits = response.getHits().getHits();

			List<SearchResultDTO> cvs = new ArrayList<>(searchHits.length);
			for (SearchHit hit: searchHits) {
				String junk = hit.getSourceAsString();
				System.out.println(junk);
				String without_junk = "{" + junk.substring(junk.indexOf(',') + 1);
				System.out.println(without_junk);
				IndexUnit i = mapper.readValue(without_junk, IndexUnit.class);
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
