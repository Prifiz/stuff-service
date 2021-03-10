package com.github.prifiz.stuff.service;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.repository.StuffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StuffServiceImpl implements StuffService {

    private final StuffRepository stuffRepository;

    public Stuff create(Stuff stuff) {
        return stuffRepository.save(stuff);
    }

    @Override
    public void delete(long id) {
        stuffRepository.deleteById(id);
    }

    @Override
    public Stuff updateOrCreate(long id, Stuff stuff) {
        return stuffRepository.findById(id)
                .map(stf -> {
                    stf.setName(stuff.getName());
                    stf.setManufacturer(stuff.getManufacturer());
                    stf.setModel(stuff.getModel());
                    stf.setDescription(stuff.getDescription());
                    return stuffRepository.save(stf);
                })
                .orElseGet(() -> {
                    stuff.setId(id);
                    return stuffRepository.save(stuff);
                });
    }

    @Override
    public Stuff find(long id) throws StuffNotFoundException {
        Optional<Stuff> stuff = stuffRepository.findById(id);
        if (stuff.isPresent()) {
            return stuff.get();
        } else {
            throw new StuffNotFoundException(String.format("Stuff with id {} not found", id));
        }
    }

    @Override
    public Stuff update(long id, Stuff stuff) throws StuffNotFoundException {
        Optional<Stuff> existingStuff = stuffRepository.findById(id);

        if (existingStuff.isEmpty()) {
            throw new StuffNotFoundException("Can't update stuff which not exists");
        }

        Stuff stuffToUpdate = existingStuff.get();
        copyNonNullProperties(stuff, stuffToUpdate);
        stuffToUpdate.setId(id);
        return stuffRepository.save(stuffToUpdate);
    }

    private void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private String[] getNullPropertyNames(Object source) {
        final var src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        var emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
