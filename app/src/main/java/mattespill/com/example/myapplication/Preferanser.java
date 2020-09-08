package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Locale;

public class Preferanser extends PreferenceActivity {
    RadioGroup radioGroup;
    RadioButton valgtRadio;
    Integer valgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
        setContentView(R.layout.activity_preferanser);

        //RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioOppgaver);
        //valgt = radioGroup.getCheckedRadioButtonId();
    }

    public static class PrefsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.layout.activity_preferanser);
        }
    }
    

    public void radioValgt(View v){
        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra("valgtRadio", valgt);
        Toast.makeText(Preferanser.this, "Radioknapp er valgt", Toast.LENGTH_SHORT).show();
        //startActivity(intent);
    }
    /*
    public void settLand(String landskode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration cf = res.getConfiguration();
        cf.setLocale(new Locale(landskode));
        res.updateConfiguration(cf, dm);
    }
    public void tysk(View v){
        settLand("de");
        recreate();
    }
    public void norsk(View v){
        settLand("no");
        recreate();
    }*/
}