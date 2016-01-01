package xyz.fanqi.preferenceactivity;

import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MyPreferenceActivity extends PreferenceActivity {
    PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypreference);
        preferenceManager = getPreferenceManager();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceManager.findPreference("checkbox");
        Toast.makeText(getApplicationContext(),"是否开启："+checkBoxPreference.isChecked(),Toast.LENGTH_SHORT).show();
        ListPreference listPreference = (ListPreference) preferenceManager.findPreference("list");
        Toast.makeText(getApplicationContext(),listPreference.getEntry()+"的开发环境是："+listPreference.getValue(),Toast.LENGTH_SHORT).show();
        EditTextPreference editTextPreference = (EditTextPreference) preferenceManager.findPreference("text");
        Toast.makeText(getApplicationContext(),"您输入的是："+editTextPreference.getText(),Toast.LENGTH_SHORT).show();

    }
}
