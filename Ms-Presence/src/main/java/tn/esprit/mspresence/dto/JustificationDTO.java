package tn.esprit.mspresence.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class JustificationDTO {
    private String idJustification;
    private String justificationName;
    private String justificationReason;
    private int justificationStatus;
    private Date justificationSubmissionDate;
    private Date justificationValidationDate;
    private String justificationFilePath;
}
