package com.example.guruapp

import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import android.widget.ImageView

public class MainActivity extends AppCompatActivity {

    // 전역변수
    ToggleButton toggleButton;
    Switch aSwitch;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 과 연결
        toggle = findViewById(R.id.toggleButton2);
        imageView = findViewById(R.id.image_view);

        // ToggleButton 의 이벤트
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //버튼 수대로 복사하여 활성화
                    button01.setEnabled(true);
                    button01.setVisibility(View:VISIBLE);
                } else {
                    button01.setEnabled(false);
                    button01.setVisibility(View:GONE);
                }

    }

    // 토글 버튼의 클릭 이벤트에 변화되는 이미지를 셋팅하는 메소드
    void imageSetting(boolean isCheck) {
        if (isCheck) {
            imageView.setImageResource(R.drawable.on);
        } else {
            imageView.setImageResource(R.drawable.off);
        }
    }
        }

        //역의 버튼 클릭시 페이지 이동- 버튼 수만큼 복제하여 사용가능합니다
        Button moveButton=findViewById(R.id.button01); /*버튼 뒤 숫자 바꿔서 여러개 생성*/
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                //여기서 메인액티비티2는 역 상세정보 페이지입니다.
()                startActivity(intent);
            }
        });

}
