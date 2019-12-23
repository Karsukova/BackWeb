package com.myip.labs.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@JsonFormat(pattern = "dd.MM.yyyy")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer sum;

    @Column
    private Boolean isplus;

    @Column
    private String text;

    @Column
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @ManyToOne
    private Pocket pocket;
}
