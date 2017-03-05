package ge.idevelopers.lessnote.activities;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import ge.idevelopers.lessnote.R;
import ge.idevelopers.lessnote.application.LessNoteApplication;
import ge.idevelopers.lessnote.helpers.Connections;
import ge.idevelopers.lessnote.helpers.MyConstants;

public class TuesdayActivity extends AppCompatActivity {

    //=========================================================================
    //les1
    final int DIALOG_ID_TUE1 = 1;
    final String TUE_HOUR_1 = "tue hour 1";
    final String TUE_MINUTE_1 = "tue minute 1";
    int tueHours1, tueMinutes1;
    private TextView tv_time_1;
    final String TUE_LESS_1 = "tue less 1";

    //les2
    final int DIALOG_ID_TUE2 = 2;
    final String TUE_HOUR_2 = "tue hour 2";
    final String TUE_MINUTE_2 = "tue minute 2";
    int tueHours2, tueMinutes2;
    private TextView tv_time_2;
    final String TUE_LESS_2 = "tue less 2";

    //les3
    final int DIALOG_ID_TUE3 = 3;
    final String TUE_HOUR_3 = "tue hour 3";
    final String TUE_MINUTE_3 = "tue minute 3";
    int tueHours3, tueMinutes3;
    private TextView tv_time_3;
    final String TUE_LESS_3 = "tue less 3";

    //les4
    final int DIALOG_ID_TUE4 = 4;
    final String TUE_HOUR_4 = "tue hour 4";
    final String TUE_MINUTE_4 = "tue minute 4";
    int tueHours4, tueMinutes4;
    private TextView tv_time_4;
    final String TUE_LESS_4 = "tue less 4";

    //les5
    final int DIALOG_ID_TUE5 = 5;
    final String TUE_HOUR_5 = "tue hour 5";
    final String TUE_MINUTE_5 = "tue minute 5";
    int tueHours5, tueMinutes5;
    private TextView tv_time_5;
    final String TUE_LESS_5 = "tue less 5";

    //les6
    final int DIALOG_ID_TUE6 = 6;
    final String TUE_HOUR_6 = "tue hour 6";
    final String TUE_MINUTE_6 = "tue minute 6";
    int tueHours6, tueMinutes6;
    private TextView tv_time_6;
    final String TUE_LESS_6 = "tue less 6";

    //les7
    final int DIALOG_ID_TUE7 = 7;
    final String TUE_HOUR_7 = "tue hour 7";
    final String TUE_MINUTE_7 = "tue minute 7";
    int tueHours7, tueMinutes7;
    private TextView tv_time_7;
    final String TUE_LESS_7 = "tue less 7";

    int[] hours = new int[7];
    int[] minutes = new int[7];

    private EditText et_les_1;
    private EditText et_les_2;
    private EditText et_les_3;
    private EditText et_les_4;
    private EditText et_les_5;
    private EditText et_les_6;
    private EditText et_les_7;
    private Button btnTue;
    private EditText [] edittexts = new EditText[7];


//=========================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
        initView();
        Connections.fillLessonHints(edittexts);
        filltextbtn();
        hours[0] = tueHours1;
        hours[1] = tueHours2;
        hours[2] = tueHours3;
        hours[3] = tueHours4;
        hours[4] = tueHours5;
        hours[5] = tueHours6;
        hours[6] = tueHours7;

