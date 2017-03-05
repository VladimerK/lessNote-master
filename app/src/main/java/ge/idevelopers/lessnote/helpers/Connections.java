package ge.idevelopers.lessnote.helpers;

import android.widget.EditText;
import android.widget.TextView;

import ge.idevelopers.lessnote.application.LessNoteApplication;

/**
 * Created by Gio on 10/18/2016.
 */

public class Connections {

    public static void setTvTime(TextView textView, int hours, int minutes) {
        if (hours < 12) {
            if (minutes < 10) {
                textView.setText(Integer.toString(hours) + ":" + "0" + Integer.toString(minutes) + " AM");

            } else {
                textView.setText(Integer.toString(hours) + ":" + Integer.toString(minutes) + " AM");
            }
        } else {
            if (minutes < 10) {
                textView.setText(Integer.toString(hours) + ":" + "0" + Integer.toString(minutes) + " AM");

            } else {
                textView.setText(Integer.toString(hours - 12) + ":" + Integer.toString(minutes) + " PM");
            }
        }
    }

    public static void fillLessonHints(EditText [] editTexts){
        String hint ;
        String languageCHosen = LessNoteApplication.getInstce().getSharedString(MyConstants.LANGUGE_CHOSEN);

        if (languageCHosen.equals("") || languageCHosen.equals(MyConstants.LAN_GEORGIA)) {
            hint = MyConstants.GEO_LESS_HINT;
        } else if (languageCHosen.equals(MyConstants.LAN_ENGLISH)) {
            hint = MyConstants.ENG_LESS_HINT;
        } else if (languageCHosen.equals(MyConstants.LAN_RUSSIAN)) {
            hint = MyConstants.RUS_LESS_HINT;
        }
        else if (languageCHosen.equals(MyConstants.LAN_CHINISE)) {
            hint = MyConstants.CHI_LESS_HINT;
        }
        else if (languageCHosen.equals(MyConstants.LAN_INDIAN)) {
            hint = MyConstants.IND_LESS_HINT;
        }
        else {
            hint = MyConstants.SPA_LESS_HINT;
        }

        for (int i = 0; i < editTexts.length ; i ++) {
            editTexts[i].setHint(hint);
        }
    }

}
