package com.stage.project_stage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sanction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private   Integer id;
	private String nombre;
	private String genreSanction;
	private   Integer aid;
	@ManyToOne
	private Antecedent antecedent;

	public Sanction(Integer id, String nombre, String genreSanction, Antecedent antecedent) {
		this.id = id;
		this.nombre = nombre;
		this.genreSanction = genreSanction;
		this.antecedent = antecedent;
		this.aid=antecedent.getId();
	}

}
