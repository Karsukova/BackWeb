package com.myip.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdDTO {
    private Integer id;
    private String topic;
    private String telnum;
    private String text;
    private String price;
}
