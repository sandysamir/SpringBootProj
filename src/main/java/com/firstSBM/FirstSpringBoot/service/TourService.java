package com.firstSBM.FirstSpringBoot.service;

import com.firstSBM.FirstSpringBoot.domain.Difficulty;
import com.firstSBM.FirstSpringBoot.domain.Region;
import com.firstSBM.FirstSpringBoot.domain.Tour;
import com.firstSBM.FirstSpringBoot.domain.TourPackage;
import com.firstSBM.FirstSpringBoot.repository.TourPackageRepository;
import com.firstSBM.FirstSpringBoot.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {

    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository , TourPackageRepository tourPackageRepository){
      this.tourRepository=tourRepository;
      this.tourPackageRepository=tourPackageRepository;
    }
    public Tour create(String title, String description
            , String blurb, Integer price , String duration
            , String bullets , String keywords , String tourPackageName
            , Difficulty difficulty , Region region)
    {
        TourPackage tourPackage= tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(()-> new RuntimeException("Tour Package not exist "+ tourPackageName));
       return tourRepository.save( new Tour(title, description, blurb,
                price, duration, bullets, keywords, tourPackage,
                difficulty, region ));
    }
    public long count( ){
      return   tourRepository.count();
    }

    public TourPackageRepository getTourPackageRepository() {
        return tourPackageRepository;
    }


}
