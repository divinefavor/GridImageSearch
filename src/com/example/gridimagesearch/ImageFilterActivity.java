package com.example.gridimagesearch;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ImageFilterActivity extends Activity implements OnItemSelectedListener {
	private Spinner spnrSize;
	private Spinner spnrColor;
	private Spinner spnrType;
	private EditText etSite;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_filter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_filter, menu);
		
		// Spinner elements
		spnrSize = (Spinner)findViewById(R.id.spnrImageSize);
		spnrColor = (Spinner)findViewById(R.id.spnrColorFilter);
		spnrType = (Spinner)findViewById(R.id.spnrImageType);
		etSite = (EditText)findViewById(R.id.etSiteFilter);
		
		// Spinner click listener
		spnrSize.setOnItemSelectedListener(this);
		spnrColor.setOnItemSelectedListener(this);
		spnrType.setOnItemSelectedListener(this);
		
		// Spinner dropdown elements
		List<String> catSize = new ArrayList<String>();
		List<String> catColor = new ArrayList<String>();
		List<String> catType = new ArrayList<String>();
		
		// "icon", "small", "medium", "large", "xlarge", "xxlarge", "huge"
		catSize.add("icon");
		catSize.add("small");
		catSize.add("medium");
		catSize.add("large");
		catSize.add("xlarge");
		catSize.add("xxlarge");
		catSize.add("huge");
		
		catType.add("jpg");
		catType.add("gif");
		catType.add("bmp");
		catType.add("png");
				
		catColor.add("black");
		catColor.add("blue");
		catColor.add("gray");
		catColor.add("green");
		catColor.add("orange");
		catColor.add("pink");
		catColor.add("purple");
		catColor.add("red");
		catColor.add("teal");
		catColor.add("white");
		catColor.add("yello");
		
		// Creating adapter for spinner
		ArrayAdapter<String> sizeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, catSize);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, catColor);
		ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, catType);
		// attach adapter to spinners
		spnrSize.setAdapter(sizeAdapter);
		spnrColor.setAdapter(colorAdapter);
		spnrType.setAdapter(typeAdapter);
		
		return true;
	}

	
	public void onApplyFilterClick(View v) {
		
		
		Intent i = new Intent(this, SearchActivity.class);
		i.putExtra("size", spnrSize.getSelectedItem().toString());
		i.putExtra("color", spnrColor.getSelectedItem().toString());
		i.putExtra("type", spnrType.getSelectedItem().toString());
		i.putExtra("site", etSite.getText().toString());
		startActivity(i);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
