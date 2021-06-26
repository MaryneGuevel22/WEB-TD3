package galerie.entity;
import java.util.*;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Tableau {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    private String titre;

    private String support;
    
    private String dimension;

    @OneToOne(mappedBy = "oeuvre")
    @ToString.Exclude
    private Transaction vendu;    
    
    @ManyToOne
    // Peut-être null
    Artiste auteur;

    @ToString.Exclude
    @ManyToMany(mappedBy= "oeuvres")
    private List<Exposition> accrochages = new LinkedList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public Transaction getVendu() {
		return vendu;
	}

	public void setVendu(Transaction vendu) {
		this.vendu = vendu;
	}

	public Artiste getAuteur() {
		return auteur;
	}

	public void setAuteur(Artiste auteur) {
		this.auteur = auteur;
	}

	public List<Exposition> getAccrochages() {
		return accrochages;
	}

	public void setAccrochages(List<Exposition> accrochages) {
		this.accrochages = accrochages;
	}
    
    
    
}
