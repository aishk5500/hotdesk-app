package com.psl.hd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="citymaster")
public class CityMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityid;
    private boolean isactive;
    private String cityname;
    private String statename;
    private String country;
    private String pincode;
}
