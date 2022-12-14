package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.maciejbadziak.voteitbackend.IntegrationTest;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserRepository;

import static java.util.List.of;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.testUserEntity;

@AutoConfigureMockMvc
class UserRestControllerIntegrationTest extends IntegrationTest {

    private static final String USERS_URL = "/user/";

    @Autowired
    private transient MockMvc mvc;

    @Autowired
    private transient UserRepository userRepository;

    @BeforeEach
    public void init() {
        userRepository.deleteAll();
    }

    @Test
    void shouldProvideUserByUsername() throws Exception {
        // given
        final UserEntity termometrUserEntity = termometrUserEntity();
        final UserEntity testUserEntity = testUserEntity();

        userRepository.saveAll(of(termometrUserEntity, testUserEntity));
        // when

        final ResultActions result = mvc.perform(get(USERS_URL + termometrUserEntity.getUsername()));
        // then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username", is(termometrUserEntity.getUsername())))
                .andExpect(jsonPath("$.email", is(termometrUserEntity.getEmail())))
                .andExpect(jsonPath("$.registrationDate", is(termometrUserEntity.getRegistrationDate().toString())));
    }
}
