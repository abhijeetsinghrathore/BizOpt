package com.example.abhijeetsingh.bizopt;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class Employee extends AppCompatActivity {
    DrawerLayout dLayoutEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        setNavigationDrawerEmployee();
    }

    private void setNavigationDrawerEmployee() {
        dLayoutEmployee = (DrawerLayout) findViewById(R.id.employee_layout); // initiate a DrawerLayout
        NavigationView EmployeenavView = (NavigationView) findViewById(R.id.Employeenavigation); // initiate a Navigation View
// implement setNavigationItemSelectedListener event on NavigationView
        EmployeenavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment employeefrag = null; // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id
// check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.firstemployee) {
                    employeefrag = new Employee_FirstFragment();
                } else if (itemId == R.id.secondemployee) {
                    employeefrag = new Employee_SecondFragment();
                } else if (itemId == R.id.thirdemployee) {
                    employeefrag = new Employee_ThirdFragment();
                }
                else if (itemId == R.id.fourthemployee) {
                    employeefrag = new Employee_FourthFragment();
                }
                else if (itemId == R.id.fifthemployee) {
                    employeefrag = new Employee_Fifthfragment();
                }
// display a toast message with menu item's title
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                if (employeefrag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.Employeeframe, employeefrag); // replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayoutEmployee.closeDrawers(); // close the all open Drawer Views
                    return true;
                }
                return false;
            }
        });
    }
}
