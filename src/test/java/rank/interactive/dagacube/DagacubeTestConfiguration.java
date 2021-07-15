package rank.interactive.dagacube;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import rank.interactive.dagacube.service.DagacubeService;


@Profile("test")
@Configuration
public class DagacubeTestConfiguration {
    @Bean
    @Primary
    public DagacubeService dagacubeService() {
        return Mockito.mock(DagacubeService.class);
    }
}

