package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.User;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO user(name,surname,yin,login,password,telephone) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
 /*
    some sql prepared statements to deal with database , like insert into table
      */
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setInt(3, user.getYin());
            st.setString(4, user.getLogin());
            st.setString(5, user.getPassword());
            st.setString(6, user.getTelephone());

            int executed = st.executeUpdate();
            return executed == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}