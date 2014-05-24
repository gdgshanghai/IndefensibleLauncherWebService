package com.dandelion.membership.dao.data;

import com.dandelion.membership.dao.model.IDLCollection;
import com.dandelion.membership.dao.model.IDLCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IDLCollectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int countByExample(IDLCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int deleteByExample(IDLCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int insert(IDLCollection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int insertSelective(IDLCollection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    List<IDLCollection> selectByExample(IDLCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    IDLCollection selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByExampleSelective(@Param("record") IDLCollection record, @Param("example") IDLCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByExample(@Param("record") IDLCollection record, @Param("example") IDLCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByPrimaryKeySelective(IDLCollection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByPrimaryKey(IDLCollection record);
}