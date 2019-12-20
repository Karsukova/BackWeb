package com.myip.labs.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NonNull
    private String fileId;
    @NonNull
    private String url;
    @NonNull
    private String filename;

    @ManyToOne
    private Ad ad;
}
