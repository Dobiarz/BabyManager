package pl.coderslab.app.diaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyRepository;

import java.util.List;

@Service
@Transactional
public class DiaperService {
    @Autowired
    private DiaperRepository diaperRepository;

    public void create(Diaper diaper) {
        diaperRepository.save(diaper);
    }

    public Diaper read(Long id) { return diaperRepository.findById(id).orElse(null); }

    public void update(Diaper diaper) {
        diaperRepository.save(diaper);
    }

    public void delete(Long id) {
        diaperRepository.deleteById(id);
    }

    public List<Diaper> findAll() {
        return diaperRepository.findAll();
    }
}
