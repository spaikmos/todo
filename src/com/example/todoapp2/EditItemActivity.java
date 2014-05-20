package com.example.todoapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends ActionBarActivity {
	private int itemIdx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		// Get the string of the item to edit and populate the field
		String itemText = getIntent().getStringExtra("itemText");
		itemIdx = getIntent().getIntExtra("idx", 0);
		EditText etEditItem = (EditText)findViewById(R.id.etEditItem);
		etEditItem.setText(itemText);
	}
	
	public void editClick(View v) {
		EditText etNewItem = (EditText)findViewById(R.id.etEditItem);
		
		// Create intent to send back to main activity
		Intent data = new Intent();
		data.putExtra("itemText", etNewItem.getText().toString());
		data.putExtra("idx", itemIdx);
		setResult(RESULT_OK, data);
		finish();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
