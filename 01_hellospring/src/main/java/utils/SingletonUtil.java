package utils;

public class SingletonUtil {
//	私有建構式
//	私有靜態的欄位，用來存放單例實體
//	公有靜態的方法，來獲得單例實體
	private static SingletonUtil instance;
	
	private SingletonUtil() {
		
	}
	
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
