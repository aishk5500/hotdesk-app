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
@Table(name="seat")
public class SeatMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatid;
    private boolean isactive;
    private int cubibleposition;
    private String qrnumber;
    private int seatnumber;
    private String seattype;
    @JoinColumn(name="floorid")
    @ManyToOne
    private FloorMaster floorid;
    @JoinColumn(name = "seattypeid")
    @ManyToOne
    private SeatType seattypeid;
}
