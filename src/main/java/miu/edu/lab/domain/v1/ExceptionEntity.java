package miu.edu.lab.domain.v1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exceptions")
public class ExceptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;
    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;
    private String exceptionType;

    @Column(columnDefinition = "TEXT")
    private String exceptionMessage;

}

