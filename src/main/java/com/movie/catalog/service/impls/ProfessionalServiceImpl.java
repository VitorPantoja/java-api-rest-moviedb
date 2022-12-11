package com.movie.catalog.service.impls;

import com.movie.catalog.models.Professional;
import com.movie.catalog.repositories.ProfessionalRepository;
import com.movie.catalog.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository professionalRepository;
    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Professional save(String professional) {
        return professionalRepository.saveAndFlush(Professional
                .builder()
                .setName(professional)
                .build());
    }

    @Override
    @Transactional(readOnly = true)
    public Professional findById(Long id) {
        return professionalRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delete(Long id) {
        professionalRepository.deleteById(id);
    }
}
