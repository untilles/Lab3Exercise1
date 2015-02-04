package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;


public class CourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

    public void buttonClicked(View v) {
        Intent res = new Intent();
        EditText etCode = (EditText)findViewById(R.id.etCode);
        EditText etCr = (EditText)findViewById(R.id.etCR);

        RadioGroup rgGrade = (RadioGroup)findViewById(R.id.rgGrade);
        int selGrade = rgGrade.getCheckedRadioButtonId();
        String gGrade = null;

        if(selGrade == R.id.rbA) {
            gGrade = "A";
        } else if (selGrade == R.id.rbBP) {
            gGrade = "B+";
        } else if (selGrade == R.id.rbB) {
            gGrade = "B";
        } else if (selGrade == R.id.rbCP) {
            gGrade = "C+";
        } else if (selGrade == R.id.rbC) {
            gGrade = "C";
        } else if (selGrade == R.id.rbDP) {
            gGrade = "D+";
        } else if (selGrade == R.id.rbD) {
            gGrade = "D";
        } else if (selGrade == R.id.rbF) {
            gGrade = "F";
        }

        res.putExtra("code", etCode.getText().toString());
        res.putExtra("credit", etCr.getText().toString());
        res.putExtra("grade", gGrade);

        setResult(RESULT_OK, res);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
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
}
