package com.RestApiJpaHibernateFinalExamMapping.service;

import java.util.List;

import com.RestApiJpaHibernateFinalExamMapping.entity.Product;

public interface ServiceInt {
public List<Product>findpaginated(int pageNo,int pageSize);
}
