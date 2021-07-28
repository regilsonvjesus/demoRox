package com.example.demo.batch.pessoa;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

import com.example.demo.batch.BaseConfiguration;
import com.example.demo.entity.Pessoa;

@Configuration
@EnableBatchProcessing
public class PessoaConfiguration extends BaseConfiguration {
	
	static final Logger log = Logger.getLogger(PessoaConfiguration.class); 

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
    @Bean(name = "pessoaJob")
    public Job pessoaJob(JobBuilderFactory jobs, @Qualifier("pessoaJobStep") Step step) {
        return jobs.get("pessoaJob").flow(step).end().build();
    }
    
    @Bean(name = "pessoaJobStep")
    public Step step(StepBuilderFactory steps,
            @Qualifier("pessoaReader") ItemReader<? extends Pessoa> reader,
            @Qualifier("pessoaWriter") ItemWriter<Pessoa> writer,
            @Qualifier("pessoaProcessor") ItemProcessor<Pessoa, Pessoa> processor) {

        return steps.get("pessoaJobStep").allowStartIfComplete(true).<Pessoa, Pessoa>chunk(CHUNK)
                .reader(reader).processor(processor).writer(writer).build();
    }

    @Bean(name = "pessoaReader")
    public FlatFileItemReader<Pessoa> reader() {

        log.info("Iniciando Reader");
        return new FlatFileItemReaderBuilder<Pessoa>()
        	    .name("pessoaReader")
                .resource(new PathResource(localeFiles + "Person.Person.csv"))
                .linesToSkip(1)
                .delimited()
                .delimiter(";")
                .names(super.getAttributesMap(Pessoa.class))
        	    .fieldSetMapper(new BeanWrapperFieldSetMapper<Pessoa>() {{
        	      setTargetType(Pessoa.class);
        	    }})
        	    .build();
    }

}
