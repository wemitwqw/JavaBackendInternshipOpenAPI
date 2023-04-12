package ee.cyber.manatee.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ee.cyber.manatee.dto.InterviewDto;
import ee.cyber.manatee.api.InterviewApi;
import ee.cyber.manatee.mapper.InterviewMapper;
import ee.cyber.manatee.service.InterviewService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Slf4j
@RestController
@RequiredArgsConstructor
public class InterviewApiImpl implements InterviewApi {

    private final InterviewMapper interviewMapper;

    private final InterviewService interviewService;

    @Override
    public ResponseEntity<InterviewDto> scheduleInterview(Integer applicationId, InterviewDto interviewDto) {
        val draftInterview = interviewMapper.dtoToEntity(interviewDto);
        val interview = interviewService.scheduleInterview(applicationId, draftInterview);

        return ResponseEntity.status(CREATED)
                .body(interviewMapper.entityToDto(interview));
    }

}
