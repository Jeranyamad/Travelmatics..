package abc.com.travelmatics;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static abc.com.travelmatics.R.layout.activity_insert;

public class InsertActivity extends Activity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    EditText txtTitle;
    EditText txtDescription;
    EditText txtPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_insert);
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
                Toast.makeText(context this, text"Deal saved", Toast.LENGTH_LONG).show()
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
            TravelDeal deal = new TravelDeal(title,description,price,"");
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


}
