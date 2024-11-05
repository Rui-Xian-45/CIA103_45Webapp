package com.plan.model;


public class PlanTypeVO {
    private String planTypeId;
    private String planName;
    private Integer planDay;

    public PlanTypeVO() {
    }

    public PlanTypeVO(String planTypeId, String planName, Integer planDay) {
        this.planTypeId = planTypeId;
        this.planName = planName;
        this.planDay = planDay;
    }

	public String getPlanTypeId() {
		return planTypeId;
	}

	public void setPlanTypeId(String planTypeId) {
		this.planTypeId = planTypeId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getPlanDay() {
		return planDay;
	}

	public void setPlanDay(Integer planDay) {
		this.planDay = planDay;
	};



}

