package pl.coderslab.app.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public void create(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public Measurement read(Long id) {
        return measurementRepository.findById(id).orElse(null);
    }

    public void update(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public void delete(Long id) {
        measurementRepository.deleteById(id);
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findFirstByBabyIdOrderByBeginningDesc(Long id) {
        return measurementRepository.findFirstByBabyIdOrderByBeginningDescQuery(id);
    }
}
