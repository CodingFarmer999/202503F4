import utils.SingletonUtil;

public class SingletonMain {

	public static void main(String[] args) {
//		new SingletonUtil();
		
		SingletonUtil utils = SingletonUtil.getInstance();
		utils.show();
		
		SingletonUtil utils2 = SingletonUtil.getInstance();
		utils2.show();
	}
	

}
