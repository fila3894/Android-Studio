package com.example.test1;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Profile_cn extends AppCompatActivity
{

    TextView t1,t2,t3,t4,t5;
    EditText e1,e2,e3;
    CheckBox c1,c2,c3,c4,c5;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_cn);

        t1=(TextView)findViewById(R.id.name);
        t2=findViewById(R.id.name2);
        t3=findViewById(R.id.name3);
        t4=findViewById(R.id.name4);
        t5=findViewById(R.id.name5);
    }

    public void bbb(View V) {
        View dlgview = View.inflate(this, R.layout.profile, null);

        e1 = (EditText) dlgview.findViewById(R.id.editText3);
        e2 = (EditText) dlgview.findViewById(R.id.editText);
        e3 = dlgview.findViewById(R.id.editText2);
        c1 = (CheckBox) dlgview.findViewById(R.id.checkBox);
        c2 = dlgview.findViewById(R.id.checkBox2);
        c3 = dlgview.findViewById(R.id.checkBox3);
        c4 = dlgview.findViewById(R.id.checkBox4);
        c5 = dlgview.findViewById(R.id.checkBox5);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        dlg.setView(dlgview);

        dlg.setTitle("사용자 정보 입력");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = e1.getText().toString();
                String add = e2.getText().toString();
                String number = e3.getText().toString();
                if (c1.isChecked()) {
                    t4.setText("총 사용량 요금 계산 : 주택용 고압");
                } else {
                    t4.setText("총 사용량 요금 계산 : 주택용 저압");
                }
                if (c3.isChecked()) {
                    t5.setText("대가족 요금 : 해당 사항 없음");
                }
                if (c4.isChecked()) {
                    t5.setText("대가족 요금 : 3자녀 이상 가구");
                }
                if (c5.isChecked()) {
                    t5.setText("대가족 요금 : 5인 이상 가구");
                }
                t1.setText("이름 : " + name);
                t2.setText("주소 : " + add);
                t3.setText("휴대 전화 : " + number);


            }
        });

        dlg.setPositiveButton("취소", null);
        dlg.show();



    }

}
