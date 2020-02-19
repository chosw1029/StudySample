package com.ons.studysample.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ons.studysample.R;

import java.util.ArrayList;

/**
 * @author ReStartAllKill
 * @created on 2020-02-19
 * @modified by
 * @updated on
 */
public class ListViewAdapterV1 extends BaseAdapter {

    private Context context;
    private ArrayList<String> dataList = new ArrayList<>();

    private ListViewAdapterV1(Context context) {
        this.context = context;
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
     *                  ( 사실상 저도 잘 모릅니다... )
     * @return Inflate 해서 만든 View 객체를 반환해줍니다.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        /*
         * XML 파일을 객체화 ( = 메모리에 올리는, Inflation ) 시키기 위해 LayoutInflater 객체를 가져옵니다.
         * 여러가지 메소드를 이용해서 가져올 수 있는데 아래와 같이도 가능합니다.
         * LayoutInflater inflater = LayoutInflater.from(context);
         */
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // LayoutInflater 를 이용하여 inflate 시켜 XML 의 파일을 View 객체로 변환시킵니다.
        View view = inflater.inflate(R.layout.item_listview, viewGroup, false);


        return null;
    }
}
