package com.kzfire.portal.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.kzfire.portal.entiy.SysPermission;
import com.kzfire.portal.entiy.SysRole;
import com.kzfire.portal.entiy.SysUser;
import com.kzfire.portal.service.UserService;
import com.kzfire.portal.utils.Contents;

public class MyRealm extends AuthorizingRealm {  
	@Autowired
	private UserService userService;
    /** 
     * 为当前登录的Subject授予角色和权限 
     * @see  经测试:本例中该方法的调用时机为需授权资源被访问时 
     * @see  经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache 
     * @see  个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache 
     * @see  比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache 
     */  
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){  
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
        String currentUsername = (String)super.getAvailablePrincipal(principals);
      List<String> roleList = new ArrayList<String>();  
      List<String> permissionList = new ArrayList<String>();  
      //从数据库中获取当前登录用户的详细信息  
      SysUser user = userService.getByUsername(currentUsername);  
      if(null != user){  
          //获取当前登录用户的角色和权限
    	  List<SysRole> roles=userService.getRolesByUserId(user.getId()); 
    	  List<SysPermission> permissions=userService.getPermsByUserId(user.getId());
    	  if(roles.size()==0) return null;
    	  for(SysRole role:roles )
    	  {
    		  roleList.add(role.getRoleCode());
    	  }
    	  for(SysPermission permission:permissions )
    	  {
    		  permissionList.add(permission.getPermissionCode());
    	  }
      }else{  
          throw new AuthorizationException();  
      }  
      //为当前用户设置角色和权限  
      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
      simpleAuthorInfo.addRoles(roleList);  
      simpleAuthorInfo.addStringPermissions(permissionList);  
      return simpleAuthorInfo;
    }  
   
       
    /** 
     * 验证当前登录的Subject 
     * @see  经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时 
     */  
	@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  
        //获取基于用户名和密码的令牌  
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        SysUser user = userService.getByUsername(token.getUsername());  
      if(null != user){  
          AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), user.getRealName());  
          this.setSession(Contents.LOGIN_USER, user);  
          return authcInfo;  
      }else{  
          return null;  
      }  
    }  
       
       
    /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see  比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  
}
