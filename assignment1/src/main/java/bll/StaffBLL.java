package bll;

import connection.Connection;
import dao.BookDAO;
import dao.OrderDAO;
import dao.StaffDAO;
import dao.UserDAO;
import model.Staff;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class StaffBLL {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    StaffDAO staffs = appContext.getBean("staffDAO", StaffDAO.class);

    public StaffBLL() {
    }
    public Staff selectStaffById(int id){
        return staffs.selectStaffById(id);
    }
    public List<Staff> selectAllStaff(){
        return staffs.selectAll();
    }
    public void insertStaff(Staff staff){
        staffs.insertStaff(staff);
    }
    public void updateStaff(Staff staff){
        staffs.updateStaff(staff);
    }
    public void deleteStaffById(int id){
        staffs.deleteStaff(id);
    }
}
