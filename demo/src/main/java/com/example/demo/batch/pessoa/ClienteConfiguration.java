package com.example.demo.batch.pessoa;

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
import com.example.demo.entity.Cliente;

@Configuration
@EnableBatchProcessing
public class ClienteConfiguration extends BaseConfiguration {

	static final Logger log = Logger.getLogger(ClienteConfiguration.class);

	@Bean(name = "clienteJob")
	public Job clienteJob(JobBuilderFactory jobs, @Qualifier("clienteJobStep") Step step) {
		return jobs.get("clienteJob").flow(step).end().build();
	}

	@Bean(name = "clienteJobStep")
	public Step step(StepBuilderFactory steps, 
			@Qualifier("clienteReader") ItemReader<? extends Cliente> reader,
			@Qualifier("clienteWriter") ItemWriter<Cliente> writer) {

		return steps.get("clienteJobStep").allowStartIfComplete(true).<Cliente, Cliente>chunk(CHUNK).reader(reader).writer(writer).build();
	}
	
	@Bean(name = "clienteReader")
	public FlatFileItemReader<Cliente> reader() {
		log.info("Iniciando Reader");
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("clienteReader")
				.resource(new PathResource(localeFiles + "Sales.Customer.csv"))
				.linesToSkip(1)
				.delimited()
				.delimiter(";")
				.names(super.getAttributesMap(Cliente.class))
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Cliente>() {
					{
						setTargetType(Cliente.class);
					}
				}).build();
	}

}
