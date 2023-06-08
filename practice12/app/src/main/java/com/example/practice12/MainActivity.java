package com.example.practice12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview);
        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);
        Button button3 = findViewById(R.id.btn3);
        final Post[] post1 = new Post[1];

        button1.setOnClickListener(view -> NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(5)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();
                        post1[0] = post;

                        textView.setText("");
                        textView.append(post.getId() + "\n");
                        textView.append(post.getUserId() + "\n");
                        textView.append(post.getTitle() + "\n\n");
                        textView.append(post.getBody() + "");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                        textView.setText("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                }));

        button2.setOnClickListener(view -> NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                        List<Post> postList = response.body();

                        textView.setText("IDs: ");
                        for (Post post : postList) {
                            textView.append(post.getId() + " ");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                        textView.setText("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                }));

        button3.setOnClickListener(view -> NetworkService.getInstance()
                .getJSONApi()
                .postData(post1[0])
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textView.setText("");
                        textView.append(post.getId() + "\n");
                        textView.append(post.getUserId() + "\n");
                        textView.append(post.getTitle() + "\n\n");
                        textView.append(post.getBody() + "");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                        textView.setText("Post data doesn't exist! Please click on first button!");
                        t.printStackTrace();
                    }
                }));
    }
}