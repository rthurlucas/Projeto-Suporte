package br.com.suporteSenai.suporte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class DataConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/suporte?createDatabaseIfNotExist=true&useSSL=false&serverTimeZone=America/Sao_Paulo");

        dataSource.setUsername("root");
        dataSource.setPassword("senai@126");

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter()  {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        adapter.setDatabase(Database.MYSQL);

        adapter.setShowSql(true);

        adapter.setGenerateDdl(true);

        adapter.setDatabasePlatform("org.hibernate.dialect.Mys=SQL8Dialect");

        adapter.setPrepareConnection(true);

        return adapter;

    }
}
