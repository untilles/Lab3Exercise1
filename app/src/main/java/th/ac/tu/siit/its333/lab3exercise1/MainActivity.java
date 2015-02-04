package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    int cr = 0;         // Credits
    double gp = 0.0;    // Grade points
    double gpa = 0.0;   // Grade point average

    List<String> listCodes;
    List<Integer> listCredits;
    List<String> listGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();

        //Use listCodes.add("ITS333"); to add a new course code
        //Use listCodes.size() to refer to the number of courses in the list
    }

    public void calculate() {

        int cr = 0;
        double gp = 0.0;
        double gpa = 0.0;
        int i = 0;

        for(i=0;i<listCodes.size();i++) {

            int ctemp = listCredits.get(i);
            double gtemp2 = 0.0;

            switch (listGrades.get(i)) {
                case("A"):
                    gtemp2 = 4.0;
                    break;
                case("B+"):
                    gtemp2 = 3.5;
                    break;
                case("B"):
                    gtemp2 = 3.0;
                    break;
                case("C+"):
                    gtemp2 = 2.5;
                    break;
                case("C"):
                    gtemp2 = 2.0;
                    break;
                case("D+"):
                    gtemp2 = 1.5;
                    break;
                case("D"):
                    gtemp2 = 1.0;
                    break;
                case("F"):
                    gtemp2 = 0.0;
                    break;
            }

            cr = cr + ctemp;
            gp = gp + (gtemp2 * ctemp);

        }

        gpa = gp/cr;

        TextView tvGP = (TextView)findViewById(R.id.tvGP);
        TextView tvCR = (TextView)findViewById(R.id.tvCR);
        TextView tvGPA = (TextView)findViewById(R.id.tvGPA);

        tvGP.setText(Double.toString(gp));
        tvCR.setText(Integer.toString(cr));
        tvGPA.setText(Double.toString(gpa));

    }

    public void buttonClicked(View v) {

        int id = v.getId();

        if(id == R.id.button4) {
            int index;
            String tvShow = null;
            Intent i = new Intent(this, CourseListActivity.class);

            for(index=0;index<listCodes.size();index++) {
                tvShow = listCodes.get(index) + " (" + listCredits.get(index) + " credits) = " + listGrades.get(index) + "\n";
            }

            i.putExtra("toList", tvShow);
            startActivity(i);

        } else if(id == R.id.button2) {
            Intent i = new Intent(this, CourseActivity.class);
            startActivityForResult(i, 999);

        } else if(id == R.id.button) {
            int cr = 0;
            double gp = 0.0;
            double gpa = 0.0;

            listCodes = new ArrayList<String>();
            listCredits = new ArrayList<Integer>();
            listGrades = new ArrayList<String>();

            TextView tvGP = (TextView)findViewById(R.id.tvGP);
            TextView tvCR = (TextView)findViewById(R.id.tvCR);
            TextView tvGPA = (TextView)findViewById(R.id.tvGPA);

            tvGP.setText(Double.toString(gp));
            tvCR.setText(Integer.toString(cr));
            tvGPA.setText(Double.toString(gpa));

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Values from child activity

        if(requestCode == 999) {
            if (resultCode == RESULT_OK) {
                listCodes.add(data.getStringExtra("code"));
                listCredits.add(Integer.parseInt(data.getStringExtra("credit")));
                listGrades.add(data.getStringExtra("grade"));
                calculate();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
