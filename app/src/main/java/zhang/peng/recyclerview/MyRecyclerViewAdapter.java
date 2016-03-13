package zhang.peng.recyclerview;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhangpeng on 2016/3/12.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewHolder> {
    private Context context;
    private List<ImageTextModel> imageTextModelsodelList;

    public  MyRecyclerViewAdapter(Context context, List<ImageTextModel> imageTextModelsodels){
        this.context=context;
        this.imageTextModelsodelList=imageTextModelsodels;
    }


    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false));

    }

    @Override
    public int getItemCount() {
        return imageTextModelsodelList==null ? 0 : imageTextModelsodelList.size();
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        holder.textView.setText(imageTextModelsodelList.get(position).getString());
        holder.imageView.setImageResource(imageTextModelsodelList.get(position).getId());
        new OnItemClickListener() {
            @Override
            public void onClick(View parent, int position) {

            }
        };
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class  MyRecyclerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private View view;
       public MyRecyclerViewHolder(View itemView) {
           super(itemView);
           this.view=itemView;
           imageView= (ImageView) view.findViewById(R.id.iv);
           textView= (TextView) view.findViewById(R.id.tv);
       }

   }
    /**
     * 创建点击事件接口
     */
    public interface OnItemClickListener{
        public void onClick(View parent,int position);
    }
    /**
     * 创建长按点击事件
     */
    public interface OnItemLongClickListener{
        public boolean onLongClick(View parent,int position);
    }
}
