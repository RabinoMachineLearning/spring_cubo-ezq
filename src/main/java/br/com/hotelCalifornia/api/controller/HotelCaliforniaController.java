package br.com.hotelCalifornia.api.controller;

import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.domain.service.HotelCaliforniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/hotel")
public class HotelCaliforniaController {

    @Autowired
    private HotelCaliforniaService service;

    @GetMapping
    public List<HotelCaliforniaModel> hotelCaliforniaGetAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelCaliforniaModel> getHotelById(@PathVariable UUID id) {
        System.out.println("Buscando hotel com ID: " + id);
        Optional<HotelCaliforniaModel> hotel = service.buscarPorId(id);
        return hotel.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HotelCaliforniaModel> createHotel(@RequestBody HotelCaliforniaModel hotel) {
        HotelCaliforniaModel savedHotel = service.salvar(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    @PutMapping
    public ResponseEntity<HotelCaliforniaModel> updateHotel(@RequestBody HotelCaliforniaModel hotel) {
        Optional<HotelCaliforniaModel> updatedHotel = service.atualizar(hotel);
        return updatedHotel.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable UUID id) {
        if (service.deletar(id)) {
            return ResponseEntity.ok().body("Deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


   // @GetMapping(value ="/cnpj")
   // public ResponseEntity<Optional<HotelCaliforniaModel>> find(@PathVariable(value ="id") UUID id ){
     //   Optional<HotelCaliforniaModel> hotel = service.bucarCnpj(id);
       // if(service.bucarCnpj.isPresent()){
           //     ResponseEntity.status(HttpStatus.NOT_FOUND).body();
            
       // }
       // return ResponseEntity.status(HttpStatus.OK).body()
    //}
    
    
}
