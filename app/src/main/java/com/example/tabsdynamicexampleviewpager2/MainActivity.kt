package com.example.tabsdynamicexampleviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tabsdynamicexampleviewpager2.databinding.ActivityMainBinding
import com.example.tabsdynamicexampleviewpager2.viewPagerAdapter.ViewPagerAdapter2
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val NUM_FRAGMENTS = 3
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager2 = binding.viewPager2

        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        // Se crea el adapter
        val adapter = ViewPagerAdapter2(supportFragmentManager, lifecycle)

        for (num in 1..NUM_FRAGMENTS) {
            val pageFragment = PageFragment()
            val bundle = Bundle()
            bundle.putString("name", "Fragment $num")
            bundle.putString("text", getString(R.string.textShow, num))
            pageFragment.arguments = bundle
            adapter.addFragment(pageFragment, "Frg $num")
        }

        // Se asocia el adapter al ViewPager2
        viewPager2.adapter = adapter

        // Carga de los tabs en el tablayout
        TabLayoutMediator(binding.tabLayout, viewPager2) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

    }
}