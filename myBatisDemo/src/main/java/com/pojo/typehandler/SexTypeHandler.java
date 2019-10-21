package com.pojo.typehandler;

import com.pojo.SexEnum;
import org.apache.ibatis.type.*;

import java.sql.*;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        if (sex!=1 && sex != 2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        if (sex!= 1&&sex!=2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        if (sex!= 1&&sex!=2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }
}
