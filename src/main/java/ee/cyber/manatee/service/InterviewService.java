package ee.cyber.manatee.service;

import ee.cyber.manatee.model.Interview;
import ee.cyber.manatee.repository.InterviewRepository;
import ee.cyber.manatee.statemachine.ApplicationStateMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class InterviewService {
    @Autowired
    ApplicationStateMachine applicationStateMachine;

    @Autowired
    InterviewRepository interviewRepository;

    public Interview scheduleInterview(Interview interview) {

        Interview savedInterview = interviewRepository.save(interview);

        applicationStateMachine.scheduledInterview(interview.getApplication().getId());

        return savedInterview;
    }
}
