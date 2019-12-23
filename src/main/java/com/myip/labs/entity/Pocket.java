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
@Table(name = "pocket")
public class Pocket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer balance;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "pocket", fetch = FetchType.EAGER)
    private List<Operation> operations;
}
