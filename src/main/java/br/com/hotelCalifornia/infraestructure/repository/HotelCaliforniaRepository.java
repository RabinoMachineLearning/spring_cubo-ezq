package br.com.hotelCalifornia.infraestructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;

@Repository
public interface HotelCaliforniaRepository extends JpaRepository<HotelCaliforniaModel, UUID>{
    

//@Query(value ="SELECT * FROM hotel_california Where cnpj = :cnpj", nativeQuery = true)
//HotelCaliforniaModel findByCnpj(@Param("cnpj") String cnpj);


}
