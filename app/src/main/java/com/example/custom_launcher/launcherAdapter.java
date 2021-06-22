package com.example.custom_launcher;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class launcherAdapter extends BaseAdapter {


    //필드
    Context myContext;
    List<ResolveInfo> MyAppList;
    PackageManager myPackageManager;

    //생성자
    public launcherAdapter(Context myContext,List<ResolveInfo> MyAppList, PackageManager myPackageManager){
        //생성자의 인자로전달된 값을 필드에 저장
        this.myContext = myContext;
        this.MyAppList = MyAppList;
        this.myPackageManager = myPackageManager;
    }


    //모델의 아이템 갯수를 리턴
    @Override
    public int getCount() {
        return MyAppList.size();
    }

    //인자로 전달된 position 에 인덱스에 해당하는 아이템 리턴
    @Override
    public Object getItem(int position) {
        return MyAppList.get(position);
    }

    //인자로 전달된 position 인덱스에 아이템 아이디가 있다면 리턴 없으면 position 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }


    //view 를 만들어서 리턴하거나 이미 존재하는 view 를 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
//            imageView = new ImageView(myContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView)convertView;
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.image);
        ResolveInfo resolveInfo = MyAppList.get(position);
        imageView.setImageDrawable(resolveInfo.loadIcon(myPackageManager));

        return imageView;
    }
}
