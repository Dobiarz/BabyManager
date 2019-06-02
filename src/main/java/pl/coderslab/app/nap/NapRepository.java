package pl.coderslab.app.nap;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NapRepository extends JpaRepository<Nap,Long> {
    void deleteNapsByBaby_Id(Long Id);

}
