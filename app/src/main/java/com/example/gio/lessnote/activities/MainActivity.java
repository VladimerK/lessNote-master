package com.example.gio.lessnote.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.gio.lessnote.LanguagesFragment;
import com.example.gio.lessnote.R;
import com.example.gio.lessnote.application.LessNoteApplication;
import com.example.gio.lessnote.helpers.MyConstants;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    public static final int MONDEY_REQUEST = 1;
    public static final int TUESTDAY_REQUEST = 2;
    public static final int WEDNESDAY_REQUEST = 3;
    public static final int THURSDAY_REQUEST = 4;
    public static final int FRIDAY_REQUEST = 5;
    public static final int SATURDAY_REQUEST = 6;
    public static final int SUNDAY_REQUEST = 7;

    private Button btnMonday;
    private ImageView ivMonday;
    private RelativeLayout rlMonday;
    private Button btnTuesday;
    private ImageView ivTuesday;
    private RelativeLayout rlTuesday;
    private Button btnWednesday;
    private ImageView ivWednesday;
    private RelativeLayout rlWednesday;
    private Button btnThursday;
    private ImageView ivThursday;
    private RelativeLayout rlThursday;
    private Button btnFriday;
    private ImageView ivFriday;
    private RelativeLayout rlFriday;
    private Button btnSaturday;
    private ImageView ivSaturday;
    private RelativeLayout rlSaturday;
    private Button btnSunday;
    private ImageView ivSunday;
    private RelativeLayout rlSunday;
    Button rate;
    private LinearLayout activity_main;

    private Button btnChooseLn;

    Animation slide_up2;
    Animation slide_up3;
    Animation slide_up4;
    Animation slide_up5;
    Animation slide_up6;
    Animation slide_up7;

    Animation fadeOut;
    Animation fadeIn;

    Animation fadeOutIternal; //        ????????????????????????????????????????????????????????????????????????????????
    Animation fadeInIternal; //        ????????????????????????????????????????????????????????????????????????????????

    LanguagesFragment fragment;
    View flAlpha;
    View flBlur;

    String[] daysEngTexts;
    String[] daysRusTexts;
    String[] daysGeoTexts;
	String[] daysSpaTexts;
    String[] daysChiTexts;
    String[] daysIndTexts;
    Button[] btnDays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        checkAppFirstStart();
    }

    //=========================================================================

    private void checkAppFirstStart() {

        if (LessNoteApplication.getInstce().getSharedBoolean(MyConstants.NOT_FIRST_START) == false) {
            showFragment();
            LessNoteApplication.getInstce().setSharedBoolean(MyConstants.NOT_FIRST_START, true);
        }
    }

    private void showFragment() {
        setCLickabkeButtonsFalse();
        flAlpha.setVisibility(View.VISIBLE);
        flAlpha.startAnimation(fadeInIternal);
        fragment = new LanguagesFragment();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.slide_up_dialog, 0, 0, R.anim.slide_down_dialog)
                .replace(R.id.fLanguages, fragment).commit();


    }

    //=========================================================================

    private void initView() {
        flBlur = findViewById(R.id.flBlur);
        flAlpha = findViewById(R.id.flAlpha);
        btnChooseLn = (Button)findViewById(R.id.btnChooseLn);
        btnMonday = (Button) findViewById(R.id.btnMonday);
        ivMonday = (ImageView) findViewById(R.id.ivMonday);
        rlMonday = (RelativeLayout) findViewById(R.id.rlMonday);
        btnTuesday = (Button) findViewById(R.id.btnTuesday);
        ivTuesday = (ImageView) findViewById(R.id.ivTuesday);
        rlTuesday = (RelativeLayout) findViewById(R.id.rlTuesday);
        btnWednesday = (Button) findViewById(R.id.btnWednesday);
        ivWednesday = (ImageView) findViewById(R.id.ivWednesday);
        rlWednesday = (RelativeLayout) findViewById(R.id.rlWednesday);
        btnThursday = (Button) findViewById(R.id.btnThursday);
        ivThursday = (ImageView) findViewById(R.id.ivThursday);
        rlThursday = (RelativeLayout) findViewById(R.id.rlThursday);
        btnFriday = (Button) findViewById(R.id.btnFriday);
        ivFriday = (ImageView) findViewById(R.id.ivFriday);
        rlFriday = (RelativeLayout) findViewById(R.id.rlFriday);
        btnSaturday = (Button) findViewById(R.id.btnSaturday);
        ivSaturday = (ImageView) findViewById(R.id.ivSaturday);
        rlSaturday = (RelativeLayout) findViewById(R.id.rlSaturday);
        btnSunday = (Button) findViewById(R.id.btnSunday);
        ivSunday = (ImageView) findViewById(R.id.ivSunday);
        rlSunday = (RelativeLayout) findViewById(R.id.rlSunday);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);

