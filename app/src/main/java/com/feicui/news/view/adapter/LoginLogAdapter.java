package com.feicui.news.view.adapter;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.feicui.news.R;
import com.feicui.news.model.entity.LoginLog;

public class LoginLogAdapter extends MyBaseAdapter {

	public LoginLogAdapter(Context context , List<LoginLog> list ) {
		super(context);
	}

	@Override
	public int getCount() {
		return myList.size();
	}

	@Override
	public Object getItem(int position) {
		return myList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}


	@Override
	public View getMyView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_login_log, null);
			
			viewHolder.loginTimeTv = (TextView) convertView.findViewById(R.id.login_time);
			viewHolder.loginAddTv = (TextView) convertView.findViewById(R.id.login_address);
			viewHolder.loginTypeTv = (TextView) convertView.findViewById(R.id.login_type);
			
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		LoginLog log =(LoginLog) myList.get(position);
		viewHolder.loginTimeTv.setText(log.getTime().split(" ")[0]);
		viewHolder.loginAddTv.setText(log.getAddress());
		viewHolder.loginTypeTv.setText(log.getDevice()==1?"PC�˵�¼":"�ƶ��˵�¼");
		return convertView;
	}
	
	
	class ViewHolder{
		TextView loginTimeTv , loginAddTv , loginTypeTv;
	}

}
