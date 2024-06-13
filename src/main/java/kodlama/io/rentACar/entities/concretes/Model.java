package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(name="name")
    private String name;


    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;


}
