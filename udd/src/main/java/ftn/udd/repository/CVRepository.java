package ftn.udd.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ftn.udd.lucene.model.IndexUnit;


public interface CVRepository extends ElasticsearchRepository<IndexUnit, String>  {

}
