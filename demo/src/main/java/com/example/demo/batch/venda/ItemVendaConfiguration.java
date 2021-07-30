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
import com.example.demo.entity.ItemVenda;

@Configuration
@EnableBatchProcessing
public class ItemVendaConfiguration extends BaseConfiguration {

	static final Logger log = Logger.getLogger(ItemVendaConfiguration.class);

	private static final int CHUNK = 10;

	@Bean(name = "itemVendaJob")
	public Job itemVendaJob(JobBuilderFactory jobs, @Qualifier("itemVendaJobStep") Step step) {
		return jobs.get("itemVendaJob").flow(step).end().build();
	}

	@Bean(name = "itemVendaJobStep")
	public Step step(StepBuilderFactory steps, 
			@Qualifier("itemVendaReader") ItemReader<? extends ItemVenda> reader,
			@Qualifier("itemVendaWriter") ItemWriter<ItemVenda> writer) {

		return steps.get("itemVendaJobStep").allowStartIfComplete(true).<ItemVenda, ItemVenda>chunk(CHUNK).reader(reader).writer(writer).build();
	}
	
	@Bean(name = "itemVendaReader")
	public FlatFileItemReader<ItemVenda> reader() {
		log.info("Iniciando Reader");
		return new FlatFileItemReaderBuilder<ItemVenda>()
				.name("itemVendaReader")
				.resource(new PathResource(localeFiles + "Sales.SalesOrderDetail.csv"))
				.linesToSkip(1)
				.delimited()
				.delimiter(";")
				//.names(super.getAttributesMap(ItemVenda.class))
				.names(new String[] { "vendaId", "itemVendaId", "carrierTrackingNumber", "orderQty", "produtoId", "specialOfferID",
				 "unitPrice", "unitPriceDiscount", "lineTotal", "rowGuid", "dataAlteracao" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<ItemVenda>() {
					{
						setTargetType(ItemVenda.class);
					}
				}).build();
	}

}
