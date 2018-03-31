package vault.emacs.com.securevault;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.gujun.android.taggroup.TagGroup;

/**
 * Created by ganes on 20-05-2017.
 */

public class VaultItemArrayAdapter extends ArrayAdapter<VaultItemGroup> {

    public VaultItemArrayAdapter(@NonNull Context context, int resource, @NonNull List<VaultItemGroup> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.vault_group_item,null);
        ViewHolder holder = new ViewHolder(view);
        VaultItemGroup item = getItem(position);
        holder.updateView(item);
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.item_title)
        TextView title;

        @BindView(R.id.item_subtitle)
        TextView subTitle;

        @BindView(R.id.content_count)
        TextView contentCount;

        @BindView(R.id.mark_as_favorite)
        ImageView markAsFavorite;

        @BindView(R.id.tag_group)
        TagGroup tagGroup;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void updateView(VaultItemGroup item) {
            title.setText(item.getTitle());
            subTitle.setText(item.getType());
            contentCount.setText(item.getVaultItems().size());
            int resource = item.isFavorite()?R.drawable.ic_marked_favorite_black:R.drawable.ic_mark_as_favorite_black;
            markAsFavorite.setImageResource(resource);
            tagGroup.setTags(item.getAllTags());
        }
    }

}
