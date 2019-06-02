package pl.coderslab.app.feeding;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedingRepository extends JpaRepository<Feeding, Long> {
    void deleteFeedingsByBaby_Id(Long Id);

}
