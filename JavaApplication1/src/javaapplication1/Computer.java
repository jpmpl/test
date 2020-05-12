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
public class Computer {
    private int m_id;
    private boolean m_isInUse;
    
    public Computer(int p_id, boolean p_isInUse)
    {
        m_id = p_id;
        m_isInUse = p_isInUse;
    }
    
    public int getId()
    {
        return m_id;
    }
    
    public boolean isInUse()
    {
        return m_isInUse;
    }
    
    public static Computer GetById(int p_computerId) throws Exception
    {
        ResultSet resultSet = DBConnection.ExecuteQuery("SELECT Id, IsInUse "
                + "FROM COMPUTER WHERE COMPUTER.Id="
                + String.valueOf(p_computerId));
        
        return new Computer(resultSet.getInt(1), resultSet.getBoolean(2));
    }
}
