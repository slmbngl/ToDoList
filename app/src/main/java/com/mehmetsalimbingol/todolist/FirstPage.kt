package com.mehmetsalimbingol.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class FirstPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_page, container, false)

        // Next button
        val nextButton = view.findViewById<View>(R.id.nextButton)
        nextButton.setOnClickListener {
            // Navigate to HomePage when Next button is clicked
            findNavController().navigate(R.id.action_firstPage_to_homePage)
        }

        return view
    }
}
