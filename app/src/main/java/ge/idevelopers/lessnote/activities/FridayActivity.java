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

public class FridayActivity extends AppCompatActivity {

    //=========================================================================
    //les1
    final int DIALOG_ID_1 = 1;
    final String FRI_HOUR_1 = "fri hour 1";
    final String FRI_MINUTE_1 = "fri minute 1";
    int hours1, minutes1;
    private TextView tv_time_1;
    final String FRI_LESS_1 = "fri less 1";

    //les2
    final int DIALOG_ID_2 = 2;
    final String FRI_HOUR_2 = "fri hour 2";
    final String FRI_MINUTE_2 = "fri minute 2";
    int hours2, minutes2;
    private TextView tv_time_2;
    final String FRI_LESS_2 = "fri less 2";

    //les3
    final int DIALOG_ID_3 = 3;
    final String FRI_HOUR_3 = "fri hour 3";
    final String FRI_MINUTE_3 = "fri minute 3";
    int hours3, minutes3;
    private TextView tv_time_3;
    final String FRI_LESS_3 = "fri less 3";

    //les4
    final int DIALOG_ID_4 = 4;
    final String FRI_HOUR_4 = "fri hour 4";
    final String FRI_MINUTE_4 = "fri minute 4";
    int hours4, minutes4;
    private TextView tv_time_4;
    final String FRI_LESS_4 = "fri less 4";

    //les5
    final int DIALOG_ID_5 = 5;
    final String FRI_HOUR_5 = "fri hour 5";
    final String FRI_MINUTE_5 = "fri minute 5";
    int hours5, minutes5;
    private TextView tv_time_5;
    final String FRI_LESS_5 = "fri less 5";

    //les6
    final int DIALOG_ID_6 = 6;
    final String FRI_HOUR_6 = "fri hour 6";
    final String FRI_MINUTE_6 = "fri minute 6";
    int hours6, minutes6;
    private TextView tv_time_6;
    final String FRI_LESS_6 = "fri less 6";

    //les7
    final int DIALOG_ID_7 = 7;
    final String FRI_HOUR_7 = "fri hour 7";
    final String FRI_MINUTE_7 = "fri minute 7";
    int hours7, minutes7;
    private TextView tv_time_7;
    final String FRI_LESS_7 = "fri less 7";

    int[] hours = new int[7];
    int[] minutes = new int[7];

    private EditText et_les_1;
    private EditText et_les_2;
    private EditText et_les_3;
    private EditText et_les_4;
    private EditText et_les_5;
    private EditText et_les_6;
    private EditText et_les_7;
    private Button btnFr;
    private EditText [] edittexts = new EditText[7];


//=========================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);
        initView();
        Connections.fillLessonHints(edittexts);
        filltextbtn();

        hours[0] = hours1;
        hours[1] = hours2;
        hours[2] = hours3;
        hours[3] = hours4;
        hours[4] = hours5;
        hours[5] = hours6;
        hours[6] = hours7;

