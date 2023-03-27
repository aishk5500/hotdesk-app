package com.psl.hd.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="seattype")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int seattypeid;
    private String seatcode;
    private String seatname;
}
