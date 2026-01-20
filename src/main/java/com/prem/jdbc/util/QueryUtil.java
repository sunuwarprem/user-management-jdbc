package com.prem.jdbc.util;

public class QueryUtil {

    private QueryUtil() {

    }

    public static final String SAVE_USER = """
            insert into user_tbl(user_name, password, mobile_no, address, date_of_birth, status)
            values(?, ?, ?, ?, ?, ?)
            """;

    public static final String UPDATE_USER = """
            update user_tbl set user_name=?, password=?, mobile_no=?, address=?, date_of_birth=?, status=?
            where id=?
            """;

    public static final String DELETE_USER = """
            delete from user_tbl where id=?
            """;

    public static final String LIST_USER = """
            select * from user_tbl
            """;

    public static final String GET_USER_BY_ID = """
            select * from user_tbl where id=?
            """;

}
