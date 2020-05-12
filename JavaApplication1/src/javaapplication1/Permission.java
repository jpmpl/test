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
public class Permission {
    private int m_id;
    private String m_description;
    
    public Permission(int p_id, String p_description)
    {
        m_id = p_id;
        m_description = p_description;
    }
    
    public static Permission GetById(int p_permissionId) throws Exception
    {
        ResultSet resultSet = DBConnection.ExecuteQuery("SELECT Id, Description"
                + " FROM PERMISSION WHERE PERMISSION.Id="
                + String.valueOf(p_permissionId));
        
        return new Permission(resultSet.getInt(1), resultSet.getString(2));
    }
    
    public boolean checkComputer(Computer p_computer) throws Exception
    {
        ComputerPermission v_computerPermission = ComputerPermission
                .GetByPermissionIdAndComputerId(m_id, p_computer.getId());
        return v_computerPermission != null;
    }
}
