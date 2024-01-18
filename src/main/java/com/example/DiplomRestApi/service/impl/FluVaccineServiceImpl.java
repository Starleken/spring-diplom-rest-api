package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.FluVaccineMapper;
import com.example.DiplomRestApi.repository.FluVaccineRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.FluVaccineService;
import com.example.DiplomRestApi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FluVaccineServiceImpl implements FluVaccineService {

    private final FluVaccineRepository fluVaccineRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final FluVaccineMapper mapper;

    @Override
    public List<FluVaccineEntity> findAll() {
        return fluVaccineRepository.findAll();
    }

    @Override
    public List<FluVaccineEntity> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        return fluVaccineRepository.findAllByStudent(findedStudent.get());
    }

    @Override
    public FluVaccineEntity create(FluVaccineCreateDto createDto) {
        FluVaccineEntity fluVaccine = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }
        fluVaccine.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        fluVaccine.setImageURL(imageUrl);

        return fluVaccineRepository.save(fluVaccine);
    }

    @Override
    public FluVaccineEntity update(FluVaccineUpdateDto updateDto) {
        Optional<FluVaccineEntity> findedEntity = fluVaccineRepository.
                findById(updateDto.getId());

        if (findedEntity.isEmpty()){
            throw new EntityNotFoundException("FluVaccine is not found");
        }

        FluVaccineEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setCreateDate(updateDto.getCreateDate());

        if (updateDto.getImage() != null){
            imageService.deleteImage(entityToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());
            entityToUpdate.setImageURL(imageUrl);
        }

        return fluVaccineRepository.save(entityToUpdate);
    }

    @Override
    public void delete(Long id) {
        Optional<FluVaccineEntity> fluVaccine = fluVaccineRepository.findById(id);

        if (fluVaccine.isEmpty()){
            throw new EntityNotFoundException("Vaccine is not found");
        }

        imageService.deleteImage(fluVaccine.get().getImageURL());
        fluVaccineRepository.deleteById(id);
    }
}
