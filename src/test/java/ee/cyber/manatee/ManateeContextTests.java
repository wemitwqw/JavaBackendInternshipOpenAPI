package ee.cyber.manatee;


import ee.cyber.manatee.api.InterviewApi;
import ee.cyber.manatee.mapper.InterviewMapper;
import ee.cyber.manatee.repository.InterviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ee.cyber.manatee.api.ApplicationApi;
import ee.cyber.manatee.mapper.ApplicationMapper;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.statemachine.ApplicationStateInterceptor;
import ee.cyber.manatee.statemachine.ApplicationStateMachine;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class ManateeContextTests {

    @Autowired
    private ApplicationApi applicationApi;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationStateMachine applicationStateMachine;

    @Autowired
    private ApplicationStateInterceptor applicationStateInterceptor;

    @Autowired
    private InterviewApi interviewApi;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private InterviewMapper interviewMapper;

    @Test
    void contextLoads() {
        assertNotNull(applicationApi);
        assertNotNull(applicationRepository);
        assertNotNull(applicationMapper);
        assertNotNull(applicationStateMachine);
        assertNotNull(applicationStateInterceptor);
        assertNotNull(interviewApi);
        assertNotNull(interviewRepository);
        assertNotNull(interviewMapper);
    }

}
