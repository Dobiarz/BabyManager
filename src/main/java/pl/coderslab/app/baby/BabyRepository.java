package pl.coderslab.app.baby;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyRepository extends JpaRepository<Baby, Long> {
Baby findFirstByName(String name);
}
