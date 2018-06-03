package cn.itcast.tpms.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	
	private T model;
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
		//获取父类的类型
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//判断是否包含泛型
		if(genericSuperclass instanceof ParameterizedType) {
			
			ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
			
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			
			Type type = actualTypeArguments[0];
			
			Class<T> entityClass = (Class<T>) type;
			
			try {
				model = entityClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public T getModel() {
		// 模型对象
		return model;
	}

}
