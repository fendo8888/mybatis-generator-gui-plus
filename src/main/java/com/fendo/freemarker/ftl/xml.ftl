<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoPackage}.${beanName}Mapper">

	<resultMap id="BaseResultMap" type="${modelPackage}.${beanName}">
	          <id column="${primKey.columnName}" jdbcType="${primKey.jdbcType}" property="${primKey.attributeName?lower_case}"/>
	          <#list columns as item>
	          <#if primKey.columnName!=item.columnName>
              <result column="${item.columnName}" jdbcType="${item.jdbcType}" property="${item.attributeName?lower_case}"/>  
              </#if>  
         </#list>  
	</resultMap>

	 <sql id="Base_Column_List">
			     <#list columns as item><#if item_index == 0>${item.columnName}<#else>, ${item.columnName}</#if></#list>
	 </sql>

     <!-- 根据主键获取对象 -->
	 <select id="selectByPrimaryKey" parameterType="java.lang.String" resultMap="BaseResultMap">
	    select 
	    <include refid="Base_Column_List" />
	    from ${tableName}
	    where  ${primKey.columnName} = ${'#'}{${primKey.attributeName?lower_case},jdbcType=${primKey.columnType}}
	  </select>
	
	  <!-- 根据主键删除 -->
	  <delete id="deleteByPrimaryKey" parameterType="java.lang.String">
	    update ${tableName}
		<set>
		    STATE = '1'
		</set>
		where ${primKey.columnName} = ${'#'}{${primKey.attributeName?lower_case},jdbcType=${primKey.columnType}}
	  </delete>
	
	  <!-- 新增对象(所有字段) -->
	  <insert id="insert" parameterType="${modelPackage}.${beanName}">
		insert into ${tableName}(
			<include refid="Base_Column_List" />
		)
		values(	<#list columns as item>  
	             <#if item_index == 0>${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}} <#else>,${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}}</#if>
               </#list>)
	  </insert>
	
	  <!-- 新增对象(部分字段) -->
	  <insert id="insertSelective" parameterType="${modelPackage}.${beanName}">
	    insert into ${tableName}
	    <trim prefix="(" suffix=")" suffixOverrides=",">
		  <#list columns as item>  
            <if test="${item.attributeName?lower_case} != null and ${item.attributeName?lower_case} != ''">  
                ${item.columnName},
            </if>  
          </#list> 
	    </trim>
	    <trim prefix="values (" suffix=")" suffixOverrides=",">
	        <#list columns as item>  
	            <if test="${item.attributeName?lower_case} != null and ${item.attributeName?lower_case} != ''">  
	                  ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}},  
	            </if>  
	        </#list> 
	    </trim>
	  </insert>
	
	  <update id="updateByPrimaryKeySelective" parameterType="${modelPackage}.${beanName}">
	    update ${tableName}
		<set>
		   <#list columns as item>  
            <if test="${item.attributeName?lower_case} != null and ${item.attributeName?lower_case} != ''">  
                  <#if item_index == 0>${item.columnName} = ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}}<#else>, ${item.columnName} = ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}}</#if>
                    
            </if>  
          </#list> 
		</set>
		where ${primKey.columnName} = ${'#'}{${primKey.attributeName?lower_case},jdbcType=${primKey.columnType}}
	  </update>
	
	  <!-- 修改对象(所有字段) -->
	  <update id="updateByPrimaryKey" parameterType="${modelPackage}.${beanName}">
		update ${tableName}
		set
		<#list columns as item>  
               <#if item_index == 0>${item.columnName} = ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}}<#else>, ${item.columnName} = ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}}</#if>
        </#list> 
		where ${primKey.columnName} = ${'#'}{${primKey.attributeName?lower_case},jdbcType=${primKey.columnType}}
	  </update>
	
	  <!-- 根据条件获取所有数据 -->
	  <select id="selectAll" parameterType="${modelPackage}.${beanName}" resultMap="BaseResultMap">
	    select * from ${tableName}
	    <where>
	      <#list columns as item>  
            <if test="${item.attributeName?lower_case} != null and ${item.attributeName?lower_case} != ''"> 
                   
                   <#if item_index == 0>${item.columnName} = ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}}<#else> and ${item.columnName} = ${'#'}{${item.attributeName?lower_case},jdbcType=${item.jdbcType}} </#if>
 
            </if>  
          </#list> 
	    </where>
	  </select>
	
	  <!-- 分页数据 -->
	  <select id="queryPage" parameterType="com.gz.medicine.common.mybatisPageVo.Page" resultMap="BaseResultMap">
	    select * from ${tableName}
	  </select>


</mapper>
