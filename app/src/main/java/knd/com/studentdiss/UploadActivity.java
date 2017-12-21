package knd.com.studentdiss;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editBody;
    Button submit;
    DatabaseReference rootRef,demoRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        editTitle = (EditText) findViewById(R.id.editposttitle);
        editBody = (EditText) findViewById(R.id.editbody);

        submit = (Button) findViewById(R.id.btnsubmitpost);
        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("demo");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editTitle.getText().toString();
                String value2 = editBody.getText().toString();
                //push creates a unique id in database
                demoRef.push().setValue(value,value2);
            }
        });
    }

}
