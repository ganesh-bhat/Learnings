package vault.emacs.com.securevault;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import com.arlib.floatingsearchview.FloatingSearchView;


import vault.emacs.com.securevault.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        
        
        setContentView(R.layout.activity_main);


        String[] applicationOptionsArray = getResources().getStringArray(R.array.drawer_application_options);
        String[] sampleTagsArray = getResources().getStringArray(R.array.drawer_sample_tags);

        binding.drawerApplicationOptionsList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,applicationOptionsArray));
        binding.drawerTagsList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sampleTagsArray));

        binding.mainBody.floatingSearchView.setOnLeftMenuClickListener(
                new FloatingSearchView.OnLeftMenuClickListener() {

                    @Override
                    public void onMenuOpened() {
                        binding.drawerLayout.openDrawer(Gravity.START,true);
                    }

                    @Override
                    public void onMenuClosed() {
                        binding.drawerLayout.closeDrawer(Gravity.START);
                    }
                } );

        binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {

            }

            @Override
            public void onDrawerClosed(View view) {
                if(binding.mainBody.floatingSearchView!=null) {
                    binding.mainBody.floatingSearchView.closeMenu(true);
                }
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }


    public void onFabClick(View view) {
       Intent intent = new Intent(this,AddVaultItemActivity.class);
       startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
