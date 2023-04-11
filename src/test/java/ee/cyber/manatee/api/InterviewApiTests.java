package ee.cyber.manatee.api;

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
                .builder().applicationId(5).interviewDateTime(OffsetDateTime.parse("2023-04-18T15:40:00.00+03:00")).build();

        val response = interviewApi.scheduleInterview(draftInterview);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        val interview = response.getBody();
        assertNotNull(interview);
        assertNotNull(interview.getId());
        assertNotNull(interview.getApplicationId());
        assertNotNull(interview.getInterviewDateTime());

        assertEquals(draftInterview.getApplicationId(),
                interview.getApplicationId());
        assertEquals(draftInterview.getInterviewDateTime(),
                interview.getInterviewDateTime());
    }

}
