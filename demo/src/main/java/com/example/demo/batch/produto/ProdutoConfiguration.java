package com.example.demo.batch.produto;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

import com.example.demo.batch.BaseConfiguration;
import com.example.demo.entity.Produto;

@Configuration
@EnableBatchProcessing
public class ProdutoConfiguration extends BaseConfiguration {

	static final Logger log = Logger.getLogger(ProdutoConfiguration.class);

	private static final int CHUNK = 10;

	@Bean(name = "produtoJob")
	public Job produtoJob(JobBuilderFactory jobs, @Qualifier("produtoJobStep") Step step) {
		return jobs.get("produtoJob").flow(step).end().build();
	}

	@Bean(name = "produtoJobStep")
	public Step step(StepBuilderFactory steps, 
			@Qualifier("produtoReader") ItemReader<? extends Produto> reader,
			@Qualifier("produtoWriter") ItemWriter<Produto> writer) {

		return steps.get("produtoJobStep").allowStartIfComplete(true).<Produto, Produto>chunk(CHUNK).reader(reader).writer(writer).build();
	}
	
	@Bean(name = "produtoReader")
	public FlatFileItemReader<Produto> reader() {
		log.info("Iniciando Reader");
		return new FlatFileItemReaderBuilder<Produto>()
				.name("produtoReader")
				.resource(new PathResource(localeFiles + "Production.Product.csv"))
				.linesToSkip(1)
				.delimited()
				.delimiter(";")
				.names(super.getAttributesMap(Produto.class))
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Produto>() {
					{
						setTargetType(Produto.class);
					}
				}).build();
	}

}
