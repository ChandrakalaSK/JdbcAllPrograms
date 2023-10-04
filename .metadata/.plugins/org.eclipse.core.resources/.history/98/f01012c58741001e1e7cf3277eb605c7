package com.ineuron.CustomerManagement;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories
public class AppConfig {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean()
    {
        LocalEntityManagerFactoryBean factoryBean= new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("iNeuron");
        return  factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
    {
        JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;

    }
}
