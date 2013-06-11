package com.example.gridimagesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class ImageFilterActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_filter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_filter, menu);
		return true;
	}

	public void onApplyFilterClick(View v) {
		AutoCompleteTextView actvImgSize = (AutoCompleteTextView)findViewById(R.id.actvImageSize);
		AutoCompleteTextView actvColorFilter = (AutoCompleteTextView)findViewById(R.id.actvColorFilter);
		AutoCompleteTextView actvImgType = (AutoCompleteTextView)findViewById(R.id.actvImageType);
		EditText etSiteFilter = (EditText)findViewById(R.id.etSiteFilter);
		
		Intent i = new Intent(this, SearchActivity.class);
		i.putExtra("size", actvImgSize.getText().toString());
		i.putExtra("color", actvColorFilter.getText().toString());
		i.putExtra("type", actvImgType.getText().toString());
		i.putExtra("site", etSiteFilter.getText().toString());
		setResult(RESULT_OK, i);
		finish();
	}

}
