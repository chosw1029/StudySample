package com.ons.studysample.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ons.studysample.R;

import java.util.ArrayList;

/**
 * @author ReStartAllKill
 * @created on 2020-02-19
 * @modified by
 * @updated on
 */
public class ListViewAdapterV2 extends BaseAdapter {

    private Context context;

    //Adapter 가 관리하게 될 데이터 리스트입니다. ( 현재는 빈 리스트이기에 데이터를 채워줘야 합니다. )
    private ArrayList<String> dataList = new ArrayList<>();

    /**
     * LayoutInflater 를 사용하려면 Context 가 필요합니다. Context 는 Activity 또는 Application 타입이기에
     * 현재 클래스에서는 Context 에 접근 할 방법이 없습니다.
     * 따라서 외부에서 Context 를 받아서 이를 이용하도록 합니다.
     * @param context : Activity Context 를 받습니다.
     */
    ListViewAdapterV2(Context context) {
        this.context = context;

        // 데이터 리스트에 데이터들을 추가합니다.
        dataList.add("NewYork02");
        dataList.add("Seoul02");
        dataList.add("Paris02");
        dataList.add("Roma02");
        dataList.add("LA02");
    }

    /**
     * 현재 Adapter 가 관리하고 있는 데이터의 크기를 의미합니다.
     * Adapter 가 관리하는 데이터는 ArrayList 타입으로 선언된 dataList 이겠죠?
     * ArrayList 는 배열과 똑같지만 좀 더 편리한 기능들이 많이 들어가 있는 타입입니다.
     * ArrayList 함수들 = add() 추가, remove() 제거 , get() 가져오기
     * @return 현재 리스트뷰와 연동된 데이터의 크기를 반환해줍니다.
     */
    @Override
    public int getCount() {
        return dataList.size();
    }

    /**
     * 현재 리스트뷰가 보여주고 있는 위치에 해당하는 데이터를 가져오는 함수입니다.
     * 원래 리턴 타입이 Object 인데 편의상 현재 우리는 String 값을 보여주는 리스트뷰이므로
     * String 타입으로 변경했습니다.
     * @param position : 단어 뜻 대로 현재 리스트뷰 상에 보여지고 있는 위치를 의미합니다.
     * @return datList.get(position) = Adapter 가 관리하고 있는 데이터 리스트의 position
     * 위치에 해당하는 데이터를 반환해줍니다.
     */
    @Override
    public String getItem(int position) {
        return dataList.get(position);
    }

    /**
     * 리스트뷰 안에서 반복되는 Item View 각각에게 고유한 ID를 부여해주어야 합니다. ( 식별을 위해 )
     * 가장 간단하게 고유한 값을 주는 방법으로는 해당 View 의 Position 정보를 적용해주면 됩니다.
     * @param position : 단어 뜻 대로 현재 리스트뷰 상에 보여지고 있는 위치를 의미합니다.
     * @return 현재 View 가 위치한 Position 정보를 반환해줍니다.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * @param position : ListView 가 전달해주는 Position 정보
     * @param convertView : ListView 가 화면에 한번 Inflate 를 통해 View 를 생성하고 나면 이 정보를
     *                    convertView 라는 View 객체 안에 저장을 해놓습니다.
     *                    ( Inflate 시킨 View 들을 관리하는 View 라고 생각하면 됩니다. )
     * @param viewGroup : parent 라고도 불리는데, Inflate 를 해서 만든 View 객체를 담을 공간을 의미합니다. ( 부모 )
     *                  이는 Inflate 메소드 중 마지막 옵션인 attachToRoot 의 속성값에 영향을 받습니다.
     *                  이 값이 true 일 경우 부모 View 에 자식으로 들어가게 됩니다.
     *                  false 일 경우는 부모 View 에 자식으로 들어가지 않습니다.
     *                  둘 의 차이가 뭐냐 했을때 이는 매우 깊은 내용이므로 일단 이정도만 알 고 있으면 될 것 같습니다.
     * @return Inflate 해서 만든 View 객체를 반환해줍니다.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        /*
         * V2 는 메모리 효율을 좋게 하기 위해 나온 방식입니다.
         * Screen Size 안에 보여질 만큼만 convertView 를 생성하고 나머지는 놀고 있는 convertView 를
         * 재활용해서 활용하게 됩니다. ( inflate 하는 자체가 리소스 소모가 매우 큰 작업입니다. )
         *
         * convertView == null 이라는 의미는 놀고 있는 convertView 가 없다.
         * 즉, 재활용할 view 가 없다는 의미로 이때는 inflate 를 이용해 view 를 만들어 줍니다.
         */
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_listview, viewGroup, false);
        }

        // 이제 inflate 가 끝났으면, 원하는 객체를 찾아서 데이터 연동 작업을 해줍니다.
        TextView cityName = convertView.findViewById(R.id.cityName);
        cityName.setText(getItem(position));

        return convertView; // XML 을 Inflate 하여 얻은 View 객체를 반환합니다.
    }
}