        minutes[0] = tueMinutes1;
        minutes[1] = tueMinutes2;
        minutes[2] = tueMinutes3;
        minutes[3] = tueMinutes4;
        minutes[4] = tueMinutes5;
        minutes[5] = tueMinutes6;
        minutes[6] = tueMinutes7;



    }
    private void filltextbtn(){
        String languageCHosen = LessNoteApplication.getInstce().getSharedString(MyConstants.LANGUGE_CHOSEN);

        if (languageCHosen.equals("") || languageCHosen.equals(MyConstants.LAN_GEORGIA)) {
            btnTue.setText("სამშაბათი");
        } else if (languageCHosen.equals(MyConstants.LAN_ENGLISH)) {
            btnTue.setText("Tuesday");
        } else if (languageCHosen.equals(MyConstants.LAN_RUSSIAN)) {
            btnTue.setText("Вторник");
        }
        else if (languageCHosen.equals(MyConstants.LAN_CHINISE)) {
            btnTue.setText("星期二");
        }
        else if (languageCHosen.equals(MyConstants.LAN_INDIAN)) {
            btnTue.setText("मंगलवार");
        }
        else {
            btnTue.setText("Martes");
        }
    }

    //=========================================================================

    private void initView() {
        tv_time_1 = (TextView) findViewById(R.id.tv_time_1);
        tv_time_2 = (TextView) findViewById(R.id.tv_time_2);
        tv_time_3 = (TextView) findViewById(R.id.tv_time_3);
        tv_time_4 = (TextView) findViewById(R.id.tv_time_4);
        tv_time_5 = (TextView) findViewById(R.id.tv_time_5);
        tv_time_6 = (TextView) findViewById(R.id.tv_time_6);
        tv_time_7 = (TextView) findViewById(R.id.tv_time_7);
        btnTue = (Button) findViewById(R.id.btnTuesday);
        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_1) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_1) == 0)) {
            Connections.setTvTime(tv_time_1, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_1), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_1));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_2) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_2) == 0)) {
            Connections.setTvTime(tv_time_2, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_2), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_2));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_3) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_3) == 0)) {
            Connections.setTvTime(tv_time_3, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_3), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_3));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_4) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_4) == 0)) {
            Connections.setTvTime(tv_time_4, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_4), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_4));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_5) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_5) == 0)) {
            Connections.setTvTime(tv_time_5, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_5), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_5));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_6) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_6) == 0)) {
            Connections.setTvTime(tv_time_6, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_6), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_6));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_7) == 0 && LessNoteApplication
                .getInstce().getSharedInt(TUE_MINUTE_7) == 0)) {
            Connections.setTvTime(tv_time_7, LessNoteApplication.getInstce().getSharedInt(TUE_HOUR_7), LessNoteApplication
                    .getInstce().getSharedInt(TUE_MINUTE_7));
        }

        et_les_1 = (EditText) findViewById(R.id.et_les_1);
        et_les_1.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_1));
        et_les_2 = (EditText) findViewById(R.id.et_les_2);
        et_les_2.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_2));
        et_les_3 = (EditText) findViewById(R.id.et_les_3);
        et_les_3.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_3));
        et_les_4 = (EditText) findViewById(R.id.et_les_4);
        et_les_4.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_4));
        et_les_5 = (EditText) findViewById(R.id.et_les_5);
        et_les_5.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_5));
        et_les_6 = (EditText) findViewById(R.id.et_les_6);
        et_les_6.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_6));
        et_les_7 = (EditText) findViewById(R.id.et_les_7);
        et_les_7.setText(LessNoteApplication.getInstce().getSharedString(TUE_LESS_7));

        edittexts [0] = et_les_1;
        edittexts [1] = et_les_2;
        edittexts [2] = et_les_3;
        edittexts [3] = et_les_4;
        edittexts [4] = et_les_5;
        edittexts [5] = et_les_6;
        edittexts [6] = et_les_7;
    }

    @Override
    public void onBackPressed() {
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_1, et_les_1.getText().toString());
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_2, et_les_2.getText().toString());
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_3, et_les_3.getText().toString());
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_4, et_les_4.getText().toString());
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_5, et_les_5.getText().toString());
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_6, et_les_6.getText().toString());
        LessNoteApplication.getInstce().setSharedString(TUE_LESS_7, et_les_7.getText().toString());
        super.onBackPressed();
    }

    //=========================================================================

    //=========================================================================

    public void timeDialog(View view) {
        switch (view.getId()) {
            case R.id.tv_time_1:
                showDialog(DIALOG_ID_TUE1);
                break;
            case R.id.tv_time_2:
                showDialog(DIALOG_ID_TUE2);
                break;
            case R.id.tv_time_3:
                showDialog(DIALOG_ID_TUE3);
                break;
            case R.id.tv_time_4:
                showDialog(DIALOG_ID_TUE4);
                break;
            case R.id.tv_time_5:
                showDialog(DIALOG_ID_TUE5);
                break;
            case R.id.tv_time_6:
                showDialog(DIALOG_ID_TUE6);
                break;
            case R.id.tv_time_7:
                showDialog(DIALOG_ID_TUE7);
                break;
        }

    }


    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID_TUE1) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener1, tueHours1, tueMinutes1, false);
        } else if (id == DIALOG_ID_TUE2) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener2, tueHours2, tueMinutes2, false);
        } else if (id == DIALOG_ID_TUE3) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener3, tueHours3, tueMinutes3, false);
        } else if (id == DIALOG_ID_TUE4) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener4, tueHours4, tueMinutes4, false);
        } else if (id == DIALOG_ID_TUE5) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener5, tueHours5, tueMinutes5, false);
        } else if (id == DIALOG_ID_TUE6) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener6, tueHours6, tueMinutes6, false);
        } else if (id == DIALOG_ID_TUE7) {
            return new TimePickerDialog(TuesdayActivity.this, monTimePickerListener7, tueHours7, tueMinutes7, false);
        }
        return null;
    }

    //=========================================================================

    //=========================================================================

