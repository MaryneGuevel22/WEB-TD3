package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity // Une entité JPA
public class Artiste extends Personne {
    @NotEmpty
    private String biographie;
    
    @OneToMany(mappedBy="auteur")
    @ToString.Exclude
    private List<Tableau> oeuvres = new LinkedList<>();

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public List<Tableau> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(List<Tableau> oeuvres) {
		this.oeuvres = oeuvres;
	}
    
    
}
