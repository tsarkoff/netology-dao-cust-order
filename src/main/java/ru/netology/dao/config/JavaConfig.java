package ru.netology.dao.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
//    @Bean
//    public DaoCustOrderRepositoryImpl daoRepository(NamedParameterJdbcTemplate daoTemplate) {
//        return new DaoCustOrderRepositoryImpl((EntityManager) daoTemplate);
//    }
//
//    @Bean
//    public DaoCustOrderService daoService(DaoCustOrderRepositoryImpl daoRepository) {
//        return new DaoCustOrderService(daoRepository);
//    }
//
//    This below announced that we can create Liquibase NOT automatically and AFTER other Beans created
//    see https://www.baeldung.com/liquibase-refactor-schema-of-java-app
//    But not working for me : failed that CIRCUIT instances of Liquibase creating during STARTUP
//    @Bean
//    public SpringLiquibase liquibase(@Qualifier("taskExecutor") TaskExecutor taskExecutor,
//                                     DataSource dataSource,
//                                     LiquibaseProperties liquibaseProperties) {
//        // Use liquibase.integration.spring.SpringLiquibase if you don't want Liquibase to start asynchronously
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
//        liquibase.setContexts(liquibaseProperties.getContexts());
//        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
//        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
//        liquibase.setShouldRun(liquibaseProperties.isEnabled());
//        return liquibase;
//    }
}
