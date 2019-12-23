package com.myip.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OperationDTO {
    private Integer id;
    private Integer sum;
    private Boolean isplus;
    private String text;
    private Date date;
}