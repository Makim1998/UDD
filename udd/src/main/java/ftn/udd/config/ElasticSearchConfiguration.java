package ftn.udd.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ftn.udd.repository")
@ComponentScan(basePackages = "ftn.udd.config")
public class ElasticSearchConfiguration extends AbstractElasticsearchConfiguration{

	    
	    @Value("${elasticsearch.host}:${elasticsearch.port}")
	    private String elasticUrl;

	    @Value("${elasticsearch.clustername}")
	    private String EsClusterName;
	    
		@Bean
		@Override
		public RestHighLevelClient elasticsearchClient() {
			final ClientConfiguration config = ClientConfiguration.builder()
					.connectedTo(elasticUrl)
					.build();
			return RestClients.create(config).rest();
		}

}
