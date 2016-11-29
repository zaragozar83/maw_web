package com.coffee.maqzar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Configuration
@ComponentScan("com.coffee.maqzar")
public class RootApplicationContextConfig {

    /*
	@Bean
	public DriverManagerDataSource driverManagerDataSource() {
		String driverClassName = "com.mysql.jdbc.Driver";
		//String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
		String url = "jdbc:mysql://localhost:3306/maqzar";
		String username = "root";
		String password = "";
		DriverManagerDataSource res = new DriverManagerDataSource();
		res.setDriverClassName(driverClassName);
		res.setUrl(url);
		res.setUsername(username);
		res.setPassword(password);
		return res;
	}
	*/

    @Bean
    public DataSource dataSource(){

        String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://10.129.1.121:1433;databaseName=SICDB";
        String username = "S2001N000001";
        String password = "Cobranza2";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    NamedParameterJdbcTemplate getJdbcTamplate(){
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
