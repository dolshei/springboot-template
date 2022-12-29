package com.template.springboot.mapper;

import com.template.springboot.model.TestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestDAO {
    List<TestDTO> getTestData();
}
