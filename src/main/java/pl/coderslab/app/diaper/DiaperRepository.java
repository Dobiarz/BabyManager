package pl.coderslab.app.diaper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaperRepository extends JpaRepository<Diaper, Long> {
    void deleteDiapersByBaby_Id(Long Id);
}
