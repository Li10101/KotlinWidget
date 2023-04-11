package com.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.complex.fragment.BookCoverFragment
import com.example.complex.fragment.BookDetailFragment

class GoodsPagerAdapter(fm:FragmentManager,private val titles:MutableList<String>): FragmentPagerAdapter(fm) {
    override fun getCount(): Int =titles.size

    override fun getItem(position: Int): Fragment  = when(position){
        0 ->BookCoverFragment()
        1 ->BookDetailFragment()
        else ->BookCoverFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? =titles[position]
}