package eparliament.config;

import eparliament.dao.DeputyDao;
import eparliament.dao.mock.DeputyDaoMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexandrrusanov on 26/8/17.
 */
@Configuration
@ComponentScan({"eparliament.service", "eparliament.presentation"})
public class AppConfig {

    @Bean
    public DeputyDao deputyDaoMock() {
        DeputyDaoMock deputyDaoMock = new DeputyDaoMock();
        deputyDaoMock.initDeputyStorage();
        return deputyDaoMock;
    }
}
