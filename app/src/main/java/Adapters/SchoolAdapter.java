package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sis2225.shoolmanagementsystemfront.R;
import com.sis2225.shoolmanagementsystemfront.SchoolListActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import API.SchoolData;
import API.SchoolRepository;

public class SchoolAdapter extends BaseAdapter {
    private List<SchoolData> mDataList;
    private Context mContext;
    private LayoutInflater mInflater;

    public SchoolAdapter(Context context, List<SchoolData> dataList) {
        mContext = context;
        mDataList = dataList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.list_item_school, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView addressTextView = view.findViewById(R.id.addressTextView);
        TextView ratingTextView = view.findViewById(R.id.ratingTextView);
        TextView reviewTextView = view.findViewById(R.id.reviewTextView);

        SchoolData data = mDataList.get(position);

        Picasso.get().load(SchoolRepository.BASE_URL +"/api/images/" + data.getImguri()).into(imageView);
        titleTextView.setText(data.getName());
        addressTextView.setText(data.getAddress());
        ratingTextView.setText("Рейтинг: " + data.getRating());
        reviewTextView.setText("Последний отзыв: " + data.getImguri());

        return view;
    }
}

