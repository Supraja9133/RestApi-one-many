package com.RestApiJpaHibernateFinalExamMapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RestApiJpaHibernateFinalExamMapping.entity.Product;
import com.RestApiJpaHibernateFinalExamMapping.repository.ProductRepository;
@Service
public class ServiceImpl implements ServiceInt{
@Autowired
private ProductRepository repository;

public List<Product>findpaginated(int pageNo,int pageSize){
	Pageable paging=PageRequest.of(pageNo,pageSize);
	Page<Product>pagedResult=repository.findAll(paging);
	return pagedResult.toList();
}
}
