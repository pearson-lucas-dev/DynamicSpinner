package com.lucaspearson.dynamicspinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity {

	Button btnMove;
	 Spinner MySpinner1;
	 List<String> myList1;
	 private ArrayAdapter<String> myAdapter1;
	   
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        btnMove = (Button)findViewById(R.id.move);
	        MySpinner1 = (Spinner)findViewById(R.id.myspinner1);
	          
	        initList();
	        myAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myList1);
	        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        MySpinner1.setAdapter(myAdapter1);
	  
	        btnMove.setOnClickListener(MoveOnClickListener);
	    }
	      
	    Button.OnClickListener MoveOnClickListener
	    = new Button.OnClickListener(){
	  
	  @Override
	  public void onClick(View arg0) {
	   // TODO Auto-generated method stub
	   int pos = MySpinner1.getSelectedItemPosition();
	     
	   if(pos != AdapterView.INVALID_POSITION){
	    myList1.add(new Date().toString());
	    myAdapter1.notifyDataSetChanged();
	   }
	  }
};
	      
	    void initList(){
	     myList1 = new ArrayList<String>();
	     myList1.add("Sunday");
	     myList1.add("Monday");
	     myList1.add("Tuesday");
	     myList1.add("Wednesday");
	     myList1.add("Thursday");
	     myList1.add("Friday");
	     myList1.add("Saturday");
	    }
}
