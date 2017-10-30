package com.adityadua.fragmentsdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements HeadlineFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.activity_main)!=null){
            if(savedInstanceState !=null){
                return;
            }
            HeadlineFragment firstFragment = new HeadlineFragment();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.activity_main,firstFragment).commit();

        }
    }


    @Override
    public void onArticleSelected(int position) {

        ArticleFragment articleFragment = (ArticleFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);

        if(articleFragment !=null){
            articleFragment.updateArticleView(position);
        }else {
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION,position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main,newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }


    }
}
