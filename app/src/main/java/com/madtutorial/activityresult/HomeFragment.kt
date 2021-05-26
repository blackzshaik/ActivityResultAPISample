package com.madtutorial.activityresult

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class HomeFragment : Fragment() {

    private val secondActivityWithResult =
        registerForActivityResult(CustomContractParcelable<SampleModel>()) { result ->
            if (result != null) {
                resultTextView.text = result.description
            }
        }

    private lateinit var getResultButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        getResultButton = view.findViewById(R.id.getResultButton)
        resultTextView = view.findViewById(R.id.resultTextView)

        getResultButton.setOnClickListener {
            secondActivityWithResult.launch(Intent(requireContext(), SecondActivity::class.java))
        }
    }

}