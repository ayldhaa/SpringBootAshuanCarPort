package com.aaa.SdkTest;

import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Remains;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;

/**
 * @功能概要：SDK调用示例
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 */
public class SDKDemo {
	/**
	 * 
	 * @description SDK示例
	 * @param args
	 */
	public static void main(String[] args) {
		// 用户账号
		String userid = "E10B9V";

		// 创建全局参数
		GlobalParams globalParams = new GlobalParams();
		// 设置请求路径
		globalParams.setRequestPath("/sms/v2/std/");
		// 设置是否需要日志 1:需要日志;0:不需要日志
		globalParams.setNeedLog(1);
		// 设置全局参数
		ConfigManager.setGlobalParams(globalParams);

		// 设置用户账号信息
		setAccountInfo();

		// 是否保持长连接
		boolean isKeepAlive = true;
		// 实例化短信处理对象
		SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);

		// 单条发送
		singleSend(smsSendConn, userid);

		// 查询余额
		getBalance(smsSendConn, userid);
		
		//查询剩余金额或条数接口
		getRemains(smsSendConn, userid);

		// 实例化短信处理对象
		SmsSendConn smsSendConnMo = new SmsSendConn(isKeepAlive);
		// 每次请求想要获取的上行的最大条数。
		int retsizeMo = 100;
		// 实例化获取上行线程
		RecvMoThread recvMoThread = new RecvMoThread(smsSendConnMo, userid, retsizeMo);
		// 线程获取 启动获取上行的线程
		recvMoThread.start();
		System.out.println("获取上行的线程启动成功！");

		// 实例化短信处理对象
		SmsSendConn smsSendConnRpt = new SmsSendConn(isKeepAlive);
		// 每次请求想要获取的状态报告的最大条数。
		int retsizeRpt = 100;
		// 实例化状态报告线程
		RecvRptThread recvRptThread = new RecvRptThread(smsSendConnRpt, userid,retsizeRpt);
		// 线程获取 启动获取状态报告的线程
		recvRptThread.start();
		System.out.println("获取状态报告的线程启动成功！");

		// 移除用户账号(此处为移除用户账号功能示例，使用时请根据实际情况，有需要才调用此方法)
		removeAccount(userid);

	}

	/**
	 * @description 设置用户账号信息
	 */
	public static void setAccountInfo() {
		// 设置用户账号信息

		// 用户账号
		String userid = "E10B9V";
		// 密码
		String password = "8N1H1Q";
		// 发送优先级
		int priority = 1;
		// 主IP信息
		String ipAddress1 = "api02.monyun.cn:7901";
		

		// 备用IP1信息
		String ipAddress2 = "192.169.1.189:8086";
		// 备用IP2信息
		String ipAddress3 = null;
		// 备用IP3信息
		String ipAddress4 = null;
		// 返回值
		int result = -310007;
		try {
			// 设置用户账号信息
			result = ConfigManager.setAccountInfo(userid, password, priority,
					ipAddress1, ipAddress2, ipAddress3, ipAddress4);
			// 判断返回结果，0设置成功，否则失败
			if (result == 0) {
				System.out.println("设置用户账号信息成功！");
			} else {
				System.out.println("设置用户账号信息失败，错误码：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
	}

	/**
	 * 移除用户账号
	 * 
	 * @param userid
	 *            用户账号
	 */
	public static void removeAccount(String userid) {
		try {
			// 调用移除用户账号的方法
			int result = ConfigManager.removeAccount(userid);

			// 返回0，代表移除成功
			if (result == 0) {
				System.out.println("移除用户账号[" + userid + "]成功！");
			}
			// 返回非0，代表移除失败
			else {
				System.out.println("移除用户账号[" + userid + "]失败！错误码：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @description 单条发送
	 * @param smsSendConn
	 *            短信处理对象,在这个方法中调用发送短信功能
	 * @param userid
	 *            用户账号
	 */
	public static void singleSend(SmsSendConn smsSendConn, String userid) {
		
	}


	

	
	public static void getBalance(SmsSendConn smsSendConn, String userid) {
		// 返回值
		int result = -310099;
		try {
			// 调用查询余额的方法查询余额
			result = smsSendConn.getBalance(userid);
			// 返回值大于等于0，则查询成功， 否则失败
			if (result >= 0) {
				System.out.println("查询余额成功，余额为：" + result);
			} else {
				System.out.println("查询余额失败，错误码为：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}

	}
	
	/**
	 * 查询剩余金额或条数接口
	 */
	public static void getRemains(SmsSendConn smsSendConn,String userid)
	{
		try
		{
			// 查询余额接口。
			Remains remains = smsSendConn.getRemains(userid);

			//remains不为空
			if(remains!=null)
			{
				//查询成功
				if(remains.getResult()==0)
				{
					//计费类型为0，条数计费
					if(remains.getChargetype()==0)
					{
						System.out.println("查询成功,剩余条数为：" + remains.getBalance());
					}else if(remains.getChargetype()==1)
					{
						//计费类型为1，金额计费
						System.out.println("查询成功,剩余金额为：" + remains.getMoney());
					}else
					{
						System.out.println("未知的计费类型,计费类型:"+remains.getChargetype());
					}
				}
				else
				{
					//查询失败
					System.out.println("查询失败,错误码为：" + remains.getResult());
				}
			}else
			{
				System.out.println("查询失败。");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
