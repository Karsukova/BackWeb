package com.myip.labs.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String topic;

    @Column
    private String price;

    @Column
    private String text;

    @Column
    private String telnum;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ad")
    private List<File> files;
}
