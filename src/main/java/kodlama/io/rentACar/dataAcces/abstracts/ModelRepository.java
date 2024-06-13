package kodlama.io.rentACar.dataAcces.abstracts;

import kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
