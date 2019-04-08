package com.example.sptest.aspect.mapper;

import com.example.sptest.aspect.PartnerEventModel;
import org.apache.ibatis.annotations.*;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Mapper
public interface PartnerEventDao {
    String TABLE_NAME = "wv_partners_event";

    @Insert("insert into wv_partners_event (uuid, method, arguments, result, error)"
            + "values (#{uuid}, #{method}, #{arguments}, #{result}, #{error})")
    @Options(useGeneratedKeys = true)
    Long create(PartnerEventModel eventModel);

    @Select("select * from wv_partners_event where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uuid", property = "uuid"),
            @Result(column = "method", property = "method"),
            @Result(column = "arguments", property = "arguments"),
            @Result(column = "result", property = "result"),
            @Result(column = "error", property = "error"),
    })
    PartnerEventModel findById(@Param("id") Long id);
}
