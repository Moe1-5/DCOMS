/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package finalproject.com.dcoms.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author albad
 */
public interface HRMService extends Remote {
    //Employee 
    String[] getEmployeeById(String employeeId) throws RemoteException;
    int getLeaveBalance(String employeeId) throws RemoteException;
    
    //family Details 
    boolean insertFamilyDetails(String employeeId, String spouseName, int children) throws RemoteException;
    boolean updateFamilyDetails(String employeeId, String spouseName, int children) throws RemoteException;
    String[] getFamilyByEmployeeId(String employeeId) throws RemoteException;
    
    
    //leave application
    boolean applyLeave(String leaveId, String employeeId, 
            String leaveType, String startDate, String endDate) throws RemoteException;
    boolean updateLeaveStatus(String leaveId, String status) throws RemoteException;
    List<String[]> getLeavesByEmployee(String employeeId) throws RemoteException;
    List<String[]> getLeavesByEmployeeAndYear(String employeeId, int year) throws RemoteException;

    
    //leave History 
    boolean insertLeaveHistory(String leaveId, String status) throws RemoteException;
    List<String[]> getHistoryByEmployee(String employeeId) throws RemoteException;
    
}
