package edu.rosehulman.schmitml.namebaseadpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by schmitml on 12/17/15.
 */
public class NameAdapter extends BaseAdapter {
    private Context mContext;
    final ArrayList<String> mNames = new ArrayList<>();
    private Random mRandom = new Random();

    public NameAdapter(Context context){
        mContext = context;
        for(int i = 0; i < 5 ; i++){
            mNames.add(getRandomName());
        }
    }

    private String getRandomName() {
        String[] names = new String[]{
                "Hannah", "Emily", "Sarah", "Madison", "Brianna",
                "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
                "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
                "Joseph", "Zachary", "Joshua", "Andrew", "William"
        };
        return names[mRandom.nextInt(names.length)];
    }

    /**
     * Adds a random name at the first position and updates the view
     */
    public void add(){
        mNames.add(0,getRandomName());
        notifyDataSetChanged();
    }

    /**
     * Removes the name at a give position and updates the view
     * @param pos
     */
    public void remove(int pos){
        mNames.remove(pos);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mNames.size();
    }

    // Don't Care
    @Override
    public Object getItem(int i) {
        return null;
    }

    // Don't Care
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //Recycle an existing view
        if(convertView == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.name_view, parent, false);
        }else{
            view = convertView;
        }

        TextView nameTextView = (TextView) view.findViewById(R.id.name_view);
        TextView positionTextView = (TextView) view.findViewById(R.id.position_view);
        String name = mNames.get(position);

        nameTextView.setText(name);
        positionTextView.setText("I'm #" + (position+1));
        return view;
    }
}
