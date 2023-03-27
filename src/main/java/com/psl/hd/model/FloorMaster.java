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
@Table(name="floormaster")
public class FloorMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int floorid;
    private boolean isactive;
    private String floorname;
    private String floorplan;
    @JoinColumn(name="buildingid")
    @ManyToOne
    private BuildingMaster buildingid;
}
