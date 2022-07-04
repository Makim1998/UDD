package ftn.udd.lucene.search;


import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import ftn.udd.DTO.SearchItemDTO;
import ftn.udd.DTO.SearchItemsDTO;
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
    public static SearchRequest buildBooleanSearchRequest(String indexName,
        SearchItemsDTO dto) {
		try {
			final BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
			List<SearchItemDTO> items = dto.getItems();
			List<QueryBuilder> queries = new ArrayList<QueryBuilder>();
			
			// query za ime
			final QueryBuilder imeQuery = getQueryBuilder(items.get(0));
			// query za prezime
			final QueryBuilder prezimeQuery = getQueryBuilder(items.get(1));
			// query za stepen obrazvovanja
			final QueryBuilder stepenQuery = getQueryBuilder(items.get(2));
			// query za stepen obrazvovanja
			final QueryBuilder sadrzajQuery = getQueryBuilder(items.get(3));
			
			if(items.get(0).getValue() != "") {
				queries.add(imeQuery);
			}
			if(items.get(1).getValue() != "") {
				queries.add(prezimeQuery);
			}
			if(items.get(2).getValue() != "") {
				queries.add(stepenQuery);
			}
			if(items.get(3).getValue() != "") {
				queries.add(sadrzajQuery);
			}
			
			System.out.println(queries.size());
			
			for (int i = 0; i < queries.size(); i++) {
				if (items.get(i).getOperand().equals("Or")) {
					System.out.println("or");
					System.out.println(i);
					System.out.println(items.get(i).getField());
					System.out.println(items.get(i).getValue());
					boolQuery.should(queries.get(i));
				}
				else if (items.get(i).getOperand().equals("Not")) {
					System.out.println("not");
					System.out.println(i);
					System.out.println(items.get(i).getField());
					System.out.println(items.get(i).getValue());
					boolQuery.mustNot(queries.get(i));
				}
				else {
					System.out.println("and");
					System.out.println(i);
					System.out.println(items.get(i).getField());
					System.out.println(items.get(i).getValue());
					boolQuery.must(queries.get(i));
				}
			}			
			
			SearchSourceBuilder builder = new SearchSourceBuilder()
			.postFilter(boolQuery);
			

			final SearchRequest request = new SearchRequest(indexName);
			request.source(builder);
			System.out.println("kraj");
			return request;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static QueryBuilder getQueryBuilder(SearchItemDTO dto){
		return QueryBuilders.matchPhrasePrefixQuery(dto.getField(), dto.getValue());
	}
	
	public static QueryBuilder getQueryBuilder(SearchRequestDTO dto){
		return QueryBuilders.matchPhrasePrefixQuery(dto.getField(), dto.getSearchTerm());
	}

}
