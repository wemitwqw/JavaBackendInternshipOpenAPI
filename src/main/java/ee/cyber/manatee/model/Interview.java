package ee.cyber.manatee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Interview {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Application application;

    @NotNull
    private LocalDateTime interviewDateTime;

    @NotNull
    private String interviewerName;
}
