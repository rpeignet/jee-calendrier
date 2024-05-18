package fr.esgi.calendrier_ybr_rpt.business;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;

    @OneToMany(mappedBy = "typeReaction", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Reaction> reactions;

    public TypeReaction(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
}
