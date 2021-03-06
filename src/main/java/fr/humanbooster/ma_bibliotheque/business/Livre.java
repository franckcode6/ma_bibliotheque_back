package fr.humanbooster.ma_bibliotheque.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titre;

	private String isbn;

	@NotNull
	@Past
	private LocalDate dateDeParution;

	@NotNull
	@ManyToOne
	private Type type;

	@NotNull
	@ManyToOne
	private Editeur editeur;

	@NotNull
	@ManyToOne
	private Auteur auteur;

	@NotNull
	@ManyToOne
	private Categorie categorie;
	
	@ManyToOne
	private Utilisateur utilisateur;

	public Livre(String titre, String isbn, LocalDate dateDeParution, Type type, Editeur editeur, Auteur auteur,
			Categorie categorie, Utilisateur utilisateur) {
		this();
		this.titre = titre;
		this.isbn = isbn;
		this.dateDeParution = dateDeParution;
		this.type = type;
		this.editeur = editeur;
		this.auteur = auteur;
		this.categorie = categorie;
		this.utilisateur = utilisateur;

	}
}