package com.course.config;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.course.entity.Person;

@Configuration
public class CsvToDbBatchConfiguration {

	// Reader
    @Bean
    ItemReader<Person> personReader() {
        // 實作類別：平面文件
        FlatFileItemReader<Person> itemReader = new FlatFileItemReader<Person>();
        // 讀取資源
        itemReader.setResource(new ClassPathResource("sample-data.csv"));
        
        // 設定編碼格式為UTF8，避免中文亂碼
        itemReader.setEncoding("UTF-8");
        
        // 設定讀取器的名稱
        itemReader.setName("csv-reader");

        // 資料的第一行是標頭，不能讀入
        itemReader.setLinesToSkip(1);
        
        // 設定 LineMapper，定義資料行當中的如何映射
        itemReader.setLineMapper(getLineMapper());

        return itemReader;
    }
    
    private LineMapper<Person> getLineMapper() {
        // 針對輸入的每行資料進行處理

        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setNames("name", "gender", "city");

        // 將欄位映射到指定的物件類型
        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);
        
        // 將 LineTokenizer 和 FieldSetMapper 組合進入 LineMapper
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
    
	// Processor
	
	// Writer
	
	// Step
	
	// Job
}
