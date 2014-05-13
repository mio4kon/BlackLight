package us.shandian.blacklight.api.statuses;

import com.sina.weibo.sdk.net.WeiboParameters;

import com.google.gson.Gson;

import org.json.JSONObject;

import us.shandian.blacklight.api.BaseApi;
import us.shandian.blacklight.api.Constants;
import us.shandian.blacklight.model.MessageModel;

public class PostApi extends BaseApi
{
	public static boolean newPost(String status) {
		WeiboParameters params = new WeiboParameters();
		params.put("status", status);
		
		try {
			JSONObject json = request(Constants.UPDATE, params, HTTP_POST);
			MessageModel msg = new Gson().fromJson(json.toString(), MessageModel.class);
			
			if (msg == null || msg.idstr == null || msg.idstr.trim().equals("")) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
