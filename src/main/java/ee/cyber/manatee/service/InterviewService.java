package ee.cyber.manatee.service;

import ee.cyber.manatee.model.Application;
import ee.cyber.manatee.model.Interview;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.repository.InterviewRepository;
import ee.cyber.manatee.statemachine.ApplicationState;
import ee.cyber.manatee.statemachine.ApplicationStateMachine;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;


@Service
public class InterviewService {
    @Autowired
    ApplicationStateMachine applicationStateMachine;

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    public Interview scheduleInterview(Integer applicationId, Interview interview) {
        val draftApplication = applicationRepository.findById(applicationId).get();

        draftApplication.setApplicationState(ApplicationState.INTERVIEW);
        draftApplication.setUpdatedOn(OffsetDateTime.now());
        draftApplication.setInterview(interview);

        val application = applicationRepository.

        return
    }
}
