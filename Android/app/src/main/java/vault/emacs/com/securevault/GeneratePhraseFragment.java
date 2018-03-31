package vault.emacs.com.securevault;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vault.emacs.com.securevault.generator.CustomPassphraseGenerator;

/**
 * Created by ganes on 21-05-2017.
 */

public class GeneratePhraseFragment extends Fragment {
    private Unbinder unbinder;
    private String mPassPhrase;

    @BindView(R.id.genarated_pass_phrase_et)
    EditText generatedPassPhrase;

    @BindView(R.id.password_length_seekbar)



    @OnClick(R.id.generate_new_passphrase_btn)
    void generatePassPhrase(View btnView) {

    }



    public GeneratePhraseFragment(){
        super();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_generator,container,false);
        unbinder = ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().invalidateOptionsMenu();
        mPassPhrase = CustomPassphraseGenerator.generatePassword(null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if(menuItem.getItemId() != R.id.action_password_generation_done) {
                menuItem.setVisible(false);
            }
        }
        inflater.inflate(R.menu.menu_password_generator, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_password_generation_done) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        }

        return super.onOptionsItemSelected(item);
    }
}
