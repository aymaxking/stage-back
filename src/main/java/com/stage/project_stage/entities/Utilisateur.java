package com.stage.project_stage.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
	private String password=alphaNumericString(6);;
	private String matricule;
	public void copy(Optional<Utilisateur> u){
		id =u.get().getId();
		login=u.get().getLogin();
		matricule=u.get().getMatricule();
		password=u.get().getPassword();
		type=u.get().getType();
	}

	public static String alphaNumericString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

}
