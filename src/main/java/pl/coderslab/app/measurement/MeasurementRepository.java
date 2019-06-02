package pl.coderslab.app.measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.app.baby.Baby;

import java.awt.print.Book;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement,Long> {

    @Query(value = "select * from Measurements where baby_id= ?1 order by beginning desc limit 1", nativeQuery = true)
    Measurement findFirstByBabyIdOrderByBeginningDescQuery(Long id);

    void deleteMeasurementsByBaby_Id(Long Id);

//    @Query("select b from Book b where b.publisher.id = :publisherId")
//    List<Book> findByPublisherQuery(@Param("publisherId") Long id);
//
//    @Query(value = "select * from books where category_id = ?1 order by mytitle asc limit 1", nativeQuery = true)
//    Book findFirstByCategoryIdOrderByTitleQuery(Long id);
}
