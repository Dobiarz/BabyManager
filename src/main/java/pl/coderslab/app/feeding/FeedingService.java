package pl.coderslab.app.feeding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.diaper.Diaper;
import pl.coderslab.app.diaper.DiaperRepository;

import java.util.List;
@Service
@Transactional
public class FeedingService {
    @Autowired
    private FeedingRepository feedingRepository;

    public void create(Feeding feeding) {
        feedingRepository.save(feeding);
    }

    public Feeding read(Long id) { return feedingRepository.findById(id).orElse(null); }

    public void update(Feeding feeding) {
        feedingRepository.save(feeding);
    }

    public void delete(Long id) {
        feedingRepository.deleteById(id);
    }

    public List<Feeding> findAll() {
        return feedingRepository.findAll();
    }
}
