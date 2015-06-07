package chest.treasure.json.util.fastjson;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import chest.treasure.json.util.fastjson.domain.SysMenu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

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
		
		//转换成jsonArray,能够通过iterator遍历,转换的一定要带有[]其实的json串
		JSONArray jarr = JSONArray.parseArray(jsonStr);
		for(Iterator<Object> iterator = jarr.iterator();iterator.hasNext();) {
			JSONObject job = (JSONObject)iterator.next();
			String weixin = job.getString("weixin").toString();
			System.out.println(weixin);
		}
		
		//把JSON数据转换成普通字符串列表,也可以是指定类
		List<String> listList = JSON.parseArray(jsonStr, String.class);
		System.out.println(listList);
		
//		把JSON数据转换成较为复杂的java对象列表
		List<Map<String, Object>> parseObject = JSON.parseObject(jsonStr,
				new TypeReference<List<Map<String, Object>>>() {
				});
		System.out.println(parseObject);
		
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
		
//		把java对象转换成JSON数据
		String jsonStr= JSON.toJSONString(sysMenuParent);
		System.out.println("jsonStr:---"+jsonStr);
		
		StringBuffer sb = new StringBuffer(jsonStr);
		sb.insert(0, "[");
		sb.insert(sb.length(), "]");
		
		JSONArray parseArray = JSONArray.parseArray(sb.toString());
		for(Iterator iter = parseArray.iterator();iter.hasNext();) {
			System.out.println("###"+iter.next());
		}
		
		//解析json字符串成object类,object中存在的为类似一个map
		Object object = JSONObject.parse(jsonStr);
		System.out.println("object:---"+object);
		
		//把JSON数据转换成指定的java对象
		SysMenu temp = JSON.parseObject(jsonStr, SysMenu.class);
		System.out.println("Description:---"+temp.getMenuDescription());
		System.out.println("SmLists:---"+temp.getSmLists());
	}
}
