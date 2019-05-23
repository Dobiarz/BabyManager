package pl.coderslab.app.feeding;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedingRepository extends JpaRepository<Feeding, Long> {
    Feeding findById(long id);
}
