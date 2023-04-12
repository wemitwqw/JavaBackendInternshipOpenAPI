package ee.cyber.manatee.service;

import ee.cyber.manatee.model.Interview;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.repository.InterviewRepository;
import ee.cyber.manatee.statemachine.ApplicationStateMachine;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    ApplicationStateMachine applicationStateMachine;

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    public Interview scheduleInterview(Integer applicationId, Interview interview) {

        val application = applicationRepository.findById(applicationId).get();

        interview.setApplication(application);
        Interview savedInterview = interviewRepository.save(interview);

        application.setInterview(savedInterview);
        applicationRepository.save(application);

        applicationStateMachine.scheduledInterview(interview.getApplication().getId());

        return savedInterview;
    }
}
