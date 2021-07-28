package com.example.demo.batch.venda;

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
import com.example.demo.entity.Venda;

@Configuration
@EnableBatchProcessing
public class VendaConfiguration extends BaseConfiguration {

	static final Logger log = Logger.getLogger(VendaConfiguration.class);

	@Bean(name = "vendaJob")
	public Job vendaJob(JobBuilderFactory jobs, @Qualifier("vendaJobStep") Step step) {
		return jobs.get("vendaJob").flow(step).end().build();
	}

	@Bean(name = "vendaJobStep")
	public Step step(StepBuilderFactory steps, 
			@Qualifier("vendaReader") ItemReader<? extends Venda> reader,
			@Qualifier("vendaWriter") ItemWriter<Venda> writer) {

		return steps.get("vendaJobStep").allowStartIfComplete(true).<Venda, Venda>chunk(CHUNK).reader(reader).writer(writer).build();
	}
	
	@Bean(name = "vendaReader")
	public FlatFileItemReader<Venda> reader() {
		log.info("Iniciando Reader");
		return new FlatFileItemReaderBuilder<Venda>()
				.name("vendaReader")
				.resource(new PathResource(localeFiles.concat("Sales.SalesOrderHeader.csv")))
				.linesToSkip(1)
				.delimited()
				.delimiter(";")
				.names(super.getAttributesMap(Venda.class))
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Venda>() {
					{
						setTargetType(Venda.class);
					}
				}).build();
	}

}
