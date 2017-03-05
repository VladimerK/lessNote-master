package ge.idevelopers.lessnote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ge.idevelopers.lessnote.R;
import ge.idevelopers.lessnote.application.LessNoteApplication;
import ge.idevelopers.lessnote.helpers.MyConstants;


public class LanguagesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


         View view = inflater.inflate(R.layout.fragment_languages, container, false);
        String languageCHosen = LessNoteApplication.getInstce().getSharedString(MyConstants.LANGUGE_CHOSEN);
        Button rate = (Button) view.findViewById(R.id.bRateUs);
        if (languageCHosen.equals("") || languageCHosen.equals(MyConstants.LAN_GEORGIA)) {
            rate.setText("შეგვაფასეთ");

        } else if (languageCHosen.equals(MyConstants.LAN_ENGLISH)) {
            rate.setText("Rate Us");

        } else if (languageCHosen.equals(MyConstants.LAN_RUSSIAN)) {
            rate.setText("оцените нас");
        }
        else if (languageCHosen.equals(MyConstants.LAN_SPANISH)) {
            rate.setText("Recordar Más Tarde");
        }
        else if (languageCHosen.equals(MyConstants.LAN_CHINISE)) {
            rate.setText("以後提醒");
        }
        else{
            rate.setText("बाद में याद दिलाना");
        }

        return view;
    }

    public void languageClicked(String language){
        LessNoteApplication.getInstce().setSharedString(MyConstants.LANGUGE_CHOSEN, language);
        getActivity().onBackPressed();
    }


}
