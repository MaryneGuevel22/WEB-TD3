package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    @ManyToOne
    private Personne client;
   
    @NonNull
    @OneToOne
    private Tableau oeuvre;
    
    @NonNull
    @ManyToOne
    private Exposition lieuDeVente;
    
    @NonNull
    private Float prixVente;
    
    private LocalDate venduLe = LocalDate.now();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Personne getClient() {
		return client;
	}

	public void setClient(Personne client) {
		this.client = client;
	}

	public Tableau getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Tableau oeuvre) {
		this.oeuvre = oeuvre;
	}

	public Exposition getLieuDeVente() {
		return lieuDeVente;
	}

	public void setLieuDeVente(Exposition lieuDeVente) {
		this.lieuDeVente = lieuDeVente;
	}

	public Float getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Float prixVente) {
		this.prixVente = prixVente;
	}

	public LocalDate getVenduLe() {
		return venduLe;
	}

	public void setVenduLe(LocalDate venduLe) {
		this.venduLe = venduLe;
	}
    
    
    
}
