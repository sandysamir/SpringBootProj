package com.firstSBM.FirstSpringBoot.repository;

import com.firstSBM.FirstSpringBoot.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour,Integer> {
//public interface TourRepository extends PagingAndSortingRepository<Tour,Integer> {

   //     Page<Tour> findByTourPackageCode(String tourPackage_code, Pageable pageable);
        List <Tour> findByTourPackageCode(String tourPackage_code);

        @Override
        @RestResource(exported = false)
        <S extends Tour> S save(S entity);

        @Override
        @RestResource(exported = false)

        <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

        @Override
        @RestResource(exported = false)

        void deleteById(Integer integer);
        @Override
        @RestResource(exported = false)
        void delete(Tour entity);

        @Override
        @RestResource(exported = false)
        void deleteAllById(Iterable<? extends Integer> integers);

        @Override
        @RestResource(exported = false)
        void deleteAll(Iterable<? extends Tour> entities);

        @Override
        @RestResource(exported = false)
        void deleteAll();
}
