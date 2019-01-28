package eu.example.aida.movieslistclean.app.adapterClick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.movieslistclean.R;

public class ClickAdapter extends AppCompatActivity{

    @BindView(R.id.img_load)
    ImageView img;

    @BindView(R.id.txt)
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_adapter);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",1);
        String poster=intent.getStringExtra("poster");

        Picasso picasso=new Picasso.Builder(this).build();

        txt.setText(String.valueOf(id));
        picasso.load(poster).into(img);

    }

}
