package com.plan.model;

import java.util.List;

public class PlanTypeService {

    private PlanTypeDAO_interface dao;

    public PlanTypeService() {
        dao = new PlanTypeDAO();
    }

    

    public PlanTypeVO addPlanType(String planTypeId, String planName, Integer planDay) {
        PlanTypeVO planTypeVO = new PlanTypeVO();
        planTypeVO.setPlanTypeId(planTypeId);
        planTypeVO.setPlanName(planName);
        planTypeVO.setPlanDay(planDay);

        dao.insert(planTypeVO);
        return planTypeVO;

    }


   
    public PlanTypeVO updatePlanType(String planTypeId, String planName, Integer planDay) {
        PlanTypeVO planTypeVO = new PlanTypeVO();
        planTypeVO.setPlanTypeId(planTypeId);
        planTypeVO.setPlanName(planName);
        planTypeVO.setPlanDay(planDay);

        dao.update(planTypeVO);
        return planTypeVO;
    }

    
    public void deletePlanType(String planTypeId) {
        dao.delete(planTypeId);
    }

   
    public List<PlanTypeVO> getAll() {
        return dao.getAll();
    }

}
