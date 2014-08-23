package com.cox.work.sisfosekolah;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
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
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.cox.work.sisfosekolah.adapter.SimpleTabPagerAdapter;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	private EditText etUserName,
					etPwd;
	private TextView tvForgotPwd;
	private Button btnLogin;
	private SimpleTabPagerAdapter tabPagerAdapter;
	private ViewPager mViewPager;
	private ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_main);
        
        initView();
        initEventListener();
        

		for (int i = 0; i < tabPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
					.setText(tabPagerAdapter.getPageTitle(i))					
					.setTabListener(this));
		}
    }

	private void initView() {
    	etUserName = (EditText) findViewById(R.id.et_username);
    	etPwd = (EditText) findViewById(R.id.et_password);
    	btnLogin =  (Button) findViewById(R.id.btn_login);
    	tvForgotPwd =  (EditText) findViewById(R.id.tv_forgotpwd);
    	
    	tabPagerAdapter = new SimpleTabPagerAdapter(getSupportFragmentManager());
    	actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(tabPagerAdapter);
    }
    
    private void initEventListener() {
//    	etUserName.addTextChangedListener(new TextWatcher() {
//			@Override
//			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//				btnLogin.setEnabled(arg0.length()>0?true:false);
//			}
//			
//			@Override
//			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//					int arg3) {
//			}
//			
//			@Override
//			public void afterTextChanged(Editable arg0) {
//			}
//		});
//    	
//    	btnLogin.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
//				boolean isLoginOK = verifyLogin(etUserName.getText().toString(), etPwd.getText().toString());
//				if(isLoginOK) {
//					
//				}
//			}
//		});
//    	
//    	tvForgotPwd.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(getApplicationContext(), "Try remember!", Toast.LENGTH_SHORT).show();
//			}
//		});

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}

    private boolean verifyLogin(String userId, String pwd) {
    	return true;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
    
}
