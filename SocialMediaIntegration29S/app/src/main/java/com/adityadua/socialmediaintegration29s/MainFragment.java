package com.adityadua.socialmediaintegration29s;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by AdityaDua on 28/11/17.
 */

public class MainFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,View.OnClickListener{

    SignInButton signInButton;
    TextView fName,lName;
    GoogleApiClient googleApiClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment,container,false);
        fName = (TextView)view.findViewById(R.id.first_name);
        lName = (TextView)view.findViewById(R.id.last_name);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .enableAutoManage((FragmentActivity) getActivity(),this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();


        signInButton = (SignInButton)view.findViewById(R.id.sign_in_button);

        signInButton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        googleApiClient.connect();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        googleApiClient.disconnect();
    }

    @Override
    public void onClick(View v) {

        Intent i = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(i,9001);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 9001){
            GoogleSignInResult result = Auth.GoogleSignInApi.
                    getSignInResultFromIntent(data);

            if(result.isSuccess()){
                GoogleSignInAccount gsa = result.getSignInAccount();
                fName.setText("Display N:"+gsa.getDisplayName());
                lName.setText("Last N:"+gsa.getFamilyName());
                
            }else {
                Toast.makeText(getContext().getApplicationContext(), "Login Interrupptteddd", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
