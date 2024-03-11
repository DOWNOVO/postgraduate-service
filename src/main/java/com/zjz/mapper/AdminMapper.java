package com.zjz.mapper;

import com.zjz.entity.po.Admission;
import com.zjz.entity.po.GeneralRegulations;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    boolean deleteAdmissionById(String admissionId);

    boolean updateAdmission(Admission admission);

    boolean insertAdmission(Admission admission);

    boolean deleteInformation(String informationId);

    boolean deleteGeneralRegulations(String generalRegulationsId);

    boolean insertGeneralRegulations(GeneralRegulations generalRegulations);

    boolean updateGeneralRegulations(GeneralRegulations generalRegulations);

    boolean deleteUser(String username);
}
