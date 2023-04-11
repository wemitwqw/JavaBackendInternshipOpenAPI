package ee.cyber.manatee.api;

import ee.cyber.manatee.dto.ApplicationDto;
import ee.cyber.manatee.dto.CandidateDto;
import ee.cyber.manatee.dto.InterviewDto;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InterviewApiTests {

    @Autowired
    private InterviewApi interviewApi;

    @Test
    public void submitInterviewWithValidData() {
        val draftCandidate = CandidateDto
                .builder().firstName("Jenny").lastName("Doe").build();
        val draftApplication = ApplicationDto
                .builder().candidate(draftCandidate).build();

        val draftInterview = InterviewDto
                .builder().applicationId(5).interviewDateTime(OffsetDateTime.parse("2023-04-18T15:40:00.00+03:00")).build();

        val response = applicationApi.addApplication(draftApplication);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        val application = response.getBody();
        assertNotNull(application);
        assertNotNull(application.getId());
        assertNotNull(application.getApplicationState());
        assertNotNull(application.getUpdatedOn());

        assertEquals(draftApplication.getCandidate().getFirstName(),
                application.getCandidate().getFirstName());
        assertEquals(draftApplication.getCandidate().getLastName(),
                application.getCandidate().getLastName());
    }

}
