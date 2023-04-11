package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.adapter.GoodsPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {
    private val title = mutableListOf<String>("商品","详情")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        //使用自定义的工具栏替换系统默认导航栏
        setSupportActionBar(tl_head)
        initTabLayout()
        initTabViewPager()
    }

    private fun initTabViewPager() {

        vp_content.adapter = GoodsPagerAdapter(supportFragmentManager,title)
        //在调用类似于监听的方法中的匿名内部类时候，需要用到object
        //利用object关键字表示声明一个匿名实例
        vp_content.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                tab_title.getTabAt(position)!!.select()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    private fun initTabLayout() {
        tab_title.addTab(tab_title.newTab().setText(title[0]))
        tab_title.addTab(tab_title.newTab().setText(title[1]))
        tab_title.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    vp_content.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}


