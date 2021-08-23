package VirtualCB;

import java.rmi.server.ExportException;
import java.sql.*;
import java.util.ArrayList;


public class dbFunction{
    void tableCreateStudent(){
        try{
            Connection con = dbOperations.getConnection();
            Statement  st = con.createStatement();
            String query="create table student_details(email varchar2(30) primary key,name varchar2(20),phone varchar2(20),reg_no varchar2(20) distinct,course varchar2(20),year_enrolled varchar2(20),password varchar2(20),designation varchar2(20))";
            int result = st.executeUpdate(query);
            con.close();
            System.out.println("Success!    "+result);
        }
        catch(Exception e){
            System.out.println("---------->  "+e);
        }
    }

    public reg_details viewDetails(String id) throws SQLException {
        reg_details rd=new reg_details();
        Connection con = dbOperations.getConnection();
        PreparedStatement ps1= con.prepareStatement("select * from reg_details where reg_no = ?");
        ps1.setString(1,id);
        ResultSet rs= ps1.executeQuery();
        if(rs.next()){
            //String r_id=rs.getString(1);
            rd.setId(rs.getString(1));
            rd.setName(rs.getString(2));
            rd.setPassword(rs.getString(3));
            rd.setPhone(rs.getString(4));
            rd.setState(rs.getString(5));
            rd.setCity(rs.getString(6));
            rd.setAge(rs.getString(7));
            rd.setDob(rs.getString(8));
            rd.setGender(rs.getString(9));
            return rd;
        }
        return rd;
    }

    public boolean insertTable(reg_details rd){
        try{
            Connection con = dbOperations.getConnection();
            Statement  st = con.createStatement();
            String query=String.format("insert into reg_details values('%s','%s','%s','%s','%s','%s','%s','%s','%s')",rd.getId(),rd.getName(),rd.getPassword(),rd.getPhone(),rd.getState(),rd.getCity(),rd.getAge(),rd.getDob(),rd.getGender());
            st.executeUpdate(query);
            con.setAutoCommit(true);
            con.close();
            return true;
        }
        catch(Exception e){
            System.out.println("---------->  "+e);
        }
        return false;
    }
    dbFunction(){
        if(!checkTable()){
            tableCreate();
        }

    }
    boolean checkTable(){
        try {
            Connection con = dbOperations.getConnection();
            DatabaseMetaData meta = con.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, "reg_details",null);

            return resultSet.next();
        }
        catch(Exception ee){
            System.out.println(ee);
        }
        return  false;
    }
    public boolean viewVerify(String n_id){
        try{
            Connection con = dbOperations.getConnection();
            PreparedStatement ps1= con.prepareStatement("select * from reg_details where reg_no = ?");
            ps1.setString(1,n_id);
            ResultSet rs= ps1.executeQuery();
            return rs.next();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

}

