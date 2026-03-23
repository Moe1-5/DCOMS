/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.server;


import finalproject.com.dcoms.db.EmployeeDAO;
import finalproject.com.dcoms.db.FamilyDetailsDAO;
import finalproject.com.dcoms.db.LeaveApplicationDAO;
import finalproject.com.dcoms.db.LeaveHistoryDAO;
import finalproject.com.dcoms.remote.HRMService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
/**
 *
 * @author albad
 */
public class HRMServiceImpl extends UnicastRemoteObject implements HRMService {
    
    private final EmployeeDAO employeeDAO;
    private final FamilyDetailsDAO familyDetailsDAO;
    private final LeaveApplicationDAO leaveApplicationDAO;
    private final LeaveHistoryDAO leaveHistoryDAO;

    public HRMServiceImpl() throws RemoteException {
        super();
        employeeDAO        = new EmployeeDAO();
        familyDetailsDAO   = new FamilyDetailsDAO();
        leaveApplicationDAO = new LeaveApplicationDAO();
        leaveHistoryDAO    = new LeaveHistoryDAO();
    }
    
    //Employee 
    @Override
    public String[] getEmployeeById(String employeeId) throws RemoteException{
        return employeeDAO.getEmployeeById(employeeId);
    }
    
    @Override
    public int getLeaveBalance(String employeeId) throws RemoteException{
        return employeeDAO.getLeaveBalance(employeeId);
    }
    
    //family Details
     @Override
    public boolean insertFamilyDetails(String employeeId, String spouseName,
                                       int children) throws RemoteException {
        return familyDetailsDAO.insertFamilyDetails(employeeId, spouseName, children);
    }

    @Override
    public boolean updateFamilyDetails(String employeeId, String spouseName,
                                       int children) throws RemoteException {
        return familyDetailsDAO.updateFamilyDetails(employeeId, spouseName, children);
    }

    @Override
    public String[] getFamilyByEmployeeId(String employeeId) throws RemoteException {
        return familyDetailsDAO.getFamilyByEmployeeId(employeeId);
    }
    
    //leave Application 
    @Override
    public boolean applyLeave(String leaveId, String employeeId, String leaveType,
                              String startDate, String endDate) throws RemoteException {
        return leaveApplicationDAO.applyLeave(leaveId, employeeId, leaveType,
                                              startDate, endDate);
    }

    @Override
    public boolean updateLeaveStatus(String leaveId, String status) throws RemoteException {
        boolean updated = leaveApplicationDAO.updateLeaveStatus(leaveId, status);
        if (updated && !status.equals("Pending")) {
            leaveHistoryDAO.insertLeaveHistory(leaveId, status);
        }
        return updated;
    }

    @Override
    public List<String[]> getLeavesByEmployee(String employeeId) throws RemoteException {
        return leaveApplicationDAO.getLeavesByEmployee(employeeId);
    }

    @Override
    public List<String[]> getLeavesByEmployeeAndYear(String employeeId,
                                                     int year) throws RemoteException {
        return leaveApplicationDAO.getLeavesByEmployeeAndYear(employeeId, year);
    }
    
    //leave History 
    @Override
    public boolean insertLeaveHistory(String leaveId, String status) throws RemoteException {
        return leaveHistoryDAO.insertLeaveHistory(leaveId, status);
    }

    @Override
    public List<String[]> getHistoryByEmployee(String employeeId) throws RemoteException {
        return leaveHistoryDAO.getHistoryByEmployee(employeeId);
    }
}
