package utils;

/**
 * 單例 Singleton 設計模式
 */
public class SingletonUtil {

	// 2. 私有靜態的欄位，用來存放單例實體
	private static SingletonUtil instance;
	
	// 1. 私有的建構式，不能使用 new 的方式建立物件
	private SingletonUtil() {
		
	}
	
	// 3. 公有靜態的方法，來獲得單例實體
	public static SingletonUtil getInstance() {
        if (instance == null) {
        	// 首次呼叫才產生物件
            instance = new SingletonUtil();
        }
        return instance;
	}
	
    public void show() {
    	System.out.println(instance);
    }
}
