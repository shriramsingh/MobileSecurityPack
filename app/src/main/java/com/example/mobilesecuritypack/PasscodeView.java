package com.example.mobilesecuritypack;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.input.InputManager;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilesecuritypack.databinding.ActivityPasscodeViewBinding;

public class PasscodeView extends AppCompatActivity  implements View.OnKeyListener {
    ActivityPasscodeViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode_view);
        binding =ActivityPasscodeViewBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        binding.text1.setOnKeyListener(this);
        binding.text2.setOnKeyListener(this);
        binding.text3.setOnKeyListener(this);
        binding.text4.setOnKeyListener(this);
        binding.text5.setOnKeyListener(this);

    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (binding.text1==v && binding.text1.getText().length()==1 && !(binding.text1.getText().equals(""))){
            Toast.makeText(this, String.valueOf(keyCode), Toast.LENGTH_SHORT).show();
            binding.text2.requestFocus();
        }
        else if (binding.text2==v && binding.text2.getText().length()==1 && !(binding.text2.getText().equals(""))){
            binding.text3.requestFocus();
        }
        
        else if (binding.text3==v && binding.text3.getText().length()==1 && !(binding.text3.getText().equals(""))){
            binding.text4.requestFocus();
        }
        else if (binding.text4==v && binding.text4.getText().length()==1 && !(binding.text4.getText().equals(""))){
            binding.text5.requestFocus();

        }
        else if (binding.text5==v && binding.text5.getText().length()==1 && !(binding.text5.getText().equals(""))){

            Toast.makeText(this, "Password Entered", Toast.LENGTH_SHORT).show();

        }

        if (keyCode==67){
            binding.text5.setFocusable(true);
            Toast.makeText(this, "Delete key pressed", Toast.LENGTH_SHORT).show();
            if (v==binding.text5){

                binding.text5.setText("");
                binding.text4.requestFocus();
            }
            else if (v==binding.text4){

                binding.text4.setText("");
                binding.text3.requestFocus();
            }
            else if (v==binding.text3){

                binding.text3.setText("");
                binding.text2.requestFocus();
            }
            else if (v==binding.text2){
               ;
                binding.text1.setText("");
                binding.text1.requestFocus();
            }
            else if (v==binding.text1){

                binding.text1.setText("");

            }

        }
       
        return false;
    }
}