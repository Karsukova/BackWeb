package com.myip.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PocketDTO {
    private Integer id;
    private String name;
    private Integer balance;
    private List<OperationDTO> operations;

}
