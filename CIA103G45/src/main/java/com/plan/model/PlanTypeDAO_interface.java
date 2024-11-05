package com.plan.model;

import java.util.List;

public interface PlanTypeDAO_interface {
    public void insert(PlanTypeVO planTypeVO);
    public void update(PlanTypeVO planTypeVO);
    public void delete(String planTypeId);
    public List<PlanTypeVO> getAll();
}
