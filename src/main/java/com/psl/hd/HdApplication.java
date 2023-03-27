package com.psl.hd;

import com.psl.hd.model.SeatType;
import com.psl.hd.repository.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HdApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(HdApplication.class, args);
	}
	@Autowired
	private SeatTypeRepository seatTypeRepository;
	@Override
	public void run(String... args) throws Exception {
		SeatType s = new SeatType(1,"TL","TeamLead");
		seatTypeRepository.save(s);
		SeatType t = new SeatType(2,"C","Cubicle");
		seatTypeRepository.save(t);
	}
}
