package tn.esprit.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
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
