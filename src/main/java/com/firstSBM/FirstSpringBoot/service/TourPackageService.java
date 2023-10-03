package com.firstSBM.FirstSpringBoot.service;

import com.firstSBM.FirstSpringBoot.domain.TourPackage;
import com.firstSBM.FirstSpringBoot.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    private final TourPackageRepository tourPackageRepository;

    @Autowired

    public TourPackageService ( TourPackageRepository tourPackageRepository){

        this.tourPackageRepository = tourPackageRepository;
    }
    public TourPackage createTourPackage(String code , String name){
      return   tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code,name)));
    }
    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }
    public long totalCount(){
        return tourPackageRepository.count();
    }

}
