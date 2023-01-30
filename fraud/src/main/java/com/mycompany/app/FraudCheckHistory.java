package com.mycompany.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name =  "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Long id;
    private Long customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}
