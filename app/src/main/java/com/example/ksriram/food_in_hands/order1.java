package com.example.ksriram.food_in_hands;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class order1 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,AdapterView.OnItemSelectedListener
{
    String ServerURL = "https://learnfriendly.000webhostapp.com/final.php" ;
    EditText name, email;
    TextView date,time;
    Spinner people;
    Button button;
    String TempName, TempEmail, Tempdate, Temptime, Temppeople ;
    private ProgressDialog progressDialog;
    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order1);
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        name = (EditText)findViewById(R.id.editText2);
        email = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button2);
        date = (TextView)findViewById(R.id.tvDate);
        time = (TextView)findViewById(R.id.textView);
        people =(Spinner)findViewById(R.id.spinner1);


//textView.setText("Swipe Right to see images of:"+getIntent().getStringExtra("imagename")+"!");
        /*final TextView textView= (TextView)findViewById(R.id.textView);
               textView.setText("Swipe Right to see images of:"+getIntent().getStringExtra("imagename")+"!");
*/




        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        order1.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetData();

                InsertData(TempName,TempEmail,Tempdate,Temptime,Temppeople);

            }
        });

    }
    public void GetData(){

        TempName = name.getText().toString();

        TempEmail = email.getText().toString();

        Tempdate = date.getText().toString();

        Temptime = time.getText().toString();

        Temppeople = people.getSelectedItem().toString();;

    }

    public void InsertData(final String name, final String email, final  String date,final String time,final String people){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = name ;
                String EmailHolder = email ;
                String DateHolder = date;
                String TimeHolder = time;
                String PeopleHolder = people;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name",NameHolder));
                nameValuePairs.add(new BasicNameValuePair("email",EmailHolder));
                nameValuePairs.add(new BasicNameValuePair("date",DateHolder));
                nameValuePairs.add(new BasicNameValuePair("time",TimeHolder));
                nameValuePairs.add(new BasicNameValuePair("people",PeopleHolder));
                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPreExecute() {
                // TODO Auto-generated method stub
                super.onPreExecute();
                progressDialog = ProgressDialog.show(order1.this, "Just a minute","Wait....", true);
            }
            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);
                progressDialog.dismiss();
                Toast.makeText(order1.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(order1.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(name,email,date,time,people);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText("Hour: " + hourOfDay + " Minute: " + minute);

        String am_pm = "";

        Calendar datetime = Calendar.getInstance();
        datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        datetime.set(Calendar.MINUTE, minute);

        if (datetime.get(Calendar.AM_PM) == Calendar.AM)
            am_pm = "AM";
        else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
            am_pm = "PM";

        String strHrsToShow = (datetime.get(Calendar.HOUR) == 0) ?"12":datetime.get(Calendar.HOUR)+"";

        textView.setText( strHrsToShow+":"+datetime.get(Calendar.MINUTE)+" "+am_pm+" at:"+getIntent().getStringExtra("imagename"));

        //textView.setText("Swipe Right to see images of:"+getIntent().getStringExtra("imagename")+"!");
    }
}
