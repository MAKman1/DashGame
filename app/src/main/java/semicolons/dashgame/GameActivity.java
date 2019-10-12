package semicolons.dashgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import semicolons.dashgame.backend.ObstacleContainer;

public class GameActivity extends AppCompatActivity {

    //RecyclerView mainView;
    //Adapter adapter;
    RelativeLayout mainView;

    //ObstacleContainer obstacles;
    ArrayList<ImageView> obstacleImage;
    int currentScore;
    int screenHeight;
    int screenWidth;
    int currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        mainView = findViewById( R.id.mainView);

        currentScore = 0;
        obstacleImage = new ArrayList<>();
        currentId = 0;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = (int) (Math.random() * 4);
                for( int i = 0; i < count; i++){
                    int padding = 50 + (i * ((int) Math.random() * (screenWidth/ 4))) + (screenWidth / count) * i;

                    int dimen = (int) (Math.random() * (screenWidth / (2 * count)) + 1);
                    if( dimen > screenWidth / 12){
                        ImageView imgView = new ImageView(GameActivity.this);
                        obstacleImage.add( imgView);
                        imgView.setId( currentId);
                        currentId++;
                        imgView.setImageDrawable( ContextCompat.getDrawable( GameActivity.this, R.drawable.island));
                        imgView.setRotation( (float) Math.random() * 360);
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(dimen, dimen);
                        params.leftMargin = padding;
                        mainView.addView( imgView, params);
                    }
                    else
                        i--;
                }

                handler.postDelayed(this, 1000);
            }
        }, 1000);


        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                for( ImageView temp: obstacleImage){
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) temp.getLayoutParams();
                    int topMargins = params.topMargin;
                    topMargins = topMargins + (screenHeight / 100);
                    params.topMargin = topMargins;
                }
                mainView.invalidate();
                mainView.requestLayout();

                handler2.postDelayed(this, 50);
            }
        }, 50);

    }














        /*
        obstacles = new ObstacleContainer();
        mainView = findViewById( R.id.mainView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager( GameActivity.this) {


            @Override
            public boolean canScrollVertically() {
                return false;
            }
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(GameActivity.this) {

                    private static final float SPEED = 10f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }

                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        mainView.setLayoutManager( layoutManager);
        layoutManager.scrollToPositionWithOffset( 1, 0);
        adapter = new Adapter( GameActivity.this);
        mainView.setAdapter( adapter);
        adapter.notifyDataSetChanged();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                obstacles.addObstacle( currentScore);
                adapter.notifyItemInserted( 0);
                mainView.scrollToPosition( 0);
                //mainView.smoothScrollToPosition( 1);
                adapter.notifyItemRemoved( 19);

                handler.postDelayed(this, 200);
            }
        }, 200);
        */

    /*
    private class Adapter extends RecyclerView.Adapter<CategoryViewHolder> {
        Context c;

        public Adapter(Context c) {
            this.c = c;
        }

        @Override
        public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(c).inflate(R.layout.single_obstacle_level, parent, false);
            return new CategoryViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
            final int index = position;
            holder.setColor( index);
            holder.setText( position);
            /*
            if( position < data.getData().size() && data != null){
                holder.setText( this.data.getData().get( position).getName() + " : " + this.data.getData().get( position).getNumber());
            }
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( data.getData().get( position).isSelected()){
                        data.getData().get( position).setSelected( false);
                        holder.setSelected( false);
                    }
                    else{
                        data.getData().get( position).setSelected( true);
                        holder.setSelected( true);
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
           return obstacles.getSize();
        }
    }

    //-
    private class CategoryViewHolder extends RecyclerView.ViewHolder {

        View mView;
        LinearLayout mainBack;


        public CategoryViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mainBack = mView.findViewById( R.id.mainBack);
        }

        public void setColor( int index){
            /*
            if( obstacles.getData().get( index).isObstacle()){
                mainBack.setBackgroundColor( Color.RED);
            }
            else
                mainBack.setBackgroundColor( Color.GREEN);

        }

        public void setText( int num){
            /*
            TextView text = mView.findViewById( R.id.test);
            text.setText("" + num);

        }


    }
    */

}
