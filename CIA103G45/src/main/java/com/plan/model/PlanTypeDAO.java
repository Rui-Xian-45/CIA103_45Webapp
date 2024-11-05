package com.plan.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PlanTypeDAO implements PlanTypeDAO_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/plandb?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "P@ssw0rd";

    private static final String INSERT_STMT =
            "INSERT INTO PlanType (planTypeId, planName, planDay) VALUES (?, ?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT planTypeId, planName, planDay FROM PlanType";
    private static final String GET_ONE_STMT =
            "SELECT planTypeId, planName, planDay FROM PlanType WHERE planTypeId = ?";
    private static final String DELETE =
            "DELETE FROM PlanType WHERE planTypeId = ?";
    private static final String UPDATE =
            "UPDATE PlanType SET planName=?, planDay=? WHERE planTypeId = ?";


    @Override
    public void insert(PlanTypeVO planTypeVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setString(1, planTypeVO.getPlanTypeId());
            pstmt.setString(2, planTypeVO.getPlanName());
            pstmt.setInt(3, planTypeVO.getPlanDay());
            pstmt.executeUpdate();

            System.out.println("Inserted: " + planTypeVO.getPlanTypeId() + " - " + planTypeVO.getPlanName());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
        }

    }

    @Override
    public void update(PlanTypeVO planTypeVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);


            pstmt.setString(1, planTypeVO.getPlanName());
            pstmt.setInt(2, planTypeVO.getPlanDay());
            pstmt.setString(3, planTypeVO.getPlanTypeId());



            pstmt.executeUpdate();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
        }
    }

    @Override
    public void delete(String planTypeId) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setString(1, planTypeId);

            int row = pstmt.executeUpdate();

            if (row > 0) {
                System.out.println("Deleted plan type with ID: " + planTypeId);
            } else {
                System.out.println("No plan type found with ID: " + planTypeId);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
        }

    }


    @Override
    public List<PlanTypeVO> getAll() {
        List<PlanTypeVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();



            while (rs.next()) {
            
                PlanTypeVO planTypeVO = new PlanTypeVO();
                planTypeVO.setPlanTypeId(rs.getString("planTypeId"));
                planTypeVO.setPlanName(rs.getString("planName"));
                planTypeVO.setPlanDay(rs.getInt("planDay"));
                list.add(planTypeVO); 
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
        }

        return list;
    }

    public static void main(String[] args) {
    	PlanTypeDAO dao = new PlanTypeDAO();

        //新增
        PlanTypeVO newPlanType = new PlanTypeVO("D", "日本五日遊", 5);
        dao.insert(newPlanType);


        // 修改

        PlanTypeVO planType = new PlanTypeVO();
        planType.setPlanTypeId("D");
        planType.setPlanName("中國七日遊");
        planType.setPlanDay(7);
        dao.update(planType);

        // 刪除

        dao.delete("C");





        // 查詢
        List<PlanTypeVO> list = dao.getAll();
        for (PlanTypeVO planType1 : list) {
            System.out.print(planType1.getPlanTypeId() + ", ");
            System.out.print(planType1.getPlanName() + ", ");
            System.out.print(planType1.getPlanDay());
            System.out.println();
        }
    }

}
