package com.example.hospitalfinder.ui.home


import androidx.fragment.app.viewModels
import com.example.hospitalfinder.R
import com.example.hospitalfinder.base.BaseFragment
import com.example.hospitalfinder.base.ViewEvent
import com.example.hospitalfinder.base.ViewState
import com.example.hospitalfinder.databinding.FragmentHomeBinding
import com.example.hospitalfinder.ui.BookmarkFragment
import com.example.hospitalfinder.ui.MapFragment
import com.example.hospitalfinder.ui.adapter.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()


    private val tabConfigurationStrategy =
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.icon = resources.obtainTypedArray(R.array.home_tab_icon).getDrawable(position)
        }

    override fun initUi() {
        val list = listOf(MapFragment(), BookmarkFragment())

        val pagerAdapter =
            FragmentPagerAdapter(list, childFragmentManager, viewLifecycleOwner.lifecycle)

        with(binding) {
            viewPager.adapter = pagerAdapter
            viewPager.offscreenPageLimit = list.size
            viewPager.isUserInputEnabled = false
            TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy).attach()
        }
    }

    override fun onChangedViewState(state: ViewState) {

    }

    override fun onChangeViewEvent(event: ViewEvent) {
        when (event) {
            is HomeViewEvent.MoveItem -> {
                binding.viewPager.setCurrentItem(INDEX_MAP_FRAGMENT, false)
            }
        }
    }

    companion object {
        private const val INDEX_MAP_FRAGMENT = 0
    }

}