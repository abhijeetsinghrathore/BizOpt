package com.example.abhijeetsingh.bizopt;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Sign_up extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private android.widget.ImageView mdate;
    private EditText DOB;
    private Button SignUp2;
    Spinner spin;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String Roles[]={"Employee","HR","Trainee","Vendor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SignUp2=(Button)findViewById(R.id.SignUp2);


        mdate=(ImageView)findViewById(R.id.calendar);
        DOB=(EditText)findViewById(R.id.dob);
        mdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Sign_up.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                DOB.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, year, month, day);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();


            }
        });


//
        spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the designation name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Roles);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


        SignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected_role=spin.getSelectedItem().toString();
                if(selected_role.equals("Trainee"))
                {
                    Intent i=new Intent(Sign_up.this,Trainee.class);
                    startActivity(i);
                }
                else if (selected_role.equals("Employee"))
                {
                    Intent i1=new Intent(Sign_up.this,Employee.class);
                    startActivity(i1);
                }

                else if(selected_role.equals("HR"))
                {
                    Intent i2=new Intent(Sign_up.this,HR.class);
                    startActivity(i2);
                }
                else if(selected_role.equals("Vendor"))
                {
                    Intent i3=new Intent(Sign_up.this,Vendor.class);
                    startActivity(i3);
                }
            }
        });

    }














    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getApplicationContext(), designations[position], Toast.LENGTH_LONG).show();
    }
    //Performing action onItemSelected and onNothing selected

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(getApplicationContext(), "Select designation", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
