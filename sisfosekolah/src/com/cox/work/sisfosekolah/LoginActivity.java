package com.cox.work.sisfosekolah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText etUserName, etPwd;
	private TextView tvForgotPwd;
	private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        initView();
        initEventListener();
        
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

	private void initView() {
    	etUserName = (EditText) findViewById(R.id.et_username);
    	etPwd = (EditText) findViewById(R.id.et_password);
    	btnLogin =  (Button) findViewById(R.id.btn_login);
    	btnLogin.setEnabled(true);
    	tvForgotPwd =  (TextView) findViewById(R.id.tv_forgotpwd);
	}
    
    private void initEventListener() {
    	etUserName.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO
				//btnLogin.setEnabled(arg0.length()>0?true:false);
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
			}
		});
    	
    	btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				boolean isLoginOK = verifyLogin(etUserName.getText().toString(), etPwd.getText().toString());
				if(isLoginOK) {
			        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			        startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(), "Login FAIL! Please recheck your user id or password", Toast.LENGTH_SHORT).show();
				}
			}
		});
    	
    	tvForgotPwd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Try remember!", Toast.LENGTH_SHORT).show();
			}
		});
	}

    private boolean verifyLogin(String userId, String pwd) {
    	// TODO Make login verification
    	//return userId.equalsIgnoreCase(pwd)?true:false;
    	return true;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
