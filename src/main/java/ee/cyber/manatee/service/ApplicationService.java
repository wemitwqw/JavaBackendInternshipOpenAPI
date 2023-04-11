package ee.cyber.manatee.service;


import java.time.OffsetDateTime;
import java.util.List;

import ee.cyber.manatee.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ee.cyber.manatee.model.Application;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.statemachine.ApplicationState;
import ee.cyber.manatee.statemachine.ApplicationStateMachine;


@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final InterviewRepository interviewRepository;
    private final ApplicationStateMachine applicationStateMachine;

    public List<Application> getApplications() {
        List<Application> applications = applicationRepository.findAll();

        for (Application application : applications) {
            if (application.getApplicationState() == ApplicationState.INTERVIEW) {

            }
        }

        return applicationRepository.findAll();
    }


    public Application insertApplication(Application application) {
        application.setId(null);
        application.setApplicationState(ApplicationState.NEW);
        application.setUpdatedOn(OffsetDateTime.now());

        return applicationRepository.save(application);
    }

    public void rejectApplication(Integer applicationId) {
        applicationStateMachine.rejectApplication(applicationId);
    }


}