//        fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);

        fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        //fadeOut.setStartOffset(200);
        fadeOut.setDuration(1000);

        fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        //========================================================================= blur
        fadeIn.setAnimationListener(this);
        //========================================================================= blur

        fadeOutIternal = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_iternal);  //  ????????????????????????????????????
        fadeOutIternal.setAnimationListener(this);
        fadeInIternal = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_iternal);  //  ????????????????????????????????????

        fillArrays();

        btnMonday.setOnClickListener(this);
        btnTuesday.setOnClickListener(this);
        btnWednesday.setOnClickListener(this);
        btnThursday.setOnClickListener(this);
        btnFriday.setOnClickListener(this);
        btnSaturday.setOnClickListener(this);
        btnSunday.setOnClickListener(this);

        //=========  smiles appareance

        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayOfMonth) {
            case MyConstants.MONDAY:
                ivMonday.setVisibility(View.VISIBLE);
                break;
            case MyConstants.TUESDAY:
                ivTuesday.setVisibility(View.VISIBLE);
                break;
            case MyConstants.WEDNESDAY:
                ivWednesday.setVisibility(View.VISIBLE);
                break;
            case MyConstants.THURSDAY:
                ivThursday.setVisibility(View.VISIBLE);
                break;
            case MyConstants.FRIDAY:
                ivFriday.setVisibility(View.VISIBLE);
                break;
            case MyConstants.SATURDAY:
                ivSaturday.setVisibility(View.VISIBLE);
                break;
            case MyConstants.SUNDAY:
                ivSunday.setVisibility(View.VISIBLE);
                break;
        }

        //=========  smiles appareance

        // ======  languageDays

        String languageCHosen = LessNoteApplication.getInstce().getSharedString(MyConstants.LANGUGE_CHOSEN);
        rate = (Button) findViewById(R.id.bRateUs);

        if (languageCHosen.equals("") || languageCHosen.equals(MyConstants.LAN_GEORGIA)) {
            fillButtonTexts(daysGeoTexts);
            btnChooseLn.setBackgroundResource(R.drawable.geolan);
        } else if (languageCHosen.equals(MyConstants.LAN_ENGLISH)) {
            fillButtonTexts(daysEngTexts);
            btnChooseLn.setBackgroundResource(R.drawable.englan);


        } else if (languageCHosen.equals(MyConstants.LAN_RUSSIAN)) {
            fillButtonTexts(daysRusTexts);
            btnChooseLn.setBackgroundResource(R.drawable.ruslan);


        }
        else if (languageCHosen.equals(MyConstants.LAN_SPANISH)) {
            fillButtonTexts(daysSpaTexts);
            btnChooseLn.setBackgroundResource(R.drawable.spalan);


        }
        else if (languageCHosen.equals(MyConstants.LAN_CHINISE)) {
            fillButtonTexts(daysChiTexts);
            btnChooseLn.setBackgroundResource(R.drawable.chilan);


        }
        else{
            fillButtonTexts(daysIndTexts);
            btnChooseLn.setBackgroundResource(R.drawable.indlan);

        }

        // ======  languageDays
    }


    public void fillArrays() {
        daysEngTexts = new String[7];
        daysEngTexts[0] = "Monday";
        daysEngTexts[1] = "Tuesday";
        daysEngTexts[2] = "Wednesday";
        daysEngTexts[3] = "Thursday";
        daysEngTexts[4] = "Friday";
        daysEngTexts[5] = "Saturday";
        daysEngTexts[6] = "Sunday";
        daysRusTexts = new String[7];
        daysRusTexts[0] = "Понедельник";
        daysRusTexts[1] = "Вторник";
        daysRusTexts[2] = "Среда";
        daysRusTexts[3] = "Четверг";
        daysRusTexts[4] = "Пятница";
        daysRusTexts[5] = "Суббота";
        daysRusTexts[6] = "Воскресенье";
        daysGeoTexts = new String[7];
        daysGeoTexts[0] = "ორშაბათი";
        daysGeoTexts[1] = "სამშაბათი";
        daysGeoTexts[2] = "ოთხშაბათი";
        daysGeoTexts[3] = "ხუთშაბათი";
        daysGeoTexts[4] = "პარასკევი";
        daysGeoTexts[5] = "შაბათი";
        daysGeoTexts[6] = "კვირა";
		 daysSpaTexts = new String[7];
        daysSpaTexts[0] = "Lunes";
        daysSpaTexts[1] = "Martes";
        daysSpaTexts[2] = "Miércoles";
        daysSpaTexts[3] = "Jueves";
        daysSpaTexts[4] = "Viernes";
        daysSpaTexts[5] = "Sábado";
        daysSpaTexts[6] = "Domingo";
        daysChiTexts = new String[7];
        daysChiTexts[0] = "星期一";
        daysChiTexts[1] = "星期二";
        daysChiTexts[2] = "星期三";
        daysChiTexts[3] = "星期四";
        daysChiTexts[4] = "星期五";
        daysChiTexts[5] = "星期六";
        daysChiTexts[6] = "星期日";
        daysIndTexts = new String[7];
        daysIndTexts[0] = "सोमवार";
        daysIndTexts[1] = "मंगलवार";
        daysIndTexts[2] = "बुधवार";
        daysIndTexts[3] = "गुरूवार";
        daysIndTexts[4] = "शुक्रवार";
        daysIndTexts[5] = "शनिवार";
        daysIndTexts[6] = "रविवार";
        btnDays = new Button[7];
        btnDays[0] = btnMonday;
        btnDays[1] = btnTuesday;
        btnDays[2] = btnWednesday;
        btnDays[3] = btnThursday;
        btnDays[4] = btnFriday;
        btnDays[5] = btnSaturday;
        btnDays[6] = btnSunday;
    }
    //=========================================================================

    @Override
    public void onBackPressed() {
        if (flAlpha.getVisibility() == View.VISIBLE) {
            flAlpha.startAnimation(fadeOutIternal);
        }
        super.onBackPressed();
    }


    //=========================================================================

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMonday:
                Intent i = new Intent(MainActivity.this, MondayActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(i, MONDEY_REQUEST);

                break;
            case R.id.btnTuesday:
                slide_up2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up2);
                slide_up2.setAnimationListener(this);

                //========================================================================= blur
                flBlur.setVisibility(View.VISIBLE);
                flBlur.setBackgroundColor(getResources().getColor(R.color.colorTuesdayBlur));
                //========================================================================= blur

                rlSunday.startAnimation(fadeOut);
                rlSaturday.startAnimation(fadeOut);
                rlFriday.startAnimation(fadeOut);
                rlThursday.startAnimation(fadeOut);
                rlWednesday.startAnimation(fadeOut);
                rlMonday.startAnimation(fadeOut);

                rlTuesday.startAnimation(slide_up2);

                break;
            case R.id.btnWednesday:
                slide_up3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up3);
                slide_up3.setAnimationListener(this);

                //========================================================================= blur
                flBlur.setVisibility(View.VISIBLE);
                flBlur.setBackgroundColor(getResources().getColor(R.color.colorWednesdayBlur));
                //========================================================================= blur

                rlSunday.startAnimation(fadeOut);
                rlSaturday.startAnimation(fadeOut);
                rlFriday.startAnimation(fadeOut);
                rlThursday.startAnimation(fadeOut);
                rlTuesday.startAnimation(fadeOut);
                rlMonday.startAnimation(fadeOut);

                rlWednesday.startAnimation(slide_up3);

                break;
            case R.id.btnThursday:
                slide_up4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up4);
                slide_up4.setAnimationListener(this);

                //========================================================================= blur
                flBlur.setVisibility(View.VISIBLE);
                flBlur.setBackgroundColor(getResources().getColor(R.color.colorThursdayBlur));
                //========================================================================= blur

                rlSunday.startAnimation(fadeOut);
                rlSaturday.startAnimation(fadeOut);
                rlFriday.startAnimation(fadeOut);
                rlWednesday.startAnimation(fadeOut);
                rlTuesday.startAnimation(fadeOut);
                rlMonday.startAnimation(fadeOut);

                rlThursday.startAnimation(slide_up4);
                break;
            case R.id.btnFriday:
                slide_up5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up5);
                slide_up5.setAnimationListener(this);

                //========================================================================= blur
                flBlur.setVisibility(View.VISIBLE);
                flBlur.setBackgroundColor(getResources().getColor(R.color.colorFridayBlur));
                //========================================================================= blur

                rlSunday.startAnimation(fadeOut);
                rlSaturday.startAnimation(fadeOut);
                rlThursday.startAnimation(fadeOut);
                rlWednesday.startAnimation(fadeOut);
                rlTuesday.startAnimation(fadeOut);
                rlMonday.startAnimation(fadeOut);

                rlFriday.startAnimation(slide_up5);

                break;
            case R.id.btnSaturday:
                slide_up6 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up6);
                slide_up6.setAnimationListener(this);

                //========================================================================= blur
                flBlur.setVisibility(View.VISIBLE);
                flBlur.setBackgroundColor(getResources().getColor(R.color.colorSaturdaBlury));
                //========================================================================= blur

                rlSunday.startAnimation(fadeOut);
                rlFriday.startAnimation(fadeOut);
                rlThursday.startAnimation(fadeOut);
                rlWednesday.startAnimation(fadeOut);
                rlTuesday.startAnimation(fadeOut);
                rlMonday.startAnimation(fadeOut);

                rlSaturday.startAnimation(slide_up6);

                break;
            case R.id.btnSunday:

                slide_up7 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up7);
                slide_up7.setAnimationListener(this);

                //========================================================================= blur
                flBlur.setVisibility(View.VISIBLE);
                flBlur.setBackgroundColor(getResources().getColor(R.color.colorSaturdaBlury));
                //========================================================================= blur

                rlSaturday.startAnimation(fadeOut);
                rlFriday.startAnimation(fadeOut);
                rlThursday.startAnimation(fadeOut);
                rlWednesday.startAnimation(fadeOut);
                rlTuesday.startAnimation(fadeOut);
                rlMonday.startAnimation(fadeOut);

                rlSunday.startAnimation(slide_up7);

                break;
        }
    }

    //=========================================================================

    //=========================================================================

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       flBlur.startAnimation(fadeOut);

        if (requestCode == SUNDAY_REQUEST) {

            rlSaturday.startAnimation(fadeIn);
            rlFriday.startAnimation(fadeIn);
            rlThursday.startAnimation(fadeIn);
            rlWednesday.startAnimation(fadeIn);
            rlTuesday.startAnimation(fadeIn);
            rlMonday.startAnimation(fadeIn);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down7);
            rlSunday.startAnimation(animation);
        } else if (requestCode == SATURDAY_REQUEST) {
            rlSunday.startAnimation(fadeIn);
            rlFriday.startAnimation(fadeIn);
            rlThursday.startAnimation(fadeIn);
            rlWednesday.startAnimation(fadeIn);
            rlTuesday.startAnimation(fadeIn);
            rlMonday.startAnimation(fadeIn);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down6);
            rlSaturday.startAnimation(animation);
        } else if (requestCode == FRIDAY_REQUEST) {
            rlSunday.startAnimation(fadeIn);
            rlSaturday.startAnimation(fadeIn);
            rlThursday.startAnimation(fadeIn);
            rlWednesday.startAnimation(fadeIn);
            rlTuesday.startAnimation(fadeIn);
            rlMonday.startAnimation(fadeIn);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down5);
            rlFriday.startAnimation(animation);
        } else if (requestCode == THURSDAY_REQUEST) {
            rlSunday.startAnimation(fadeIn);
            rlSaturday.startAnimation(fadeIn);
            rlFriday.startAnimation(fadeIn);
            rlWednesday.startAnimation(fadeIn);
            rlTuesday.startAnimation(fadeIn);
            rlMonday.startAnimation(fadeIn);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down4);
            rlThursday.startAnimation(animation);
        } else if (requestCode == WEDNESDAY_REQUEST) {
            rlSunday.startAnimation(fadeIn);
            rlSaturday.startAnimation(fadeIn);
            rlFriday.startAnimation(fadeIn);
            rlThursday.startAnimation(fadeIn);
            rlTuesday.startAnimation(fadeIn);
            rlMonday.startAnimation(fadeIn);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down3);
            rlWednesday.startAnimation(animation);
        } else if (requestCode == TUESTDAY_REQUEST) {
            rlSunday.startAnimation(fadeIn);
            rlSaturday.startAnimation(fadeIn);
            rlFriday.startAnimation(fadeIn);
            rlThursday.startAnimation(fadeIn);
            rlWednesday.startAnimation(fadeIn);
            rlMonday.startAnimation(fadeIn);

            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down2);
            rlTuesday.startAnimation(animation);
        } else {

        }

    }

    //=========================================================================

    //=========================================================================

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        // formatt need
        if (animation.equals(fadeOutIternal)) {
            flAlpha.setVisibility(View.GONE);
            setCLickabkeButtonstrue();
        }

        //=========================================================================blur
        if (animation.equals(fadeIn)) {
            flBlur.setVisibility(View.GONE);
        }
        //=========================================================================blur

        if (animation.equals(slide_up7)) {
            Intent i = new Intent(MainActivity.this, SundayActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(i, SUNDAY_REQUEST);
        } else if (animation.equals(slide_up6)) {
            Intent i = new Intent(MainActivity.this, SaturdayActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(i, SATURDAY_REQUEST);
        } else if (animation.equals(slide_up5)) {
            Intent i = new Intent(MainActivity.this, FridayActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(i, FRIDAY_REQUEST);
        } else if (animation.equals(slide_up4)) {
            Intent i = new Intent(MainActivity.this, ThursdayActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(i, THURSDAY_REQUEST);
        } else if (animation.equals(slide_up3)) {
            Intent i = new Intent(MainActivity.this, WednesdayActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(i, WEDNESDAY_REQUEST);
        } else if (animation.equals(slide_up2)) {
            Intent i = new Intent(MainActivity.this, TuesdayActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(i, TUESTDAY_REQUEST);
        }
// else {
//            Intent i = new Intent(MainActivity.this, TuesdatActivity.class);
//            startActivityForResult(i, MONDEY_REQUEST);
//        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    //=========================================================================

    //=========================================================================

    public  void fillButtonTexts(String [] days){
        for(int i =0; i< days.length; i ++){
            btnDays[i].setText(days[i]);
        }
    }

    //=========================================================================

    public void chooseLanguage(View view) {
        showFragment();
    }

    public void languageClicked(View view) {
        rate = (Button) findViewById(R.id.bRateUs);
        switch (view.getId()) {
            case R.id.btnGeo:
                fillButtonTexts(daysGeoTexts);
                btnChooseLn.setBackgroundResource(R.drawable.geolan);
                rate.setText("შეგვაფასეთ");
                fragment.languageClicked(MyConstants.LAN_GEORGIA);
                break;
            case R.id.btnRus:
                fillButtonTexts(daysRusTexts);
                btnChooseLn.setBackgroundResource(R.drawable.ruslan);
                rate.setText("оцените нас");
                fragment.languageClicked(MyConstants.LAN_RUSSIAN);
                break;
            case R.id.btnEng:
                fillButtonTexts(daysEngTexts);
                btnChooseLn.setBackgroundResource(R.drawable.englan);
                rate.setText("Rate Us");
                fragment.languageClicked(MyConstants.LAN_ENGLISH);
                break;
            case R.id.btnSpa:
                fillButtonTexts(daysSpaTexts);
                btnChooseLn.setBackgroundResource(R.drawable.spalan);
                rate.setText("Recordar Más Tarde");
                fragment.languageClicked(MyConstants.LAN_SPANISH);

                break;
            case R.id.btnChi:
                fillButtonTexts(daysChiTexts);
                btnChooseLn.setBackgroundResource(R.drawable.chilan);
                rate.setText("以後提醒");
                fragment.languageClicked(MyConstants.LAN_CHINISE);

                break;
            case R.id.btnInD:
                fillButtonTexts(daysIndTexts);
                btnChooseLn.setBackgroundResource(R.drawable.indlan);
                rate.setText("बाद में याद दिलाना");
                fragment.languageClicked(MyConstants.LAN_INDIAN);
               break;
            case R.id.bRateUs:
                Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                }
                break;
        }
    }

    //=========================================================================

    public void setCLickabkeButtonsFalse(){
        for (int i = 0; i < btnDays.length; i++) {
            btnDays[i].setClickable(false);
        }
    };
    public void setCLickabkeButtonstrue(){
        for (int i = 0; i < btnDays.length; i++) {
            btnDays[i].setClickable(true);
        }
    };

}
