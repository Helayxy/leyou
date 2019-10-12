package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     *
     * @param cid 商品分类id
     * @param bid 品牌id
     */
    @Insert("INSERT INTO tb_category_brand ( category_id, brand_id ) VALUES (#{cid},#{bid})")
    int insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 根据商品分类id查询品牌列表
     *
     * @param cid 商品分类id
     * @return 返回品牌列表
     */
    @Select("SELECT * FROM tb_brand a INNER JOIN tb_category_brand b ON a.id = b.brand_id WHERE b.category_id = #{cid}")
    List<Brand> selectBrandByCid(Long cid);

}
