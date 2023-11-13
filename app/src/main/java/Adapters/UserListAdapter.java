package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sis2225.shoolmanagementsystemfront.R;

import java.util.ArrayList;
import java.util.List;

import API.UserData;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<UserData> userDataList;
    private int schoolId;

    public UserListAdapter(Context context, List<UserData> userDataList, int schoolID) {
        this.context = context;
        this.schoolId = schoolID;

        // Filter the list to include only users belonging to the specified school
        this.userDataList = filterUsers(userDataList, schoolID);
    }

    @Override
    public int getCount() {
        return userDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return userDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_users, null);

            viewHolder = new ViewHolder();
            viewHolder.userName = convertView.findViewById(R.id.userNameTextView);
            viewHolder.roleTextview = convertView.findViewById(R.id.roleTextview);
            viewHolder.descriptionTextView = convertView.findViewById(R.id.descriptionTextview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        UserData userData = userDataList.get(position);

        viewHolder.descriptionTextView.setText(String.valueOf(userData.getDescription()));
        viewHolder.roleTextview.setText(String.valueOf(userData.getRole()));
        viewHolder.userName.setText(String.valueOf(userData.getName() + " " + userData.getLastname()));

        return convertView;
    }

    // Add a method to filter users based on the school ID
    private List<UserData> filterUsers(List<UserData> userList, int schoolID) {
        List<UserData> filteredList = new ArrayList<>();
        for (UserData user : userList) {
            if (user.getIdSchool() != 0 && user.getIdSchool() == schoolID) {
                filteredList.add(user);
            }
        }
        return filteredList;
    }

    static class ViewHolder {
        TextView userName;
        TextView roleTextview;
        TextView descriptionTextView;
    }
}
