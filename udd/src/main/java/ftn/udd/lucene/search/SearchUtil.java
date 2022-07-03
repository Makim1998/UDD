package ftn.udd.lucene.search;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import ftn.udd.DTO.SearchRequestDTO;


public class SearchUtil {
		
	public static SearchRequest buildSearchRequest(final String indexName, final SearchRequestDTO dto) {
		try {
			final SearchSourceBuilder builder = new SearchSourceBuilder()
					.postFilter(getQueryBuilder(dto));
			SearchRequest request = new SearchRequest(indexName);
			request.source(builder);
			
			return request;
		}
		catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static QueryBuilder getQueryBuilder(SearchRequestDTO dto){
		return QueryBuilders.matchPhraseQuery(dto.getField(), dto.getSearchTerm());
	}

}
