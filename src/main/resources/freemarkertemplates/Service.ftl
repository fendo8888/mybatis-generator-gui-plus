package ${package_name}.service.impl;
import com.evada.inno.core.service.impl.BaseServiceImpl;
import ${package_name}.model.${table_name};
import ${package_name}.repository.${table_name}Repository;
import ${package_name}.service.I${table_name}Service;
import ${package_name}.repository.mybatis.${table_name}DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${package_name}.dto.${table_name}DTO;
import org.apache.commons.beanutils.BeanUtils;
import com.evada.inno.core.enums.StatusEnum;

/**
* 描述：${table_annotation} 服务实现层
* @author ${author}
* @date ${date}
*/
@Service
public class ${table_name}ServiceImpl extends BaseServiceImpl<${table_name}, String> implements I${table_name}Service {

    @Autowired
    private ${table_name}DAO ${table_name?uncap_first}DAO;

    @Autowired
    private ${table_name}Repository ${table_name?uncap_first}Repository;

    @Override
    public ${table_name}DTO findDTOById(String id) throws Exception {
        ${table_name}DTO ${table_name?uncap_first}DTO = ${table_name?uncap_first}DAO.findDTOById(id);
        return ${table_name?uncap_first}DTO;
    }

    @Override
    public ${table_name}DTO create${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception {
        ${table_name} ${table_name?uncap_first} = new ${table_name}();
        BeanUtils.copyProperties(${table_name?uncap_first},${table_name?uncap_first}DTO);
        ${table_name?uncap_first}.setStatus(StatusEnum.ENABLE.toString());
        ${table_name?uncap_first} = ${table_name?uncap_first}Repository.saveAndFlush(${table_name?uncap_first});
        return this.findDTOById(${table_name?uncap_first}.getId());
    }

    @Override
    public ${table_name}DTO update${table_name}(${table_name}DTO ${table_name?uncap_first}DTO)throws Exception {
        ${table_name} ${table_name?uncap_first} = new ${table_name}();
        BeanUtils.copyProperties(${table_name?uncap_first},${table_name?uncap_first}DTO);
        ${table_name?uncap_first} = ${table_name?uncap_first}Repository.saveAndFlush(${table_name?uncap_first});
        return this.findDTOById(${table_name?uncap_first}.getId());
    }