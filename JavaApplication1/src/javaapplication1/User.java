/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.ResultSet;

/**
 *
 * @author Joao Paulo
 */
public class User {
    private int m_id;
    private String m_name;
    private String m_userName;
    private String m_password;
    private int m_permissionId;
    
    public User(int p_id, String p_userName, String p_password, String p_name,
            int p_permissionId)
    {
        m_id = p_id;
        m_userName = p_userName;
        m_password = p_password;
        m_name = p_name;
        m_permissionId = p_permissionId;
    }
    
    public int getId()
    {
        return m_id;
    }
    
    public Permission getPermission() throws Exception
    {
        return Permission.GetById(m_permissionId);
    }
    
    public static User GetByUserNameAndPassword(String p_userName,
            String p_password) throws Exception
    {
        ResultSet resultSet = DBConnection.ExecuteQuery("SELECT Id, UserName,"
                + " Password, Name, PermissionId FROM USER"
                + " WHERE USER.UserName="
                + "'" + p_userName + "'"
                + " AND USER.Password="
                + "'" + p_password + "'");
        
        return new User(resultSet.getInt(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4),
                resultSet.getInt(5));
    }
}
