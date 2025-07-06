package com.epam.team5;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.team5")
@EnableTransactionManagement
public class ApplicationConfig {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        var emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setPersistenceUnitName("maipu");
//        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        return emf;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:./data/data");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.epam.team5.model");
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        // Настройка Hibernate
        emf.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create");
        emf.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        emf.getJpaPropertyMap().put("hibernate.show_sql", true);

        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
