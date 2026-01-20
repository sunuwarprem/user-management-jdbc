package com.prem.jdbc.dao;

import com.prem.jdbc.model.User;
import com.prem.jdbc.util.DBConnectionUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.prem.jdbc.util.QueryUtil.*;

public class UserDaoImpl implements UserDao {


    @Override
    public int saveUserInfo(User user) {
        int saved = 0;
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(SAVE_USER);
        ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setString(4, user.getAddress());
            ps.setDate(5, new Date(user.getDateOfBirth().getTime()));
            ps.setBoolean(6, user.isStatus());
            saved = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return saved;
    }

    @Override
    public int updateUserInfo(User user) {
        int updated = 0;
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(UPDATE_USER);
        ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setString(4, user.getAddress());
            ps.setDate(5, new Date(user.getDateOfBirth().getTime()));
            ps.setBoolean(6, user.isStatus());
            ps.setInt(7, user.getId());
            updated = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return updated;
    }

    @Override
    public int deleteUserInfo(int id) {
        int deleted = 0;
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(DELETE_USER);
        ) {
            ps.setInt(1, id);
            deleted = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return deleted;
    }

    @Override
    public List<User> listUser() {
        List<User> users = new ArrayList<>();
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(LIST_USER);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setStatus(rs.getBoolean("status"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setDateOfBirth(rs.getDate("date_of_birth"));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(GET_USER_BY_ID);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setStatus(rs.getBoolean("status"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setDateOfBirth(rs.getDate("date_of_birth"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
