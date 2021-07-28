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
import com.example.demo.entity.Oferta;

@Configuration
@EnableBatchProcessing
public class OfertaConfiguration extends BaseConfiguration {

	static final Logger log = Logger.getLogger(OfertaConfiguration.class);

	private static final int CHUNK = 10;

	@Bean(name = "ofertaJob")
	public Job ofertaJob(JobBuilderFactory jobs, @Qualifier("ofertaJobStep") Step step) {
		return jobs.get("ofertaJob").flow(step).end().build();
	}

	@Bean(name = "ofertaJobStep")
	public Step step(StepBuilderFactory steps, 
			@Qualifier("ofertaReader") ItemReader<? extends Oferta> reader,
			@Qualifier("ofertaWriter") ItemWriter<Oferta> writer) {

		return steps.get("ofertaJobStep").allowStartIfComplete(true).<Oferta, Oferta>chunk(CHUNK).reader(reader).writer(writer).build();
	}
	
	@Bean(name = "ofertaReader")
	public FlatFileItemReader<Oferta> reader() {
		log.info("Iniciando Reader");
		return new FlatFileItemReaderBuilder<Oferta>()
				.name("ofertaReader")
				.resource(new PathResource(localeFiles + "Sales.SpecialOfferProduct.csv"))
				.linesToSkip(1)
				.delimited()
				.delimiter(";")
				.names(super.getAttributesMap(Oferta.class))
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Oferta>() {
					{
						setTargetType(Oferta.class);
					}
				}).build();
	}

}
