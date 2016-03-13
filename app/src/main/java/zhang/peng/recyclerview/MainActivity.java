package zhang.peng.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageTextModel> imageTextModels;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.rv_content);
        imageTextModels=new ArrayList<>();
        initData();
        MyRecyclerViewAdapter myRecyclerViewAdapter=new MyRecyclerViewAdapter(MainActivity.this,imageTextModels);
        //设置布局方式，否则不显示内容
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.addItemDecoration(new ItemDiver(this,R.drawable.bg_diver));
    }

    public void initData(){
        String [] texts=new String [9];
        int [] ids={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7};
        for(int i=0;i<7;i++){
            texts[i]="HelloWord"+i;
            ImageTextModel imageTextModel=new ImageTextModel();
            imageTextModel.setId(ids[i]);
            imageTextModel.setString(texts[i]);
            imageTextModels.add(imageTextModel);
        }
    }

}
