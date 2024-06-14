package com.grassroots.cineflow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grassroots.cineflow.R;
import com.grassroots.cineflow.adapter.SingleItemAdapter;
import com.grassroots.cineflow.service.BusinessResult;
import com.grassroots.cineflow.service.SingleItemService;
import com.grassroots.cineflow.sqlite.SingleItem;
import com.grassroots.cineflow.utils.CurrentUserUtils;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends Fragment {

    private RecyclerView rvHot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitle();
        initView();
        initAdapter();
    }

    private void initTitle() {
        TextView tvTitle = getView().findViewById(R.id.tv_title);
        tvTitle.setText("电影票");
        tvTitle.setTextColor(getResources().getColor(R.color.black));
        TextView tvBack = getView().findViewById(R.id.tv_back);
        tvBack.setVisibility(View.GONE);
    }

    private void initView() {
        rvHot = getView().findViewById(R.id.rv_hot);
    }

    private void initAdapter() {
        SingleItemAdapter adapter = new SingleItemAdapter();
        rvHot.setAdapter(adapter);
        rvHot.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setList(getSingleItemList());
        adapter.setOnItemAddClickListener(new SingleItemAdapter.OnItemAddClickListener() {
            @Override
            public void onAdd(SingleItem item) {
                item.setUserId(CurrentUserUtils.getCurrentUser().getId());
                BusinessResult<SingleItem> add = SingleItemService.add(item);
                Toast.makeText(getContext(), add.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<SingleItem> getSingleItemList() {
        SingleItem singleItem1 = new SingleItem();
        singleItem1.setType(1);
        singleItem1.setTitle("走走停停");
        singleItem1.setImageId(R.mipmap.img_3);
        singleItem1.setScore("评分：7.9");
        singleItem1.setContent1("导演：龙飞");
        singleItem1.setContent2("主演: 胡歌 / 高圆圆 / 岳红 / 周野芒 / 金靖");
        singleItem1.setPrice("￥30");

        SingleItem singleItem2 = new SingleItem();
        singleItem2.setType(1);
        singleItem2.setTitle("机器人之梦 Robot Dreams");
        singleItem2.setImageId(R.mipmap.img_4);
        singleItem2.setScore("评分：9.0");
        singleItem2.setContent1("导演: 巴勃罗·贝格尔");
        singleItem2.setContent2("主演:  伊万·拉班达 / 阿尔伯特·特里佛·塞加拉");
        singleItem2.setPrice("￥35");

        SingleItem singleItem3 = new SingleItem();
        singleItem3.setType(1);
        singleItem3.setTitle("疯狂的麦克斯：狂暴女神 Furiosa: A Mad Max Saga");
        singleItem3.setImageId(R.mipmap.img_5);
        singleItem3.setScore("评分：7.5");
        singleItem3.setContent1("导演: 乔治·米勒");
        singleItem3.setContent2("主演:  安雅·泰勒-乔伊 / 克里斯·海姆斯沃斯");
        singleItem3.setPrice("￥25");

        SingleItem singleItem4 = new SingleItem();
        singleItem4.setType(1);
        singleItem4.setTitle("谈判专家");
        singleItem4.setImageId(R.mipmap.img_6);
        singleItem4.setScore("评分：7.4");
        singleItem4.setContent1("导演: 邱礼涛");
        singleItem4.setContent2("主演: 刘青云 / 吴镇宇 / 刘德华 / 苗侨伟 / 姜皓文");
        singleItem4.setPrice("￥31");

        SingleItem singleItem5 = new SingleItem();
        singleItem5.setType(1);
        singleItem5.setTitle("扫黑·决不放弃");
        singleItem5.setImageId(R.mipmap.img_7);
        singleItem5.setScore("评分：6.9");
        singleItem5.setContent1("导演: 五百");
        singleItem5.setContent2("主演:  肖央 / 余皑磊 / 范丞丞 / 李诚儒 / 耿乐");
        singleItem5.setPrice("￥27");

        List<SingleItem> list = new ArrayList<>();
        list.add(singleItem1);
        list.add(singleItem2);
        list.add(singleItem3);
        list.add(singleItem4);
        list.add(singleItem5);
        return list;
    }
}
