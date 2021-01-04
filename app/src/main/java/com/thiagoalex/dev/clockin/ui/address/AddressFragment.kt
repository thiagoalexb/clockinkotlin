package com.thiagoalex.dev.clockin.ui.address

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.thiagoalex.dev.clockin.R
import kotlinx.android.synthetic.main.fragment_address.*
import permissions.dispatcher.*


class AddressFragment : Fragment() {

    private lateinit var inputs: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        setElements()

        setEvents()
    }

    private fun setElements(){

        inputs = emptyList()

        setViewPager()
    }

    private fun setEvents(){

        action_text_view.setOnClickListener {

            val index = view_pager.currentItem + 1;

            view_pager.setCurrentItem(index, true)

            if(index >= inputs.size) return@setOnClickListener

            setButtons(inputs[index])
        }

        back_text_view.setOnClickListener {

            val index = view_pager.currentItem - 1;

            view_pager.setCurrentItem(index, true)

            setButtons(inputs[index])
        }
    }

    private fun setViewPager() {

        view_pager.isUserInputEnabled = false
        view_pager.adapter = AddressAdapter(this, getInputs())
    }

    private fun getInputs(): List<String> {

        if(inputs.isNotEmpty()) return inputs

        inputs = listOf(
             getString(R.string.state),
             getString(R.string.city),
             getString(R.string.neighborhood),
             getString(R.string.street),
             getString(R.string.number))

        return inputs
    }

    fun setButtons(input: String) {

        if(input.equals(getString(R.string.state)))
            back_text_view.visibility = View.GONE
        else
            back_text_view.visibility = View.VISIBLE

        if(input.equals(getString(R.string.number)))
            action_text_view.text = getString(R.string.save)
        else
            action_text_view.text = getString(R.string.next)
    }
}