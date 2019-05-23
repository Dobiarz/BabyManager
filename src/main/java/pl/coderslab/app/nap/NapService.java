package pl.coderslab.app.nap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class NapService {
    @Autowired
    private NapRepository napRepository;

    public void create(Nap nap) {
        napRepository.save(nap);
    }

    public Nap read(Long id) {
        return napRepository.findById(id).orElse(null);
    }

    public void update(Nap nap) {
        napRepository.save(nap);
    }

    public void delete(Long id) {
        napRepository.deleteById(id);
    }

    public List<Nap> findAll() {
        return napRepository.findAll();
    }
}
