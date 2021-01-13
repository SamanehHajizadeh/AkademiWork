package com.springboot.codeChallenge;

import static org.assertj.core.api.Assertions.*;
import java.net.URL;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NumberControllerIT {
    private final static Logger log = Logger.getLogger(NumberControllerIT.class.getName());

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");

    }

    @Test
    public void getPerfectNumbers() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        log.info("response:" + response + "Base:"+ base);
        assertThat(response.getBody()).isEqualTo("Find all valid perfect numbers");
    }
}

