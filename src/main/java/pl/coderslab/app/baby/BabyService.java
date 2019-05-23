package pl.coderslab.app.baby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BabyService {
    @Autowired
    private BabyRepository babyRepository;

    public void create(Baby baby) {
        babyRepository.save(baby);
    }

    public Baby read(Long id) { return babyRepository.findById(id).orElse(null); }

    public void update(Baby baby) {
        babyRepository.save(baby);
    }

    public void delete(Long id) {
        babyRepository.deleteById(id);
    }

    public List<Baby> findAll() {
        return babyRepository.findAll();
    }
}
