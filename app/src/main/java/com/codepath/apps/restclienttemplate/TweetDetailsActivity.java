package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static android.widget.Toast.LENGTH_SHORT;

public class TweetDetailsActivity extends AppCompatActivity {

    ImageView ivFullProfilePictrure;
    TextView tvProfileName;
    TextView tvProfileScreeenName;
    TextView tvBodyText;
    TextView tvTime;
    TextView tvRetweet;
    TextView tvFavorite;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_details);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_square_twitter);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ivFullProfilePictrure = findViewById(R.id.ivFullProfilePicture);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvProfileScreeenName = findViewById(R.id.tvProfileScreenName);
        tvBodyText = findViewById(R.id.tvBodyText);
        tvTime = findViewById(R.id.tvTime);
        tvRetweet = findViewById(R.id.tvRetweet);
        tvFavorite = findViewById(R.id.tvFavorites);
        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        Log.i("DetailActivity", "tweet " +tweet.user.name );

        tvBodyText.setText(tweet.body);
        tvProfileName.setText(tweet.user.name);
        tvProfileScreeenName.setText("@" + tweet.user.screenName);
        tvTime.setText(tweet.createdAt.replace("+0000", ""));
        tvRetweet.setText("Retweets: " + tweet.retweet);
        tvFavorite.setText("Likes: " + tweet.favorites);
        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
        Glide.with(this).load(tweet.user.profileImageUrl).transform(new RoundedCornersTransformation(radius, margin)).into(ivFullProfilePictrure);
    }
}