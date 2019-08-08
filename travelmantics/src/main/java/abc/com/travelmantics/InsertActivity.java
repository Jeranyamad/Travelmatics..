package abc.com.travelmatics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import abc.com.travelmatics.R;

public class InsertActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    EditText txtTitle;
    EditText txtDescription;
    EditText txtPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mFirebaseDatabase =FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("traveldeals");
        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        txtPrice = (EditText) findViewById(R.id.txtPrice);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_menu:
                saveDeal();
                android.widget.Toast.makeText(context this, text"Deal saved", Toast.LENGTH_LONG).show();
                clean();
                return true;
            default:
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }
    private void saveDeal(){
            String title = txtTitle.getText().toString();
            String description = txtDescription.getText().toString();
            String price = txtPrice.getText().toString();
            TravelDeal deal = new TravelDeal(title,description,price.imageUrl"");
            mDatabaseReference.push().setValue(deal);
        }
        private void clean(){
            txtTitle.setText("");
            txtPrice.setText("");
            txtDescription.setText("");
            txtTitle.requestFocus();

        }
    }
}
