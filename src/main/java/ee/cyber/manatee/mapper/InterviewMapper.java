package ee.cyber.manatee.mapper;

import ee.cyber.manatee.dto.InterviewDto;
import ee.cyber.manatee.model.Interview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//import java.util.List;
@Mapper(componentModel = "spring")
public interface InterviewMapper {

    @Mapping(target = "applicationId", source = "application.id")
    InterviewDto entityToDto(Interview entity);

    @Mapping(target = "application.id", source = "applicationId")
    Interview dtoToEntity(InterviewDto dto);

//    List<InterviewDto> entitiesToDtoList(List<Interview> entity);
}
