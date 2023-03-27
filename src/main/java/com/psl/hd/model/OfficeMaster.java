package com.psl.hd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="officemaster")
public class OfficeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeid;
    private boolean isactive;
    private String officename;
    @ManyToOne
    @JoinColumn(name="cityid")
    private CityMaster cityid;
}
