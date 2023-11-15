package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.maciejbadziak.voteitbackend.IntegrationTest;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserRepository;

import static java.util.List.of;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.testUserEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserResourceTestData.testUserToBeRegisteredResource;

@AutoConfigureMockMvc
class UserRestControllerIntegrationTest extends IntegrationTest {

    private static final String ENDPOINT_URL = "/user/";
    private static final String REGISTRATION_URL = "registration";
    private static final String REGISTRATION_SUCCESSFUL_MESSAGE = "Hey %s, you are successfully registered!";
    private static final String REGISTRATION_EXCEPTION_MESSAGE = "User with this email (%s) already exists.";

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
        final ResultActions result = mvc.perform(get(ENDPOINT_URL + termometrUserEntity.getUsername()));

        // then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username", is(termometrUserEntity.getUsername())))
                .andExpect(jsonPath("$.email", is(termometrUserEntity.getEmail())))
                .andExpect(jsonPath("$.registrationDate", is(termometrUserEntity.getRegistrationDate().toString())));
    }

    @Test
    void shouldReturnSuccessfulResponseEntityForRegisteredUserTest() throws Exception {
        // given
        final UserResource userResource = testUserToBeRegisteredResource();
        final ObjectMapper mapper = new ObjectMapper();
        final String requestJson = mapper.writeValueAsString(userResource);

        // when
        final ResultActions result = mvc.perform(post(ENDPOINT_URL + REGISTRATION_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));

        // then
        result.andExpect(status().isCreated())
                .andExpect(content().string(String.format(REGISTRATION_SUCCESSFUL_MESSAGE, userResource.getUsername())));
    }

    @Test
    void shouldReturnConflictResponseEntityForAlreadyRegisteredEmailTest() throws Exception {
        // given
        final UserResource userResource = testUserToBeRegisteredResource();
        final ObjectMapper mapper = new ObjectMapper();
        final String requestJson = mapper.writeValueAsString(userResource);

        mvc.perform(post(ENDPOINT_URL + REGISTRATION_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated());

        // when
        final ResultActions result = mvc.perform(post(ENDPOINT_URL + REGISTRATION_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson));

        // then
        result.andExpect(status().isConflict())
                .andExpect(content().string(String.format(REGISTRATION_EXCEPTION_MESSAGE, userResource.getEmail())));
    }
}
