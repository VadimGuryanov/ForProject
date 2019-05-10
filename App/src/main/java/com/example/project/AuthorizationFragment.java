/*

package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;

public class AuthorizationFragment extends Fragment {

    public static AuthorizationFragment newInstance() {
        AuthorizationFragment fragment = new AuthorizationFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.authorization_activity, container, false);
        super.onCreate(savedInstanceState);
        VK.login(getActivity());
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VK.onActivityResult(requestCode, resultCode, data, new VKAuthCallback() {
            @Override
            public void onLogin(VKAccessToken res) {
//                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
//                intent.putExtra("id", res.getUserId());
//                startActivity(intent);
                int id = res.getUserId();
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                StartFragment startFragment = new StartFragment();
                startFragment.setArguments(bundle);
                openFragment(startFragment);
            }
            @Override
            public void onLoginFailed(int error) {
                getActivity().finish();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_main, fragment)
                .commit();
    }

}

*/