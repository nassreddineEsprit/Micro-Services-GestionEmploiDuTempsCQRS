package tn.esprit.msjustification.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Justification {
    @Id
    private String idJustification;
    private String justificationName;
    private String justificationReason;
    private int justificationStatus;
    private Date justificationSubmissionDate;
    private Date justificationValidationDate;
    private String justificationFilePath;

}
