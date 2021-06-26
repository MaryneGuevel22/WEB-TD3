package galerie.entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    private String intitule;
    
    private LocalDate debut = LocalDate.now();    
    
    private Integer duree = 10;
    
    @ManyToOne
    @NonNull
    Galerie organisateur;

    @ManyToMany
    @ToString.Exclude
    List<Tableau> oeuvres = new LinkedList<>();
    
    @OneToMany(mappedBy = "lieuDeVente")
    @ToString.Exclude
    private List<Transaction> ventes = new LinkedList<>();
    
    public float CA() {
        float result =0.0f;
        for (Transaction vente : ventes)
            result += vente.getPrixVente();
        return result;
        // Ca peut s'écrire en une seule ligne avec l'API Stream API.
        // cf. https://www.baeldung.com/java-stream-sum
        // return ventes.stream().map(vente -> vente.getPrixVente()).reduce(0f, Float::sum);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Galerie getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Galerie organisateur) {
		this.organisateur = organisateur;
	}

	public List<Tableau> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(List<Tableau> oeuvres) {
		this.oeuvres = oeuvres;
	}

	public List<Transaction> getVentes() {
		return ventes;
	}

	public void setVentes(List<Transaction> ventes) {
		this.ventes = ventes;
	}
    

}
