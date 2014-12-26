package com.dandelion.membership.dao.data;

import com.dandelion.membership.dao.model.IDLAppCollection;
import com.dandelion.membership.dao.model.IDLAppCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IDLAppCollectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int countByExample(IDLAppCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int deleteByExample(IDLAppCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int insert(IDLAppCollection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int insertSelective(IDLAppCollection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    List<IDLAppCollection> selectByExample(IDLAppCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    IDLAppCollection selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByExampleSelective(@Param("record") IDLAppCollection record, @Param("example") IDLAppCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByExample(@Param("record") IDLAppCollection record, @Param("example") IDLAppCollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByPrimaryKeySelective(IDLAppCollection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_idl_app_collection
     *
     * @mbggenerated Sun May 18 21:15:59 CST 2014
     */
    int updateByPrimaryKey(IDLAppCollection record);
}