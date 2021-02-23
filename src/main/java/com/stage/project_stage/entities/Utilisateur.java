package com.stage.project_stage.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private String login;
	private String password;
	private String matricule;
	private String poste;

	public void copy(Optional<Utilisateur> u){
		id =u.get().getId();
		login=u.get().getLogin();
		matricule=u.get().getMatricule();
		password=u.get().getPassword();
		poste=u.get().getPoste();
		type=u.get().getType();
	}
}
