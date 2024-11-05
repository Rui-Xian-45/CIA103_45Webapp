//import java.util.List;
//
//public class PlanTest {
//    public static void main(String[] args) {
//        PlanTypeDAO dao = new PlanTypeDAO();
//
//
//
//
//        //新增
//        PlanTypeVO newPlanType = new PlanTypeVO("D", "中國三日遊", 3);
//        dao.insert(newPlanType);
//
//
//        // 修改
//
//        PlanTypeVO planType = new PlanTypeVO();
//        planType.setPlanTypeId("C");
//        planType.setPlanName("紐約七日遊");
//        planType.setPlanDay(7);
//        dao.update(planType);
//
//        // 刪除
//
//        dao.delete("D");
//
//
//
//
//
//        // 查詢
//        List<PlanTypeVO> list = dao.getAll();
//        for (PlanTypeVO planType : list) {
//            System.out.print(planType.getPlanTypeId() + ", ");
//            System.out.print(planType.getPlanName() + ", ");
//            System.out.print(planType.getPlanDay());
//            System.out.println();
//        }
//    }
//}
//package com;


