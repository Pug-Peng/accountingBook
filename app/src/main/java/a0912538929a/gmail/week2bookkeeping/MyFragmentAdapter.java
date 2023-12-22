package a0912538929a.gmail.week2bookkeeping;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {
    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position ==1){
            return new FirstFragment();
        }
        else if (position ==2) {
            return new SecondFragment();
        }
        else if (position == 3) {
            return new ThirdFragment();
        }
        return new FourthFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
