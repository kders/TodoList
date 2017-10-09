package kders.app.todolist.view.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.Stack;

import kders.app.todolist.R;
import kders.app.todolist.databinding.ActivityMainBinding;
import kders.app.todolist.view.common.BaseFragment;
import kders.app.todolist.view.common.BaseFragmentActivity;
import kders.app.todolist.view.fragment.TaskListFragment;
import kders.app.todolist.view.fragment.TaskListListener;

public class HomeActivity extends BaseFragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener, TaskListListener{
    public static final int FRAGMENT_TASK_LIST= 0;
    public static final int FRAGMENT_TASK_ADD = 1;

    private static final String TAG = HomeActivity.class.getName();

    private FragmentManager mFragmentManager;
    private Stack<Fragment> mFragmentStack;
    private ActivityMainBinding mBinding;

    private TaskListFragment mFragmentTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupLayout();
        setupData();
    }

    private void setupLayout() {
        setSupportActionBar(mBinding.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout, mBinding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        mBinding.drawerLayout.setDrawerListener(toggle);
        mBinding.navView.setNavigationItemSelectedListener(this);
    }

    private void setupData(){
        mFragmentStack = new Stack<>();
        mFragmentManager = getFragmentManager();

        mFragmentTaskList = new TaskListFragment();
        mFragmentTaskList.setListener(this);

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container, mFragmentTaskList);
        mFragmentStack.push(mFragmentTaskList);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void clickDialogPositiveText(int requestCode) {

    }

    @Override
    public void clickDialogNegativeText(int requestCode) {

    }
}