        minutes[0] = minutes1;
        minutes[1] = minutes2;
        minutes[2] = minutes3;
        minutes[3] = minutes4;
        minutes[4] = minutes5;
        minutes[5] = minutes6;
        minutes[6] = minutes7;

    }
    private void filltextbtn(){
        String languageCHosen = LessNoteApplication.getInstce().getSharedString(MyConstants.LANGUGE_CHOSEN);

        if (languageCHosen.equals("") || languageCHosen.equals(MyConstants.LAN_GEORGIA)) {
            btnFr.setText("პარასკევი");
        } else if (languageCHosen.equals(MyConstants.LAN_ENGLISH)) {
            btnFr.setText("Friday");
        } else if (languageCHosen.equals(MyConstants.LAN_RUSSIAN)) {
            btnFr.setText("Пятница");
        }
        else if (languageCHosen.equals(MyConstants.LAN_CHINISE)) {
            btnFr.setText("星期五");
        }
        else if (languageCHosen.equals(MyConstants.LAN_INDIAN)) {
            btnFr.setText("शुक्रवार");
        }
        else {
            btnFr.setText("Viernes");
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

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_1) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_1) == 0)) {
            Connections.setTvTime(tv_time_1, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_1), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_1));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_2) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_2) == 0)) {
            Connections.setTvTime(tv_time_2, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_2), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_2));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_3) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_3) == 0)) {
            Connections.setTvTime(tv_time_3, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_3), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_3));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_4) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_4) == 0)) {
            Connections.setTvTime(tv_time_4, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_4), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_4));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_5) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_5) == 0)) {
            Connections.setTvTime(tv_time_5, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_5), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_5));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_6) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_6) == 0)) {
            Connections.setTvTime(tv_time_6, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_6), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_6));
        }

        if (!(LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_7) == 0 && LessNoteApplication
                .getInstce().getSharedInt(FRI_MINUTE_7) == 0)) {
            Connections.setTvTime(tv_time_7, LessNoteApplication.getInstce().getSharedInt(FRI_HOUR_7), LessNoteApplication
                    .getInstce().getSharedInt(FRI_MINUTE_7));
        }

        et_les_1 = (EditText) findViewById(R.id.et_les_1);
        et_les_1.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_1));
        et_les_2 = (EditText) findViewById(R.id.et_les_2);
        et_les_2.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_2));
        et_les_3 = (EditText) findViewById(R.id.et_les_3);
        et_les_3.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_3));
        et_les_4 = (EditText) findViewById(R.id.et_les_4);
        et_les_4.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_4));
        et_les_5 = (EditText) findViewById(R.id.et_les_5);
        et_les_5.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_5));
        et_les_6 = (EditText) findViewById(R.id.et_les_6);
        et_les_6.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_6));
        et_les_7 = (EditText) findViewById(R.id.et_les_7);
        et_les_7.setText(LessNoteApplication.getInstce().getSharedString(FRI_LESS_7));
        btnFr = (Button) findViewById(R.id.btnFriday);
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
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_1, et_les_1.getText().toString());
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_2, et_les_2.getText().toString());
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_3, et_les_3.getText().toString());
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_4, et_les_4.getText().toString());
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_5, et_les_5.getText().toString());
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_6, et_les_6.getText().toString());
        LessNoteApplication.getInstce().setSharedString(FRI_LESS_7, et_les_7.getText().toString());
        super.onBackPressed();
    }

    //=========================================================================

    //=========================================================================

    public void timeDialog(View view) {
        switch (view.getId()) {
            case R.id.tv_time_1:
                showDialog(DIALOG_ID_1);
                break;
            case R.id.tv_time_2:
                showDialog(DIALOG_ID_2);
                break;
            case R.id.tv_time_3:
                showDialog(DIALOG_ID_3);
                break;
            case R.id.tv_time_4:
                showDialog(DIALOG_ID_4);
                break;
            case R.id.tv_time_5:
                showDialog(DIALOG_ID_5);
                break;
            case R.id.tv_time_6:
                showDialog(DIALOG_ID_6);
                break;
            case R.id.tv_time_7:
                showDialog(DIALOG_ID_7);
                break;
        }

    }


    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID_1) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener1, hours1, minutes1, false);
        } else if (id == DIALOG_ID_2) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener2, hours2, minutes2, false);
        } else if (id == DIALOG_ID_3) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener3, hours3, minutes3, false);
        } else if (id == DIALOG_ID_4) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener4, hours4, minutes4, false);
        } else if (id == DIALOG_ID_5) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener5, hours5, minutes5, false);
        } else if (id == DIALOG_ID_6) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener6, hours6, minutes6, false);
        } else if (id == DIALOG_ID_7) {
            return new TimePickerDialog(FridayActivity.this, timePickerListener7, hours7, minutes7, false);
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

    protected TimePickerDialog.OnTimeSetListener timePickerListener1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours1 = hourOfDay;
            minutes1 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_1, hours1);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_1, minutes1);

            Connections.setTvTime(tv_time_1, hours1, minutes1);
        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours2 = hourOfDay;
            minutes2 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_2, hours2);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_2, minutes2);

            Connections.setTvTime(tv_time_2, hours2, minutes2);
        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener3 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours3 = hourOfDay;
            minutes3 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_3, hours3);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_3, minutes3);

            Connections.setTvTime(tv_time_3, hours3, minutes3);
        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener4 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours4 = hourOfDay;
            minutes4 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_4, hours4);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_4, minutes4);

            Connections.setTvTime(tv_time_4, hours4, minutes4);
        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener5 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours5 = hourOfDay;
            minutes5 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_5, hours5);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_5, minutes5);

            Connections.setTvTime(tv_time_5, hours5, minutes5);
        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener6 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours6 = hourOfDay;
            minutes6 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_6, hours6);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_6, minutes6);

            Connections.setTvTime(tv_time_6, hours6, minutes6);
        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener7 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hours7 = hourOfDay;
            minutes7 = minute;

            LessNoteApplication.getInstce().setSharedInt(FRI_HOUR_7, hourOfDay);
            LessNoteApplication.getInstce().setSharedInt(FRI_MINUTE_7, minutes7);

            Connections.setTvTime(tv_time_7, hourOfDay, minutes7);
        }
    };

    //=========================================================================

    public void finish(View v){
        onBackPressed();
    }


    //=========================================================================


}
