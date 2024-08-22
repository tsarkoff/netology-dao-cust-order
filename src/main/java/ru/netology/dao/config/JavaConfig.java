package ru.netology.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.netology.dao.repository.DaoCustOrderRepositoryImpl;
import ru.netology.dao.service.DaoCustOrderService;

@Configuration
public class JavaConfig {
//    @Bean
//    public DaoCustOrderRepositoryImpl daoRepository(NamedParameterJdbcTemplate daoTemplate) {
//        return new DaoCustOrderRepositoryImpl(daoTemplate);
//    }
//
//    @Bean
//    public DaoCustOrderService daoService(DaoCustOrderRepositoryImpl daoRepository) {
//        return new DaoCustOrderService(daoRepository);
//    }
}
