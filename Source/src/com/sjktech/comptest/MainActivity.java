package com.sjktech.comptest;

import java.util.ArrayList;
import android.support.v7.app.ActionBarActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
	
	ListView list;
	private CustomAdapterGitList adapter;
	public ArrayList<ListModelGit> listDosesArray = new ArrayList<ListModelGit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list = (ListView)findViewById(R.id.listViewGit);
		listDosesArray.clear();
		
		for(int i =0; i< 18; i++){
			ListModelGit git = new ListModelGit();
			git.setCommitName("Name 1");
			git.setCommitVal("32");
			git.setCommitMessage("This is a test message");
			
			
			listDosesArray.add(git);
		}
		
		Resources res =getResources(); 
		adapter=new CustomAdapterGitList(this, listDosesArray);
		list.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
