package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.adapter.repository.typehandler;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(CourseId.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class CourseIdTypeHandler extends BaseTypeHandler<CourseId> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, CourseId parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, parameter.value());
    }

    @Override
    public CourseId getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return CourseId.from(resultSet.getString(columnName));
    }

    @Override
    public CourseId getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return CourseId.from(resultSet.getString(columnIndex));
    }

    @Override
    public CourseId getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return CourseId.from(callableStatement.getString(columnIndex));
    }
}