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
public class ComputerPermission {
    int m_id;
    int m_computerId;
    int m_permissionId;
    
    public ComputerPermission(int p_id, int p_computerId, int p_permissionId)
    {
        m_id = p_id;
        m_computerId = p_computerId;
        m_permissionId = p_permissionId;
    }
    
    public static ComputerPermission GetByPermissionIdAndComputerId(
            int p_permissionId, int p_computerId) throws Exception
    {
        ResultSet resultSet = DBConnection.ExecuteQuery("SELECT Id, ComputerId,"
                + "PermissionId FROM COMPUTERPERMISSION WHERE "
                + "COMPUTERPERMISSION.ComputerId="
                + String.valueOf(p_computerId)
                + "AND COMPUTERPERMISSION.PermissionId="
                + String.valueOf(p_permissionId));
        
        return new ComputerPermission(resultSet.getInt(1), resultSet.getInt(2),
                resultSet.getInt(3));
    }
}
