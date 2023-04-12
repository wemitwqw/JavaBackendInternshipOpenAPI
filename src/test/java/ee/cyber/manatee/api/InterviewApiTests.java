package ee.cyber.manatee.api;

import ee.cyber.manatee.dto.ApplicationDto;
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

        val draftInterview = InterviewDto
                .builder().interviewDateTime(OffsetDateTime.parse("2023-04-18T15:40:00.00+03:00")).build();

        val response = interviewApi.scheduleInterview(5, draftInterview);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        val interview = response.getBody();
        assertNotNull(interview);
        assertNotNull(interview.getId());
        assertNotNull(interview.getInterviewDateTime());

        assertEquals(draftInterview.getInterviewDateTime(),
                interview.getInterviewDateTime());
    }

    @Test
    public void submitInterviewWithNullDate() {

        val draftInterview = InterviewDto
                .builder().build();

        val response = interviewApi.scheduleInterview(5, draftInterview);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }

}
