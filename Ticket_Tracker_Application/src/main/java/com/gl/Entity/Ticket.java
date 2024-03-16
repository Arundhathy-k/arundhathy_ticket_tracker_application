package com.gl.Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	String description;
	String content;
	String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
}
