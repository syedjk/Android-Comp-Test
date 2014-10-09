package com.sjktech.comptest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapterGitList extends BaseAdapter implements OnClickListener {
    
	/*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    ListModelGit tempValues=null;
    int i=0;
    
    /*************  CustomAdapter Constructor *****************/
    public CustomAdapterGitList(Activity a, ArrayList d) {
    	
    	/********** Take passed values **********/
        activity = a;
        data=d;
        
        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {
    	
    	if(data.size()<=0)
    		return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    /********* Create a holder to contain inflated xml file elements ***********/
    public static class ViewHolder{
        public TextView textName;
        public TextView textVal;
        public TextView textMessage;
    }

    /*********** Depends upon data size called for each row , Create each ListView row ***********/
    public View getView(final int position, View convertView, ViewGroup parent) {
    	
        View vi=convertView;
        final ViewHolder holder;
        
        if(convertView==null){ 
        	
        	/********** Inflate tabitem.xml file for each row ( Defined below ) ************/
            vi = inflater.inflate(R.layout.list_git, null); 
            
            /******** View Holder Object to contain tabitem.xml file elements ************/
            holder=new ViewHolder();
            holder.textName=(TextView)vi.findViewById(R.id.textName);
            holder.textVal=(TextView)vi.findViewById(R.id.textVal);
            holder.textMessage=(TextView)vi.findViewById(R.id.textMessage);
           /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        }
        else
            holder=(ViewHolder)vi.getTag();
            
        
        if(data.size()<=0)
        {
            
        }
        else
        {
        	/***** Get each Model object from Arraylist ********/
	        tempValues=null;
	        tempValues = (ListModelGit) data.get(position);
	        
	        /************  Set Model values in Holder elements ***********/
	         holder.textName.setText(tempValues.getCommitName());
	         holder.textVal.setText("Commit " + tempValues.getCommitVal());
	         holder.textMessage.setText(tempValues.getCommitMessage());	         

	         /******** Set Item Click Listner for LayoutInflater for each row ***********/
	         vi.setOnClickListener(new OnItemClickListener(position));
	         
        }
        return vi;
    }
    
    @Override
    public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked");
    }
    
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener implements OnClickListener{           
        private int mPosition;
        
        OnItemClickListener(int position){
        	mPosition = position;
        }
        
        @Override
        public void onClick(View arg0) {
        }               
    }   
}