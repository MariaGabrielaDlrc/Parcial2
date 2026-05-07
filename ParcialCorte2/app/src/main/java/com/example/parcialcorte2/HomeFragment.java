package com.example.parcialcorte2;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    private CircleImageView img1, img2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        img1 = view.findViewById(R.id.imgProfile1);
        img2 = view.findViewById(R.id.imgProfile2);
        Picasso.get().load("https://randomuser.me/api/portraits/men/1.jpg").into(img2);
        Picasso.get().load("https://randomuser.me/api/portraits/men/1.jpg").into(img2);
        Picasso.get().load("https://randomuser.me/api/portraits/men/1.jpg").into(img2);
        Picasso.get().load("https://randomuser.me/api/portraits/men/1.jpg").into(img2);
        Picasso.get().load("https://randomuser.me/api/portraits/men/1.jpg").into(img2);

        return view;
    }
}
