package com.zjz.service;

import com.zjz.entity.po.Admission;
import com.zjz.entity.po.GeneralRegulations;
import com.zjz.untils.Result;

public interface AdminService {
    Result deleteAdmission(String admissionId, String path);

    Result updateAdmission(Admission admission, String path);

    Result insertAdmission(Admission admission, String path);

    Result deleteInformation(String informationId, String path);

    Result deleteGeneralRegulations(String generalRegulationsId, String path);

    Result insertGeneralRegulations(GeneralRegulations generalRegulations, String path);

    Result updateGeneralRegulations(GeneralRegulations generalRegulations, String path);

    Result deleteUser(String username, String path);
}
