package fr.esgi.calendrier_ybr_rpt.business;

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
    private List<Reaction> reactions;

    public TypeReaction(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
}
