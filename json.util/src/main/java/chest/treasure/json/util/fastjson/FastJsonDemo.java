package chest.treasure.json.util.fastjson;


import java.util.Iterator;

import org.junit.Test;

import chest.treasure.json.util.fastjson.domain.SysMenu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {
	@Test
	public void parseString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
			sb.append("{");
				sb.append("'weixin'").append(":").append("'simple'").append(",");
				sb.append("'qq'").append(":").append("'249661143'").append("");
			sb.append("}");
			sb.append(",");
			sb.append("{");
				sb.append("'weixin'").append(":").append("'pleasures'").append(",");
				sb.append("qq").append(":").append("'827632093'").append("");
			sb.append("}");
		sb.append("]");
		
		String jsonStr = sb.toString();
		
		
		JSONArray jarr = JSONArray.parseArray(jsonStr);
		for(Iterator<Object> iterator = jarr.iterator();iterator.hasNext();) {
			JSONObject job = (JSONObject)iterator.next();
			String weixin = job.getString("weixin").toString();
			System.out.println(weixin);
		}
	}
	
	@Test
	public void parseEntity() {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setMenuId(123456789);
		sysMenu.setMenuDescription("我了个去");
		
		SysMenu sysMenuParent = new SysMenu();
		sysMenuParent.setMenuId(1122);
		sysMenuParent.setMenuDescription("wo qu ");
		sysMenuParent.getSmLists().add(sysMenu);
		sysMenuParent.getSmLists().add(sysMenuParent);
		
		String jsonStr= JSON.toJSONString(sysMenuParent);
		System.out.println(jsonStr);
		
		JSONObject jsonObj = new JSONObject();
		
		SysMenu temp = JSON.parseObject(jsonStr, SysMenu.class);
		System.out.println(temp.getMenuDescription());
		System.out.println(temp.getSmLists());
		
	}
}
