package pl.coderslab.app.baby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.diaper.DiaperRepository;
import pl.coderslab.app.feeding.FeedingRepository;
import pl.coderslab.app.measurement.MeasurementRepository;
import pl.coderslab.app.nap.NapRepository;

import java.util.List;

@Service
@Transactional
public class BabyService {
    @Autowired
    private BabyRepository babyRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private DiaperRepository diaperRepository;

    @Autowired
    private FeedingRepository feedingRepository;

    @Autowired
    private NapRepository napRepository;

    public void create(Baby baby) {
        babyRepository.save(baby);
    }

    public Baby read(Long id) {
        return babyRepository.findById(id).orElse(null);
    }

    public void update(Baby baby) {
        babyRepository.save(baby);
    }

    public void delete(Long id) {
        measurementRepository.deleteMeasurementsByBaby_Id(id);
        diaperRepository.deleteDiapersByBaby_Id(id);
        feedingRepository.deleteFeedingsByBaby_Id(id);
        napRepository.deleteNapsByBaby_Id(id);
        babyRepository.deleteById(id);
    }

    public List<Baby> findAll() {
        return babyRepository.findAll();
    }

    public boolean isNameAlreadyInUse(String name) {
        boolean babyInDataBase = true;

        if (babyRepository.findFirstByName(name) == null) {
            babyInDataBase = false;
        }

        return babyInDataBase;
    }
}
