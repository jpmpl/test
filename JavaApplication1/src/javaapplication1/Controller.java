/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Joao Paulo
 */
public class Controller {
    public boolean Login(String p_userName, String p_password,
            int p_computerId)throws Exception
    {
        User v_user = User.GetByUserNameAndPassword(p_userName, p_password);
        Computer v_computer = Computer.GetById(p_computerId);
        if(!v_user.getPermission().checkComputer(v_computer)
                || v_computer.isInUse())
            return false;
        
        AccessControl.RecordStartOfSession(v_user, v_computer);
        return true;
    }
    
    public boolean Logoff(int p_computerId)throws Exception
    {
        Computer v_computer = Computer.GetById(p_computerId);
        AccessControl.RecordEndOfSession(v_computer);
        return true;
    }
}
