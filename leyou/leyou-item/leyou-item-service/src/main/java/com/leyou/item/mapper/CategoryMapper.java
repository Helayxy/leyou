package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 通用mapper接口
 */
public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long> {
}
