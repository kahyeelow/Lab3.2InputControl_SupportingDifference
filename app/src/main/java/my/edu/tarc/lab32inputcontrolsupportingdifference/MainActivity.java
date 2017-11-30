package my.edu.tarc.lab32inputcontrolsupportingdifference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link UI to the program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //Create an adapter to load item into spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.age_group,
                android.R.layout.simple_spinner_item);//the activity(this) tell that adaptor to find
        // the resources age_group with the layout simple_spinner_item

        //the layout of whole dropdown list
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        //i want this
        spinnerAge.setOnItemSelectedListener(this);

        //tell spinner to set adapter to this adapter
        spinnerAge.setAdapter(adapter);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Position :" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos, premium = 0;

        int indexGender = radioGroupGender.getCheckedRadioButtonId();
        pos = spinnerAge.getSelectedItemPosition();
        //TODO : switch to search position
        switch(pos){
            case 0:
                premium = 50;
                break;
            case 1:
                premium = 55;
                break;
            case 2:
            {
                premium = 60;
                if(indexGender == R.id.radioButtonMale){
                    //TODO : calculate premium for male
                    premium += 50;
                }
            }
                break;
            case 3:
            {
                premium = 70;
                if(indexGender == R.id.radioButtonMale){
                    //TODO : calculate premium for male
                    premium += 100;
                }
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium for smoker
                    premium +=100;
                }
            }
                break;
            case 4:
            {
                premium = 120;
                if(indexGender == R.id.radioButtonMale){
                    //TODO : calculate premium for male
                    premium += 100;
                }
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium for smoker
                    premium +=150;
                }
            }

                break;
            case 5:
            {
                premium = 160;
                if(indexGender == R.id.radioButtonMale){
                    //TODO : calculate premium for male
                    premium += 50;
                }
                if(checkBoxSmoker.isChecked())
                {
                    //TODO: calculate premium for smoker
                    premium +=150;
                }
            }
                break;
            case 6: {
                premium = 200;
                if (checkBoxSmoker.isChecked()) {
                    //TODO: calculate premium for smoker
                    premium += 250;
                }
            }
                break;
            case 7:
            {
                premium =250;
                if(checkBoxSmoker.isChecked()) {
                    //TODO: calculate premium for smoker
                    premium += 250;
                }
            }
            break;

        }
        Locale locale = Locale.getDefault();

        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String currencyText = fmt.format(premium);

        //display premium
        textViewPremium.setText(getString(R.string.premium) + currencyText);

    }

    public void resetPremium(View view){
        //TODO: Reset the UI
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(true);
        checkBoxSmoker.setChecked(false);


    }
}
