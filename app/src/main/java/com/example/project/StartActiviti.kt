package com.example.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView

class StartActiviti : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.start_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lottie_anim = view.findViewById<LottieAnimationView>(R.id.lottie_anim)
        val lottieAnimationView: LottieAnimationView = lottie_anim
        lottieAnimationView.playAnimation()

        val btn = view.findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            (requireActivity() as MainActivity).startApp()
        }
    }
}
