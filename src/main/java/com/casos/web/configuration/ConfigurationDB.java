package com.casos.web.configuration;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDB  {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationDB.class);
    @Bean
    public DataSource dataSource() throws SQLException {
        logger.info("Conectando a la BD...");
        DataSource dataSource = DataSourceBuilder
                .create()
                .url("jdbc:postgresql://localhost:5432/casos_demo")
                .username("postgres")
                .password("password")
                .build();
        if(dataSource.getConnection() != null) {
            logger.info("Conexión exitosa a la BD.");
        } else {
            logger.error("No se pudo conectar a la BD.");
        }
        return dataSource;
    }
}
