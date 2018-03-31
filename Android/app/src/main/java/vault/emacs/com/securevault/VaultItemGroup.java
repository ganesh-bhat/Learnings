package vault.emacs.com.securevault;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ganes on 20-05-2017.
 */

public class VaultItemGroup {



    public static interface VaultItem {
        String getId();
        String getType();
        Object getValue();
    }

    public static class StringVaultItem implements VaultItem {
        private String id;
        private String type;
        private String value;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public Object getValue() {
            return value;
        }
    }

    public static class ImageVaultItem implements VaultItem {
        private String id;
        private String type;
        private Image imageData;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public Object getValue() {
            return imageData;
        }
    }

    private String id;
    private String title;
    private String type;
    private boolean favorite;
    private List<String> tags;

    private List<VaultItem> vaultItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<VaultItem> getVaultItems() {
        return vaultItems;
    }

    public void setVaultItems(List<VaultItem> vaultItems) {
        this.vaultItems = vaultItems;
        if(tags!=null) {
            tags.clear();//reset tags for recomputation
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }


    public List<String> getAllTags() {
        /* caching the tags */
        if(this.tags==null || this.tags.isEmpty())  {
            List<String> tags = new ArrayList<>();
            if(vaultItems !=null && !vaultItems.isEmpty()) {
                for(VaultItem vaultItem:vaultItems) {
                    String itemType = vaultItem.getType();
                    tags.add(itemType);
                }
            }
            this.tags = tags;
        }
        return tags;
    }
}
