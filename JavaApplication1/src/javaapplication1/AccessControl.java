/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Joao Paulo
 */
public class AccessControl {
    private int m_id;
    private int m_userId;
    private int m_computerId;
    private Date m_sessionStart;
    private Date m_sessionEnd;
    
    public AccessControl(int p_id, int p_userId, int p_computerId,
            Date p_startDate, Date p_endDate)
    {
        m_id = p_id;
        m_userId = p_userId;
        m_computerId = p_computerId;
        m_sessionStart = p_startDate;
        m_sessionStart = p_endDate;
    }
    
    public static void RecordStartOfSession(User p_user, Computer p_computer)
    {
        Date v_date = new Date();
        DBConnection.ExecuteQuery("INSERT INTO ACCESSCONTROL(UserId,"
                + "ComputerId,SessionStart)"
                + " VALUES(" + String.valueOf(p_user.getId()) + ","
                + String.valueOf(p_computer.getId()) + ","
                + "'" + v_date.toString() + "'" +")");
    }
    
    public static void RecordEndOfSession(Computer p_computer)
    {
        Date v_date = new Date();
        DBConnection.ExecuteQuery("UPDATE ACCESSCONTROL SET "
                + " SessionEnd=" + "'" + v_date.toString() + "'"
                + " WHERE ComputerId=" + String.valueOf(p_computer.getId())
                + " AND SessionEnd IS NULL");
    }
}
