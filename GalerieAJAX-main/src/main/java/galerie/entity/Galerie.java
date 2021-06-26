package galerie.entity;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
   
    @NonNull
    private String adresse;
    
	@JsonIgnore // Ne pas inclure dans le format JSON
	@XmlTransient  // Ne pas inclure dans le format XML
	@ToString.Exclude  // Ne pas inclure dans le toString
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "organisateur")
    List<Exposition> evenements = new LinkedList<>();
    
    public float CAannuel(int annee) {
        return evenements.stream()
                .filter( expo -> expo.getDebut().getYear() == annee)
                .map(expo -> expo.CA())
                .reduce(0f, Float::sum);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Exposition> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Exposition> evenements) {
		this.evenements = evenements;
	}
    
}
