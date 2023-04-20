package com.RestApiJpaHibernateFinalExamMapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiJpaHibernateFinalExamMapping.entity.Product;
import com.RestApiJpaHibernateFinalExamMapping.repository.ProductRepository;
import com.RestApiJpaHibernateFinalExamMapping.service.ServiceInt;

@RestController

public class AllController {
@Autowired
ProductRepository productRepository;
@Autowired
ServiceInt one;
@GetMapping("/api/products/{pageNo}/{pageSize}")
public List<Product>getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
return one.findpaginated(pageNo, pageSize);
}
@GetMapping("/sorting")
public Iterable<Product>getAllByCols(@RequestParam String field1){
return productRepository.findAll(Sort.by(Direction.DESC,field1));
}
@PostMapping("/api/products")
public ResponseEntity<Product>creatUser(@RequestBody Product user){
	Product savedUser=productRepository.save(user);
	return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
}
@GetMapping("/api/products")
public ResponseEntity<List<Product>>getAllUser(){
	List<Product> users=productRepository.findAll();
	return new ResponseEntity<>(users,HttpStatus.OK);
}
@GetMapping("/api/products/{id}")
public ResponseEntity<Product>getUserById(@PathVariable int id){
	Optional<Product> user=productRepository.findById(id);
	if(user.isPresent()) {
		return new ResponseEntity<>(user.get(),HttpStatus.OK);
	}else {
		
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
@PutMapping("/api/products/{id}")
public ResponseEntity<Product>updateUser(@PathVariable("id")int id,@RequestBody Product u){
	Optional<Product> user=productRepository.findById(id);
	if(user.isPresent()) {
		user.get().setName(u.getName());
		user.get().setProductno(u.getProductno());
		user.get().setCategories(u.getCategories());
		return new ResponseEntity<>(productRepository.save(user.get()),HttpStatus.OK);
		}else {
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
@DeleteMapping("/api/products/{id}")
public ResponseEntity<Void>deleteUser(@PathVariable("id")int id){
	Optional<Product> user=productRepository.findById(id);
	if(user.isPresent()) {
		productRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}

}
