package fpoly.edu.vn.qltcda1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.model.RSS;

public class RSSAdapter  extends ArrayAdapter<RSS>{
    public RSSAdapter(@NonNull Context context, int resource, @NonNull List<RSS> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.item_listview, null);

        }
        RSS p=getItem(position);

        if(p!=null){
            TextView textView= view.findViewById(R.id.title_item);
            textView.setText(p.getTitle());

        }
        return view;
    }

}
