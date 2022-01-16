package com.example.videomemo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHoler> {

    private ArrayList<MemoData> myDataList =null;

    public MyAdapter(ArrayList<MemoData> myDataList) {
        this.myDataList = myDataList;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_memodata, parent, false);
        MyViewHoler viewHolder = new MyViewHoler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler viewHoler, int position) {
        viewHoler.videoView.setMediaController(null);
        viewHoler.videoView.requestFocus();
        viewHoler.videoView.setVideoURI(Uri.parse(myDataList.get(position).getVideoUrl()));

        viewHoler.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                viewHoler.videoView.start();
            }
        });
        viewHoler.title.setText(myDataList.get(position).getTitle());
        viewHoler.content.setText(myDataList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView title;
        TextView content;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.video);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }

    }
}
