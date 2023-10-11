package com.example.demo.mapper;

import com.example.demo.repository.entity.LeaveRecord;
import com.example.demo.request.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface LeaveRecordMapper {

    LeaveRecord toEntity(LeaveRecordCreateRequest request);

    void toEntity(LeaveRecordReplaceRequest request, @MappingTarget LeaveRecord entity);

}
