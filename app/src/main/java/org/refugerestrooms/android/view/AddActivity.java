package org.refugerestrooms.android.view;

import java.util.List;

import org.refugerestrooms.android.model.Bathroom;
import org.refugerestrooms.android.server.Server;
import org.refugerestrooms.android.server.Server.ServerListener;

import org.refugerestrooms.android.R;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class AddActivity extends ActionBarActivity implements ServerListener {

	private Server mServer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);

		mServer = new Server(this);
		
	    ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	}

	public void onClickSubmit(View view) {
		mServer.submitNewEntry();
	}

	// Listener for server
	@Override
	public void onSearchResults(List<Bathroom> results) {
		// nothing
	}

	@Override
	public void onSubmission(boolean success) {
		if (success) {
			Toast.makeText(getApplicationContext(), R.string.success_toast, Toast.LENGTH_SHORT).show();
			finish();
		}
		else {
			Toast.makeText(getApplicationContext(), R.string.fail_toast, Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onError(String errorMessage) {
		Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
	}
	
}
