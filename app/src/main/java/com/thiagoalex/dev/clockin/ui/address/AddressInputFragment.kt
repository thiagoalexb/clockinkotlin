package com.thiagoalex.dev.clockin.ui.address

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.thiagoalex.dev.clockin.R


class AddressInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_address_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.takeIf { it.containsKey(INPUT) }?.apply {
            val input: TextInputLayout = view.findViewById(R.id.input_text_input_layout)
            input.hint = getString(INPUT).toString()
        }
    }

    companion object {
        const val INPUT = "INPUT"
    }
}