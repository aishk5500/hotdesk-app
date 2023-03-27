package com.psl.hd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="buildingmaster")
public class BuildingMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buildingid;
    private boolean isactive;
    private String buildingname;
    @JoinColumn(name="officeid")
    @ManyToOne
    private OfficeMaster officeid;
}
