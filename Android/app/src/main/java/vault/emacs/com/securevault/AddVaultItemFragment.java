package vault.emacs.com.securevault;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import static vault.emacs.com.securevault.Utils.isNotNull;

/**
 * Created by ganes on 21-05-2017.
 */

public class AddVaultItemFragment extends Fragment {

    private static final String TAG = "AddVaultItemFragment";
    private ViewDataBinding binding;

    public AddVaultItemFragment() {
        super();

    }

/*    @BindView(R.id.vault_items_container)
    LinearLayout vaultItemContainer;

    @BindView(R.id.vaultItemTitle_et)
    EditText vaultItemTitle;*/

    View.OnClickListener generatePhraseClickListener  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.add_valult_frame, new GeneratePhraseFragment()).commit();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new, container, false);



        View view = binding.getRoot();
        
        Log.i(TAG,"Fragment create called");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
   }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    void onAddVaultItem() {
        Log.i(TAG,"add vault item called");
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );



        //View vaultItem = inflater.inflate(R.layout.vault_item_individual,vaultItemContainer);
        //VaultItemHolder holder = new VaultItemHolder(vaultItem);
        //vaultItem.setTag(holder);
    }

    class VaultItemHolder {
      /*  @BindView(R.id.vault_item_type_et)
        EditText vaultItemType;

        @BindView(R.id.vault_item_value_et)
        EditText vaultItemValue;

        @BindView(R.id.generate_phrase_btn)
        ImageButton generatePhrase;*/

        VaultItemHolder(View view) {
/*
            ButterKnife.bind(this, view);
            if(generatePhrase!=null) {
                generatePhrase.setOnClickListener(generatePhraseClickListener);
            } else {
                Log.e(TAG,"generatePhrase button null, couldnt set listener");
            }
*/

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add: onAddVaultItem();
                break;
            case R.id.action_done: doneCreateVaultItem();
                break;
            case android.R.id.home: onCancelVaultItemCreate();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


   void onCancelVaultItemCreate() {
        removeAllVaultItemViews();
    }

    void removeAllVaultItemViews() {
       /* if(isNotNull(vaultItemContainer)) {
            *//* remove all children, so that fragment apperars fresh newxt time when launched *//*
            vaultItemContainer.removeAllViews();
        }*/
        getActivity().onBackPressed();
    }




    void doneCreateVaultItem() {
        /* read all item content */
       removeAllVaultItemViews();
        getActivity().onBackPressed();
    }

}
