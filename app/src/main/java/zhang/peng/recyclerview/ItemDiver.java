package zhang.peng.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhangpeng on 2016/3/12.
 * 为RecyclerView创建分割线
 */
public class ItemDiver extends RecyclerView.ItemDecoration {
    private Drawable drawable;
    private Context context;

    public ItemDiver(Context context,int id){
        //在这里我们传入作为Divider的Drawable对象
        this.drawable=context.getResources().getDrawable(id);
        this.context=context;
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //确定分割线左边位置
        final  int left=parent.getPaddingLeft();
        //确定分割线右边位置
        final int right=parent.getWidth()-parent.getPaddingRight();
        int childAcount=parent.getChildCount();
        for(int i=0;i<childAcount;i++){
            final View child=parent.getChildAt(i);
            final RecyclerView.LayoutParams layoutParams= (RecyclerView.LayoutParams) child.getLayoutParams();
            //确定分割线顶部位置，根据子view最底部位置+ViewGroup的margin距离确定分割线最高位置
            final int top=child.getBottom()+layoutParams.bottomMargin;
            //确定分割线底部位置（根据顶部位置+draewble高度确定分割线底部位置）
            final int bottom=top+drawable.getIntrinsicHeight();
            drawable.setBounds(left,top,right,bottom);
            drawable.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0,0,0,drawable.getIntrinsicHeight());
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
