package com.kzfire.portal.realm;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.kzfire.portal.dao.PermissionDao;
import com.kzfire.portal.entiy.SysPermission;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section>{
	@Autowired
	private PermissionDao permissionDao;
    
    private String filterChainDefinitions;
    
    /**
     * 默认premission字符串
     */
    public static final String PREMISSION_STRING="perms[\"{0}\"]";
    
    
    public Section getObject() throws BeansException {
        
        //获取所有Resource
        List<SysPermission> list =permissionDao.getAll();
        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (SysPermission per:list) {
            
            //如果不为空值添加到section中
            if(StringUtils.isNotEmpty(per.getPath()) && StringUtils.isNotEmpty(per.getPermissionCode())) {
            	section.put(per.getPath(),  MessageFormat.format(PREMISSION_STRING,per.getPermissionCode()));
            }
            
        }
        
        return section;
    }
    
    /**
     * 通过filterChainDefinitions对默认的url过滤定义
     * 
     * @param filterChainDefinitions 默认的url过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    
    public boolean isSingleton() {
        return false;
    }

	@Override
	public Class<Section> getObjectType() {
		return Section.class;
	}


    
}