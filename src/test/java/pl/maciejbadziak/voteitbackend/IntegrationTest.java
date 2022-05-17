package pl.maciejbadziak.voteitbackend;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.transaction.Transactional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.testcontainers.containers.PostgreSQLContainer.IMAGE;

@ActiveProfiles("integration-test")
@AutoConfigureTestDatabase(replace = NONE)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Transactional
@DirtiesContext
public class IntegrationTest {

    protected static final PostgreSQLContainer<?> POSTGRES_CONTAINER = new PostgreSQLContainer<>(IMAGE);

    static {
        POSTGRES_CONTAINER.start();
    }

    protected IntegrationTest() {

    }

    @DynamicPropertySource
    static void properties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
    }
}
