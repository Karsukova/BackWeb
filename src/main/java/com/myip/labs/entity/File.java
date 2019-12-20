package com.myip.labs.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class File {
    @Id
    @NonNull
    private String id;
    @NonNull
    private String url;
    @NonNull
    private String filename;

    @ManyToOne
    private Ad ad;
}
