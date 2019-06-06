package pl.coderslab.app.feeding;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FeedingRepository extends JpaRepository<Feeding, Long> {
    void deleteFeedingsByBaby_Id(Long Id);
    List<Feeding> findAllByBeginning(LocalDateTime localDateTime);

}