//    protected TimePickerDialog.OnTimeSetListener monTimePickerListener (final int index, final String TUE_HOUR, final String TUE_MINUTE, final TextView textView){
//        return new TimePickerDialog.OnTimeSetListener(){
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                hours[index-1] = hourOfDay;
//                minutes[index-1] = minute;
//
//                LessNoteApplication.getInstce().setSharedInt(TUE_HOUR, hourOfDay);
//                LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE, minute);
//
//                Connections.setTvTime(textView, hourOfDay, minute);
//
//            }
//        };
//    }

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours1 = hourOfDay;
            tueMinutes1 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_1, tueHours1);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_1, tueMinutes1);

            Connections.setTvTime(tv_time_1, tueHours1, tueMinutes1);
        }
    };

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours2 = hourOfDay;
            tueMinutes2 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_2, tueHours2);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_2, tueMinutes2);

            Connections.setTvTime(tv_time_2, tueHours2, tueMinutes2);
        }
    };

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener3 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours3 = hourOfDay;
            tueHours3 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_3, tueHours3);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_3, tueHours3);

            Connections.setTvTime(tv_time_3, tueHours3, tueHours3);
        }
    };

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener4 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours4 = hourOfDay;
            tueMinutes4 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_4, tueHours4);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_4, tueMinutes4);

            Connections.setTvTime(tv_time_4, tueHours4, tueMinutes4);
        }
    };

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener5 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours5 = hourOfDay;
            tueMinutes5 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_5, tueHours5);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_5, tueMinutes5);

            Connections.setTvTime(tv_time_5, tueHours5, tueMinutes5);
        }
    };

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener6 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours6 = hourOfDay;
            tueMinutes6 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_6, tueHours6);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_6, tueMinutes6);

            Connections.setTvTime(tv_time_6, tueHours6, tueMinutes6);
        }
    };

    protected TimePickerDialog.OnTimeSetListener monTimePickerListener7 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tueHours7 = hourOfDay;
            tueMinutes7 = minute;

            LessNoteApplication.getInstce().setSharedInt(TUE_HOUR_7, hourOfDay);
            LessNoteApplication.getInstce().setSharedInt(TUE_MINUTE_7, tueMinutes7);

            Connections.setTvTime(tv_time_7, hourOfDay, tueMinutes7);
        }
    };

    //=========================================================================

    public void finish(View v){
        onBackPressed();
    }


    //=========================================================================


}
