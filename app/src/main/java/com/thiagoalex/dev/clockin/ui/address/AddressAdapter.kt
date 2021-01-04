package com.thiagoalex.dev.clockin.ui.address

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thiagoalex.dev.clockin.ui.address.AddressInputFragment.Companion.INPUT


class AddressAdapter(
    fm: Fragment,
    val inputs: List<String>
) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return inputs.size
    }

    override fun createFragment(position: Int): Fragment {

        val fragment = AddressInputFragment()
        fragment.arguments = Bundle().apply {
            putString(INPUT, inputs.get(position))
        }
        return fragment
    }
}